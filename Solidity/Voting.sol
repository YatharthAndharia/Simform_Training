// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;
contract Ballot
{
    struct Voter
    {
        uint weight;
        bool voted;
        uint vote;
        address delegate;
    }
    struct Proposal
    {
        uint voteCount;
        string name;
    }
    address public chairperson;
    mapping(address=>Voter) public voterslist;
    Proposal[] public proposalslist;

    constructor()
    {
        chairperson=msg.sender;
        voterslist[chairperson].weight=1;
        proposalslist.push(Proposal({voteCount:0,name:"Yatharth"}));
        proposalslist.push(Proposal({voteCount:0,name:"Hiren"}));
        proposalslist.push(Proposal({voteCount:0,name:"Aadarsh"}));
    }

    function giveRightToVote(address voter) public
    {
        require(msg.sender==chairperson);
        require(!voterslist[voter].voted);
        require(voterslist[voter].weight==0);
        voterslist[voter].weight=1;
    } 

    function voteTo(uint index) public
    {
        Voter storage sender=voterslist[msg.sender];
        require(sender.weight!=0);
        require(!sender.voted);
        sender.voted=true;
        sender.vote=index;
        proposalslist[index].voteCount+=sender.weight;
    }
    function winnerName() view public returns(string memory)
    {
        uint winnerIndex;
        uint min;
        for(uint i=0;i<proposalslist.length;i++)
        {
            if(proposalslist[i].voteCount>min)
            {
                winnerIndex=i;
                min=proposalslist[i].voteCount;
            }
        }
        return proposalslist[winnerIndex].name;
    }

}
