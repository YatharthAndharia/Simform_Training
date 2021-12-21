/* https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cartag-948c2b02/ */

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception 
    {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        String tag=sc.next();
        char arr[]=tag.toCharArray();
        /*for(int i=0;i<tag.length();i++)
        {
            System.out.println(arr[i]);
        }*/
        boolean flag=false;
        //System.out.println(arr[2]=='E');
        if(arr[2]!='A'&& arr[2]!='E'&& arr[2]!='I'&& arr[2]!='O'&& arr[2]!='U'&& arr[2]!='Y')
        {
            flag=true;
        }
        if(!flag)
        {
            //System.out.println(flag);
            System.out.println("invalid");
        }
        else
        {
            int first[]=new int[2];
            boolean flag1=false;
            int second[]=new int[3];
            boolean flag2=false;
            int third[]=new int[2];
            boolean flag3=false; 
            int j=0,k=0;
            for(int i=0;i<tag.length();i++)
            {
                if(i<2)
                {
                    first[i]=((int)(arr[i]))-48;
                }
                else if(i==3 || i==4 || i==5)
                {
                    second[j]=((int)(arr[i]))-48;
                    j++;
                }
                else if(i==7 || i==8)
                {
                    third[k]=((int)(arr[i]))-48;
                    k++;
                }
            }
            //System.out.println(first[0]+" "+first[1]);
            //System.out.println((first[0]+first[1])%2==0);
            if(((first[0]+first[1])%2)==0)
            {
                flag1=true;
                //System.out.println("+++++++"+flag1);
            }
            if(((second[0]+second[1])%2)==0 && ((second[2]+second[1])%2)==0)
            {
                flag2=true;
                //System.out.println(flag2);
            }
            if(((third[0]+third[1])%2)==0)
            {
                flag3=true;
                //System.out.println(flag3);
            }
            if(flag1 && flag2 && flag3)
            {
                System.out.println("valid");
            }
            else
            {
                System.out.println("invalid");
            }
        }

    }
}

