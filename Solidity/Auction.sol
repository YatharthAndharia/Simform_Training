// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;
contract SimpleAuction
{
    address payable public benificiary;
    uint public auctionEndTime;

    address public highestBidder;
    uint public highestBid;
    
    mapping(address=>uint) public pendingReturns;
    bool ended;
    
    event HighestBidIncreased(address bidder, uint bid);
    event AuctionEnded(address winner,uint bid);

    error AuctionAlreadyEnded();
    error BidNotHighEnough(uint highestBid);
    error AuctionNotEndedYet();
    error AuctionEndAlreadyCalled();
    error BidAlreadyWithdrawn();

    constructor(address payable benificiaryAddress)
    {
        benificiary=benificiaryAddress;
        auctionEndTime=block.timestamp+1000;
    }

    function balance() view public returns(uint)
    {
        return address(this).balance;
    }
    function toBid() public payable
    {
        if(msg.value<=highestBid)
            revert BidNotHighEnough(highestBid);

        if(ended)
            revert AuctionAlreadyEnded();

        pendingReturns[msg.sender]+=msg.value;

        highestBidder=msg.sender;
        highestBid=msg.value;
    }

    function withdraw() public returns(bool)
    {
        if(msg.sender==highestBidder)
        {
            uint amount=pendingReturns[msg.sender]-highestBid;
            if(amount>0)
            {
                pendingReturns[msg.sender]-=amount;
                if(!payable(msg.sender).send(amount))
                {
                    pendingReturns[msg.sender]+=amount;
                    return false;
                }
            }
            else
            {
                revert BidAlreadyWithdrawn();
            }
        }
        else
        {
            uint amnt=pendingReturns[msg.sender];
            if(amnt>0)
            {
                pendingReturns[msg.sender]=0;
                if(!payable(msg.sender).send(amnt))
                {
                    pendingReturns[msg.sender]=amnt;
                    return false;
                }
            }
            else
            {
                revert BidAlreadyWithdrawn();
            }
        }
        return true;
    }

    function endTheAuction() public
    {
        if(benificiary!=msg.sender)
        {
            if(block.timestamp<auctionEndTime)
                revert AuctionNotEndedYet();

            if(ended)
                revert AuctionEndAlreadyCalled();

            ended=true;
            emit AuctionEnded(highestBidder,highestBid);
            benificiary.transfer(highestBid);
        }
        else{
            if(ended)
                revert AuctionEndAlreadyCalled();

            ended=true;
            emit AuctionEnded(highestBidder,highestBid);
            benificiary.transfer(highestBid);
        }
    }
}