/* https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/staque-1-e790a29f/ */
import java.util.*;
import java.lang.*;
public class TestClass {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();

        long arr[]=new long[n];
        long sum=0,sumK=0;

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextLong();
            if(i>=n-k)
                sumK+=arr[i];
        }

        long max=Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            sum+=arr[i];
            sumK-=arr[n-k+i];
            max=Math.max(max,sum+sumK);
        }
        System.out.println(max);
        sc.close();
    }
}
