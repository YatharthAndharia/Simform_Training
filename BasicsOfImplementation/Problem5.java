/* https://www.hackerearth.com/practice/basic-programming/implementation/basics-of-implementation/practice-problems/algorithm/find-the-vaccine-a60e06ee/ */
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int g_virus=0,c_virus=0;
        int vaccines=sc.nextInt();
        int interaction=0,best=0;
        int len_virus=sc.nextInt();
        String virus_rna=sc.next();
        for(int i=0;i<len_virus;i++)
        {
            if(virus_rna.charAt(i)=='G')
            {
                g_virus++;
            }
            else if(virus_rna.charAt(i)=='C')
            {
                c_virus++;
            }
        }
        for(int i=0;i<vaccines;i++)
        {
            int len=sc.nextInt();
            String vaccine_rna=sc.next();
            //System.out.println("Len="+len);
            int g_vaccine=0,c_vaccine=0;
            for(int j=0;j<len;j++)
            {
                //System.out.println("Char="+vaccine_rna.charAt(j));
                if(vaccine_rna.charAt(j)=='G')
                {
                    g_vaccine++;
                }
                else if(vaccine_rna.charAt(j)=='C')
                {
                    c_vaccine++;
                }
            }
            //System.out.println(((g_virus*c_vaccine)+(g_vaccine*c_virus)));
            if(((g_virus*c_vaccine)+(g_vaccine*c_virus))>interaction)
            {
                best=i+1;
                interaction=((g_virus*c_vaccine)+(g_vaccine*c_virus));
            }
        }
        System.out.println(best);
    }
}
