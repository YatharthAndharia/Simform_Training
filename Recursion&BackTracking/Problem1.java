/* N Queen */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
            /*for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    arr[i][j]=0;
                }
            }*/
        if(recursiveFunction(arr,0,n))
        {
            //System.out.println("YES");
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }    
        else
            System.out.println("NO");
    }
    public static boolean isSafe(int arr[][],int row,int col,int n)
    {
        for(int i=0;i<n;i++)
        {
            if(arr[row][i]==1)
            {
                return false;
            }
        }
        for(int i=row,j=col;i>=0 && j>=0;i--,j--)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        for(int i=row,j=col;i<n && j>=0;i++,j--)
        {
            if(arr[i][j]==1)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean recursiveFunction(int arr[][],int col,int n)
    {
        if(col>=n)
            return true;
        for(int i=0;i<n;i++)
        {
            if(isSafe(arr,i,col,n))
            {
                arr[i][col]=1;
                if(recursiveFunction(arr,col+1,n))
                    return true;
            }
            arr[i][col]=0;
        }
        return false;
    }
}

