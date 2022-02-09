// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

contract Bank
{
    mapping (address=>uint) account_balance;

    event DepoEther(
        address from,
        address to,
        uint amount
    );
    event WithdrwEther(
        address from,
        address to,
        uint amount
    );

    error InsufficientBalance(
        uint amount,
        uint balance,
        string errmsg
    );

    function depositEther() public payable
    {
        account_balance[msg.sender]+=msg.value;
        emit DepoEther(msg.sender,address(this),msg.value);
    }

    function withdrawEther(uint _amount) public
    {
        uint amount=_amount*(10**16);
        if(account_balance[msg.sender]>=amount)
        {
            account_balance[msg.sender]-=amount;
            payable(msg.sender).transfer(amount);
            emit WithdrwEther(address(this),msg.sender,amount);
        }
        else
        {
            revert InsufficientBalance(amount,account_balance[msg.sender],"Insufficient Balance ):");
        }
    }

    function checkBalance() public view returns(uint)
    {
        return account_balance[msg.sender];
    }
}
