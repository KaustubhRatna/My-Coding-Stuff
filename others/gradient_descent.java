import java.util.*;
public class gradient_descent {
    public static void main(String args[])
    {
        double x1[]={500,550,475,450,465,525,400,500,535};
        double x2[]={80,75,90,80,75,65,85,60,45};
        double x3[]={30,25,35,20,30,40,33,30,25};
        double x4[]={10,0,20,25,0,15,0,30,0};
        double y[]={17,11,21,23,22,15,25,18,16};
        double pred[]=new double[9];
        double l=0.01,c=0;
        double m[]=new double[9];
        double sse=0;
        int i=0;
        int epoch=1;
        double dm=0,dc=0;
        while(epoch<=10)
        {
            System.out.println("Epoch No.:"+epoch++);
            System.out.println("Current slope is: "+m+" Current intercept is: "+c);
            System.out.println("Predicted Values:");
            for(i=0;i<9;i++)
            {
                pred[i]=m[i]*x[i]+c;
                System.out.println("For "+x[i]+" predicted value = "+pred[i]);
                sse=sse+Math.pow((y[i]-pred[i]),2);
            }
            System.out.println("Sum Of Square Error is:"+sse);
            if(sse<0.005)
            break;
            sse=0;
            System.out.println("Updating slope and intercept");
            for(i=0;i<11;i++)
            {
                dm=dm+(-2*x[i])*(y[i]-pred[i]);
                dc=dc+(-2)*(y[i]-pred[i]);
            }
            System.out.println("dm = "+dm);
            System.out.println("dc = "+dc);
            m=m-l*dm;
            c=c-l*dc;
            dm=0;
            dc=0;
        }
        if(sse==0)
        {
        for(i=0;i<11;i++)
        {
            pred[i]=m*x[i]+c;
            sse=sse+Math.pow((y[i]-pred[i]),2);
        }
        }
        System.out.println("Final Sum Of Square Error is:"+sse);
        System.out.println("Final values of slope and intercept are:");
        System.out.println("slope(m) = "+m);
        System.out.println("intercept(c) = "+c);
    }
    
}
