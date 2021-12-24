/* https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/equal-elements-2-db70c1ae/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int n=sc.nextInt();
            int count_even=0,count_odd=0;
            //int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                //arr[i]=sc.nextInt();
                if(sc.nextInt()%2 == 0)
                {
                    count_even++;
                }
                else
                {
                    count_odd++;
                }
            }
            if(count_even<count_odd)
            {
                System.out.println(count_even);
            }
            else
            {
                System.out.println(count_odd);
            }
        }
    }
}
