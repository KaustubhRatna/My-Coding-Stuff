import java.util.*;
public class binomial_coefficient 
{
    int Binomial(int n,int k)
    {
        if(k==0 || k==n)
        return 1;
        else if(k>0 && k<n)
        return Binomial(n-1, k-1)+Binomial(n-1, k);
        else
        return 0;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input n and k");
        int n=sc.nextInt();
        int k=sc.nextInt();
        binomial_coefficient ob=new binomial_coefficient();
        int c=ob.Binomial(n, k);
        System.out.println(c);
    }    
}
