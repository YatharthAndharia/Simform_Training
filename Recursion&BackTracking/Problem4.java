/* https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/gcd-strings/ */
import java.util.*;
import java.lang.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            long a=sc.nextLong();
            long b=sc.nextLong();
            String result="";
            String g_string=g(a,b,result);
            String s_string=s(g_string,a);
            //System.out.println(s_string);
            //long ans=(long)Integer.parseInt(s_string,2)%1000000007;
            long ans=decValue(s_string);
            System.out.println(ans);
        }
    }
    public static long decValue(String str)
    {
        long ans=0;
        for(int i=0;i<str.length();i++)
        {
            ans+=(str.charAt(str.length()-i-1)-48)*Math.pow(2,i);
        }
        return ans%(long)(Math.pow(10,9)+7);
    }
    public static String g(long a,long b,String str)
    {
        if(a%b==0)
        {
            str+=1;
            for(int i=0;i<a-1;i++)
            {
                str+=0;
            }
        }
        else
        {
            str+=g(b,a%b,str);
        }
        return str;
    }
    public static String s(String str,long a)
    {
        String s="";
        while(s.length()<a)
        {
            s+=str;
        }
        char arr[]=new char[(int)a];
        for(int i=0;i<a;i++)
        {
            arr[i]=s.charAt(i);
        }
        String res=new String(arr);
        return res;
    }
}

