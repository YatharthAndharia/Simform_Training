// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;
contract BlindAuction
{
    struct Bid
    {
        bytes32 blindedBid;
        uint deposit;
    }

    address payable public benificiary;
    uint public biddingEnd;
    uint public revealEnd;
    bool public ended;
    
    mapping(address=>Bid[]) public bids;
    mapping(address=>uint) public pendingReturns;

    address public highestBidder;
    uint public highestBid;

    event AuctionEnded(address winner,uint highestBid);

    error TooEarly(uint time);
    error TooLate(uint time);
    error AuctionEndAlreadyCalled();
    modifier onlyBefore(uint time) {
        if (block.timestamp >= time) revert TooLate(time);
        _;
    }
    modifier onlyAfter(uint time) {
        if (block.timestamp <= time) revert TooEarly(time);
        _;
    }

    constructor(uint biddingTime,uint revealTime,address payable benificiaryAddress)
    {
        benificiary=benificiaryAddress;
        biddingEnd=block.timestamp+biddingTime;
        revealEnd=biddingEnd+revealTime;
    }

    uint public ref;
    function toBid(uint value,bool fake,string memory secret) public payable //onlyBefore(biddingEnd)
    {
        bytes32 blindBid=keccak256(abi.encodePacked(value,fake,secret));
        //hash=blindBid;
        bids[msg.sender].push(Bid({
            blindedBid:blindBid,
            deposit:msg.value
        }));
    }

    function toReveal(uint[] calldata values,bool[] calldata fakes,string[] calldata secrets) public //onlyBefore(revealEnd) onlyAfter(biddingEnd)
    {
        uint len=bids[msg.sender].length;
        require(values.length==len && fakes.length==len && secrets.length==len);
        uint refund;
        for(uint i=0;i<len;i++)
        {
            Bid storage bidToCheck=bids[msg.sender][i];
            if(bidToCheck.blindedBid!=keccak256(abi.encodePacked(values[i],fakes[i],secrets[i])))
            {
                continue;
            }
            refund+=bidToCheck.deposit;
            ref=refund;
            if(!fakes[i] && bidToCheck.deposit>=values[i])
            {
                if(placeBid(msg.sender,values[i]))
                    refund-=values[i]*(10**18);
                    //ref=refund;
            }
            bidToCheck.blindedBid=bytes32(0);
        }
        payable(msg.sender).transfer(refund);
    }
    function placeBid(address bidder,uint value) internal returns(bool success)
    {
        if(value<=highestBid)
            return false;
        if(highestBidder != address(0))
        {
            pendingReturns[highestBidder]+=highestBid;
        }
        highestBid=value;
        highestBidder=bidder;
        return true;
    }
    function withdraw() public 
    {
        uint amount = pendingReturns[msg.sender]*(10**18);
        if (amount > 0) {
            pendingReturns[msg.sender] = 0;
            payable(msg.sender).transfer(amount);
        }
    }
    function auctionEnd() public onlyAfter(revealEnd)
    {
        if (ended) revert AuctionEndAlreadyCalled();
        emit AuctionEnded(highestBidder, highestBid);
        ended = true;
        benificiary.transfer(highestBid);
    }
}