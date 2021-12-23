/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/set-numbers-bea74f5a/ */
import java.util.*;
import java.lang.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            long n=sc.nextLong();
            if(Math.pow(2,(Math.ceil(Math.log(n)/Math.log(2))))-n==1)
            {
                System.out.println(n);    
            }
            else if(n==1)
            {
                System.out.println(1);    
            }
            else
            {
                double ans=Math.pow((double)2,Math.floor((Math.log(n)/Math.log(2))));
                System.out.println((long)ans-1);
            }
        }
    }
}

