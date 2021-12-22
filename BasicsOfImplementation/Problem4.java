/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/excursion-2d080f3a/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int k=sc.nextInt();
            int rooms=0;
            if(n%k!=0)
            {
                rooms+=(n/k)+1;
            }
            else
            {
                rooms+=(n/k);
            }
            if(m%k!=0)
            {
                rooms+=(m/k)+1;
            }
            else
            {
                rooms+=(m/k);
            }
            System.out.println(rooms);
        }
    }
}

