/*Problem Statement:https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/make-all-equal-90a21ab2/*/

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr1[]=new int[n];
        int arr2[]=new int [n];
        int copy[]=new int [n];
        for(int i=0;i<n;i++)
        {
            arr1[i]=sc.nextInt();    
        }
        for(int i=0;i<n;i++)
        {
            copy[i]=arr1[i];    
        }
        Arrays.sort(copy);
        for(int i=0;i<n;i++)
        {
            arr2[i]=sc.nextInt();    
        }
        int min=copy[0];
        int count=0;
        int it=0;
        while(it<n)
        {
            for(int i=0;i<n;i++)
            {
                if(arr1[i]>min)
                {
                    arr1[i]-=arr2[i];
                    count++;
                }
            }
            if(arr1[it]<min)
            {
                min=arr1[it];
                it=0;
            }
            else if(arr1[it]<0)
            {
                count=-1;
                break;
            }
            else
                it++;
        }
        System.out.println(count);
    }
}
