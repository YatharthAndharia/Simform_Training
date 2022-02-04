// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

contract Bank
{

    address private owner;



    mapping (address=>uint) list;

    constructor()
    {
        owner = msg.sender;
    }

    function showowner() public view returns(address)
    {
        return owner;
    }
    
    function depositEther() public payable
    {
        list[msg.sender]+=msg.value;
    }

    function WithdrawEther(uint amount) public
    {
        if(list[msg.sender]>=amount)
        {
            payable(msg.sender).transfer(amount*(10**16));
            list[msg.sender]-=amount*(10**16);
            
        }
    }

    function CheckBalance() public view returns(uint)
    {
        return list[msg.sender];
    }
}