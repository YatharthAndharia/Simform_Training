// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;
contract RemotePurchase
{
    uint public value;
    address payable public buyer;
    address payable public seller;

    enum State{Created,Locked,Released,Inactive}
    State public state;

    modifier condition(bool condition_)
    {
        require(condition_);
        _;
    }

    error OnlyBuyer();
    error OnlySeller();
    error InState();
    error ValueNotEven();

    modifier onlyBuyer() {
        if (msg.sender != buyer)
            revert OnlyBuyer();
        _;
    }
    modifier onlySeller() {
        if (msg.sender != seller)
            revert OnlySeller();
        _;
    }
    modifier inState(State state_) {
        if (state != state_)
            revert InState();
        _;
    }

    event Aborted();
    event PurchaseConfirmed();
    event ItemRecieved();
    event SellerRefunded();

    constructor() payable
    {
        seller=payable(msg.sender);
        value=msg.value/2;
        if((2*value)!=msg.value)
            revert ValueNotEven();
        
    }

    function abort() public onlySeller() inState(State.Created)
    {
        emit Aborted();
        state=State.Inactive;
        seller.transfer(address(this).balance);
    }

    function confirmPurchase() public payable condition(msg.value==(2*value)) inState(State.Created)
    {
        emit PurchaseConfirmed();
        buyer=payable(msg.sender);
        state=State.Locked;
    }

    function confirmeRecieved() public onlyBuyer inState(State.Locked)
    {
        emit ItemRecieved();
        state=State.Released;
        buyer.transfer(value);
    }

    function refundSeller() public onlySeller inState(State.Released)
    {
        emit SellerRefunded();
        state=State.Inactive;
        seller.transfer(3*value);
    }
}