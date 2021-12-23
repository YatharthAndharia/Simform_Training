/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/akash-and-diagnol-moves-dfc4f00f/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            long x=sc.nextLong();
            long y=sc.nextLong();
            if(x<0 || y<0 || y>x)
            {
                System.out.println("-1");
            }
            else
            {
                System.out.println(x);
            }
        }
    }
}

