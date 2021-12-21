/* https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/split-house-547be0e9/ */

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {

        // Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        char arr[]=str.toCharArray();
        boolean flag=true;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]=='H' && arr[i+1]=='H')
            {
                System.out.println("NO");
                flag=false;
                break;
            }
            if(arr[i]=='.')
            {
                arr[i]='B';
            }
            flag=true;
        }
        if(arr[n-1]!='H')
        {
            arr[n-1]='B';
        }
        //System.out.println(flag);
        if(flag)
        {
            System.out.println("YES");
            for(int i=0;i<n;i++)
            {
                System.out.print(arr[i]+"");
            }
        }
    }
}

