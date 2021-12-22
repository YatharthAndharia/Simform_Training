/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/erasing-the-array-7e9e0400/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int len=sc.nextInt();
            int arr[]=new int[len];
            for(int i=0;i<len;i++)
            {
                arr[i]=sc.nextInt();
            }
            int inversions=0;
            for(int i=0;i<len-1;i++)
            {
                if(arr[i]>arr[i+1])
                {
                    inversions++;
                }
            }
            System.out.println(inversions+1);
        }
    }
}
