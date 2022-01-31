import {calculateHash as cal_hash} from "./SHA1.js";
import {merkleTree} from "./MerkleTree.js";
//import {hello} from "./SHA1.js";
class Block
{
    constructor(index,timestamp,data,previousHash,nextHash='')
    {
        this.nonsense=0;
        this.index=index;
        this.timestamp=timestamp;
        this.data=data;
        this.previousHash=previousHash;
        this.nextHash=nextHash;
        this.hash=this.calculateHash();
    } 
    calculateHash()
    {
        if(typeof(this.data)=="string")
            return cal_hash(this.nonsense+this.index+this.timestamp+this.data+this.previousHash);    
        return cal_hash(this.nonsense+this.index+this.timestamp+merkleTree(this.data)+this.previousHash);
    }
    mine(difficulty)
    {
        while(this.hash.substring(0,difficulty) != Array(difficulty+1).join("0"))
        {
            this.nonsense++;
            this.hash=this.calculateHash();
        }
    }
}
class BlockChain
{
    constructor()
    {
        this.chain=[this.createGenesisBlock()];
        this.difficulty=2;
    }
    createGenesisBlock()
    {
        return new Block(0,"28/01/2022","Genesis Block",'');
    }
    getLatestBlock()
    {
        return this.chain[this.chain.length-1];
    }
    addNewBlock(newBlock)
    {
        newBlock.previousHash=this.getLatestBlock().hash;
        //newBlock.hash=newBlock.calculateHash();
        newBlock.mine(this.difficulty);
        this.getLatestBlock().nextHash=newBlock.hash;
        this.chain.push(newBlock);
    }
    isValid()
    {
        for(let i=1;i<this.chain.length;i++)
        {
            const current_block=this.chain[i];
            const prev_block=this.chain[i-1];
            if(current_block.hash != current_block.calculateHash())
                return false;
            if(current_block.previousHash != prev_block.hash)
                return false;
            if(i<this.chain.length-1)
            {
                const next_block=this.chain[i+1];
                if(current_block.nextHash != next_block.hash)
                    return false;
            }
        }
        return true;
    }
}
var bch=new BlockChain();
bch.addNewBlock(new Block(1,"28/01/2022","Yatharth Paid INR 100 to Aadarsh"));
bch.addNewBlock(new Block(2,"31/01/2022","Aadarsh Paid INR 100 to Yatharth"));
bch.addNewBlock(new Block(3,"31/01/2022",[1,2,3]));
console.log(bch);
//bch.chain[1].data="Hi";
//bch.chain[1].hash=bch.chain[1].calculateHash();
console.log(bch.isValid());
