// SPDX-License-Identifier: GPL-3.0
pragma solidity >= 0.5.0 <= 0.9.0;

// structure
struct Student{
    uint age;
    string name;
}
contract local
{
    Student public st;
    constructor(uint _age,string memory _name)
    {
        st.name=_name;
        st.age=_age;
    }
    function setter(uint _age,string memory _name) public
    {
        Student memory s=Student({
            age:_age,
            name:_name
        });
        st=s;
    }
}