/* https://www.hackerearth.com/practice/basic-programming/operators/basics-of-operators/practice-problems/algorithm/going-to-office-e2ef3feb/ */
import java.util.*;
import java.lang.Math;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        double dist=sc.nextDouble();
        double oc=sc.nextDouble();
        double of=sc.nextDouble();
        double od=sc.nextDouble();
        double cs=sc.nextDouble();
        double cb=sc.nextDouble();
        double cm=sc.nextDouble();
        double cd=sc.nextDouble();
        double coast_online=0,coast_classic=0;

        coast_online=oc+((dist-of)*od);

        coast_classic=cb+Math.floor(dist/cs)*cm+(dist*cd);

        if(coast_classic<coast_online)
        {
            System.out.println("Classic Taxi");
        }
        else
        {
            System.out.println("Online Taxi");
        }
    }
}
