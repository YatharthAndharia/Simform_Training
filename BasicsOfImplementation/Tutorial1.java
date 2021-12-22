/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/tutorial/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int len=str.length();
        int arr[]=new int[10];
        for(int i=0;i<10;i++)
        {
            arr[i]=0;
        }
        for(int i=0;i<len;i++)
        {
            if((int)str.charAt(i)>=48 && (int)str.charAt(i)<=57)
            {
                arr[(int)str.charAt(i)-48]++;
            }
        }
        for(int i=0;i<10;i++)
        {
            System.out.println(i+" "+arr[i]);
        }
    }
}
