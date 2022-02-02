// SPDX-License-Identifier: GPL-3.0
pragma solidity >= 0.5.0 <= 0.9.0;

// loops
contract local
{
    uint[] public arr;
    function for_loop() public
    {
        for(uint i=0;i<5;i++)
        {
            arr.push(i);
        }
    }
    function while_loop() public
    {
        uint index=0;
        while(index<arr.length)
        {
            arr[index]=arr.length-index-1;
            index++;
        }
    }
}