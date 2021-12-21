/*https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/mojtaba-prepares-contest-29b2a044/ */
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        // Write your code here
        Scanner sc=new Scanner(System.in);
        int tc=sc.nextInt();
        for(int it=0;it<tc;it++)
        {
            int max_color,min_color;
            int green=sc.nextInt();
            int purple=sc.nextInt();
            if(green>purple)
            {
                max_color=green;
                min_color=purple;
            }
            else
            {
                max_color=purple;
                min_color=green;
            }
            int participants=sc.nextInt();
            int prob1=0,prob2=0;
            int problem_status[][]=new int[participants][2];
            for(int i=0;i<participants;i++)
            {
                for(int j=0;j<2;j++)
                {
                    problem_status[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<participants;i++)
            {
                for(int j=0;j<2;j++)
                {
                    if(j==0 && problem_status[i][j]==1)
                    {
                        prob1++;
                    }
                    else if(j==1 && problem_status[i][j]==1)
                    {
                        prob2++;
                    }
                }
            }
            int min_coast=0;
            if(prob1<prob2)
            {
                min_coast=(prob1*max_color)+(prob2*min_color);
            }
            else
            {
                min_coast=(prob1*min_color)+(prob2*max_color);
            }
            System.out.println(min_coast);
        }
    }
}

