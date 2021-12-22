/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/lunch-boxes-019bf2a5/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int lunchboxes=sc.nextInt();
            int schools=sc.nextInt();
            int A[]=new int[schools];
            int max=0;
            for(int i=0;i<schools;i++)
            {
                A[i]=sc.nextInt();
            }
            Arrays.sort(A);
            for(int i=0;lunchboxes>0 && i<schools;i++)
            {
                if(lunchboxes>=A[i])
                {
                    lunchboxes-=A[i];
                    max++;
                }
            }
            System.out.println(max);
        }
    }
}

