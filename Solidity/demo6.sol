// SPDX-License-Identifier: GPL-3.0
pragma solidity >= 0.5.0 <= 0.9.0;

// Dynamic Size Array
contract local
{
    uint[] public arr;
    function push_element(uint value) public
    {
        arr.push(value);
    }
    function array_length() public view returns(uint)
    {
        return arr.length;
    }
    function pop_element() public
    {
        arr.pop();
    }
}