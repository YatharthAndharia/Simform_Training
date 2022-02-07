// SPDX-License-Identifier: UNLICENSED

pragma solidity 0.8.11;
contract demo{
    uint num;
    function setter(uint _num) public
    {
        num=_num;
    }
    function getter() public view returns(uint)
    {
        return num;
    }
}