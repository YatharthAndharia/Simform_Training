// SPDX-License-Identifier: GPL-3.0
pragma solidity >= 0.5.0 < 0.9.0;

contract local
{
    function store() pure public returns(uint)
    {
        // local variable
        string memory name="Yatharth";
        uint age=21;
        return age;
    }
}