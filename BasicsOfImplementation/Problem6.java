/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/distribute-chocolates-70c2c2ab/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            long chocolates=sc.nextLong();
            long n=sc.nextLong();
            long left_chocolates=0;
            long min_chocolates=(n*(n+1)/2);
            if(min_chocolates > chocolates)
            {
                System.out.println(chocolates);
            }
            else
            {
                chocolates-=min_chocolates;
                left_chocolates=chocolates%n;
                System.out.println(left_chocolates);
            }
        }
    }
}

