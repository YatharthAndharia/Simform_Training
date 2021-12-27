/* https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/divide-number-a410603f/ */
import java.util.*;
import java.lang.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        {
            int tc=sc.nextInt();
            for(int it=0;it<tc;it++)
            {
                int arr[]=new int[100000];
                int n=sc.nextInt();
                int x=0;
                for(int i=1;i<=(int)Math.sqrt(n);i++)
                {
                    if(n%i==0)
                    {
                        arr[x]=i;
                        x++;
                        if(i!=(n/i))
                            arr[x]=(n/i);
                            x++;
                    }
                }
                int len=0;
                for(int i=0;i<10;i++)
                {
                    if(arr[i]!=0)
                    {
                        len++;
                    }
                    else
                    {
                        break;
                    }
                }
                //System.out.println(len);
                int product=-1;
                for(int i=0;i<len;i++)
                {
                    for(int j=0;j<len;j++)
                    {
                        for(int k=0;k<len;k++)
                        {
                            for(int l=0;l<len;l++)
                            {
                                if(arr[i]+arr[j]+arr[k]+arr[l]==n)
                                {
                                    int mul=arr[i]*arr[j]*arr[k]*arr[l];
                                    if(mul>product)
                                    {
                                        product=mul;
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println(product);
            }
        }
    }
}

