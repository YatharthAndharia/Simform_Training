/* https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/practice-problems/algorithm/find-the-numbers-75f24949/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        HashMap<Integer,Boolean> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i],false);
            }
            else
            {
                hm.put(arr[i],true);
            }
        }
        int array[]=new int[2];
        int i=0;
        for(Map.Entry<Integer,Boolean> m:hm.entrySet())
        {
            if(m.getValue())
            {
                array[i]=m.getKey();
                i++;
            }
        }
        Arrays.sort(array);
        System.out.println(array[0]+" "+array[1]);
    }
}

