// SPDX-License-Identifier: GPL-3.0
pragma solidity >= 0.5.0 <= 0.9.0;

// Fixed Array
contract local
{
    uint[5] public arr=[1,2,3,4,5];
    function setter(uint index,uint value) public
    {
        arr[index]=value;
    }
    function array_length() public view returns(uint)
    {
        return arr.length;
    }
}