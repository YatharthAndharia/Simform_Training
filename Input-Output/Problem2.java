/* https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/is-zoo-f6f309e7/  */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        String input=sc.next();
        //System.out.println(input);
        int x=0,y=0;
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)=='z')
            {
                x++;
            }
            else
            {
                y++;
            }
        }
        if((2*x)==y)
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
}
