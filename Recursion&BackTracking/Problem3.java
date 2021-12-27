/* https://www.hackerearth.com/practice/basic-programming/recursion/recursion-and-backtracking/practice-problems/algorithm/binary-palindrome-4-035e5ad6/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int count=0;
            int i=0;
            int n=sc.nextInt();
            //System.out.println(isPalindrome(bin(n)));
            if(isPalindrome(bin(n)))
            {
                System.out.println(0);
            }
            else
            {
                while(true)
                {
                    if(isPalindrome(bin(n-i)) || isPalindrome(bin(n+i)))
                    {
                        System.out.println(count);
                        //System.exit(0);
                        break;
                    }
                    else
                    {
                        count++;
                        i++;
                    }
                }
            }

        }
    }
    public static boolean isPalindrome(String s)
    {
        //System.out.println(s.length());
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
            {
                //System.out.println("==>"+s.charAt(i)+" "+s.charAt(s.length()-i-1));
                return false;
            }
        }
        return true;
    }
    public static String bin(int n)
    {
        String binary="";
        while(n>0)
        {
            binary+=n%2;
            n/=2;
        }
        char arr[]=new char[binary.length()];
        for(int i=0;i<binary.length();i++)
        {
            arr[binary.length()-i-1]=binary.charAt(i);
        }
        String str=new String(arr);
        return str;
    }
}

