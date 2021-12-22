/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/golf/modulo-strength-4/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int sum=0;
        int in_arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            in_arr[i]=sc.nextInt();
        }
        int count_arr[]=new int[k];
        for(int i=0;i<k;i++)
        {
            count_arr[i]=0;
        }
        for(int i=0;i<n;i++)
        {

            count_arr[in_arr[i]%k]++;
        }
        for(int i=0;i<k;i++)
        {
            sum+=(count_arr[i])*(count_arr[i]-1);
        }
        System.out.println(sum);
    }
}

