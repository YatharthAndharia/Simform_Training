/* https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/fun-game-91510e9f/ */
import java.util.*;
public class TestClass {
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        int arr[]=new int[len];
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();
        //System.out.println(st1.peek());
        for(int i=0;i<len;i++)
        {
            arr[i]=sc.nextInt();
            st2.push(arr[i]);
        }
        for(int i=len-1;i>=0;i--)
        {
            st1.push(arr[i]);
        }
        //int result[]=new int[len];
        String res="";
        //int i=0;
        //System.out.println(st1.pop()+" "+st2.pop());
        while(!(st1.empty() || st2.empty()))
        {
            if(st1.peek()>st2.peek())
            {
                //result[i]=1;
                res+=1;
                st2.pop();
                //i++;
            }
            else if(st1.peek()<st2.peek())
            {
                //result[i]=2;
                res+=2;
                st1.pop();
                //i++;
            }
            else
            {
                //result[i]=0;
                res+=0;
                //i++;
                st1.pop();
                st2.pop();
                
                //System.out.println(st1.empty());
            }
        }
        for(int j=0;j<res.length();j++)
        {
            System.out.print(res.charAt(j)+" ");
        }
    }
}
