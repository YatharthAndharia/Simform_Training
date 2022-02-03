// SPDX-License-Identifier: GPL-3.0
pragma solidity >= 0.5.0 <= 0.9.0;

// mapping

contract local
{
    struct Student
    {
        uint age;
        string name;
    }
    mapping(uint=>Student) public mp;
    function setter(uint _roll,string memory _name,uint _age) public
    {
        mp[_roll]=Student(_age,_name);
    }
}