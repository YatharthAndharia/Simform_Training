/* https://www.hackerearth.com/practice/basic-programming/operators/basics-of-operators/practice-problems/algorithm/let-us-understand-computer-78476e7a/ */
import java.util.*;
import java.lang.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            long x=sc.nextLong();
            long divisors=0,invalid=0;
            for(long i=1;i<x;i++)
            {
                int bit_div=totalBits(i);
                int bit_ans=totalBits((long)(x/i));
                if(bit_div<bit_ans)
                {
                    invalid+=1;
                }
                else
                {
                    break;
                }
            }
            System.out.println(x-invalid);
        }
    }
    public static int totalBits(long n)
    {
        int count=0;
        while(n>0)
        {
            count++;
            n>>=1;
        }
        return count;
    }
}
