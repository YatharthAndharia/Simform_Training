/* https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/min-cost-2-fe2d3308/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int n=sc.nextInt();
            long c01=sc.nextLong();
            long c10=sc.nextLong();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            long one_at_even=0;
            long one_at_odd=0;
            long zero_at_even=0;
            long zero_at_odd=0;
            for(int i=0;i<n;i++)
            {
                if(i%2==0 && arr[i]==1)
                {
                    one_at_even++;
                }
                else if(i%2==0 && arr[i]==0)
                {
                    zero_at_even++;
                }
                else if(i%2!=0 && arr[i]==1)
                {
                    one_at_odd++;
                }
                else if(i%2!=0 && arr[i]==0)
                {
                    zero_at_odd++;
                }
            }
            long coast_one_at_even=(zero_at_even*c01)+(one_at_odd*c10);
            long coast_zero_at_even=(one_at_even*c10)+(zero_at_odd*c01);
            if(coast_one_at_even<coast_zero_at_even)
            {
                System.out.println(coast_one_at_even);
            }
            else
            {
                System.out.println(coast_zero_at_even);
            }
        }
    }
}

