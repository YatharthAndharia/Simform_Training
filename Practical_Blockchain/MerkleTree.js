import {calculateHash as cal_hash} from "./SHA1.js";
function merkleTree(transactions)
{
    var temp_array=transactions;
    while(temp_array.length!=1)
    {
        if(temp_array.length % 2!=0)
        {
            temp_array.push(temp_array[temp_array.length-1]);
        }
        var arr=new Array();
        var j=0;
        for(let i=0;i<temp_array.length;i+=2)
        {
            arr[j]=cal_hash(temp_array[i])+cal_hash(temp_array[i+1]);
            j++;
        }
        temp_array=arr;
    }
    return cal_hash(temp_array[0]);
}
export {merkleTree};