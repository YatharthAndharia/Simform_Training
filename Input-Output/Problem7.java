/* https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seven-segment-display-nov-easy-e7f87ce0/ */

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        int map_array[]=new int[]{6,2,5,5,4,5,6,3,7,6};
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            String in=sc.next();
            int len=in.length();
            char arr[]=in.toCharArray();
            int matchstick=0;
            for(int i=0;i<len;i++)
            {
                //System.out.println((int)(arr[i])-48);
                matchstick+=map_array[(int)(arr[i])-48];
            }
            while(matchstick>0)
            {
                if(matchstick%2!=0)
                {
                    System.out.print("7");
                    matchstick-=3;
                }
                else
                {
                    System.out.print("1");
                    matchstick-=2;
                }
            }
            System.out.println();
        }
    }
}

