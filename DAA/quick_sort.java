import java.util.*;
public class quick_sort 
{

    public int partition(int a[],int s,int f)
    {
        int pivot=a[f];
        int i=s-1,j=f;
        while(true)
        {
            do{
                i++;
            }while(a[i]<=pivot);
        do
        {
            j--;
        } while(a[j]>=pivot);
        
        if(i<j)
        {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
        }
        else
        {
            int temp=a[j+1];
            a[j+1]=pivot;
            a[f]=temp;

        return  j+1;
        }
    }
        
    }
    public void QuickSort(int a[],int s,int f)
    {
        if(s<f)
        {
            int p=partition(a,s,f);
            QuickSort(a,s,p-1);
            QuickSort(a,p+1,f);
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input size of array");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("Input "+n+" elements to fill the array");
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
        quick_sort ob=new quick_sort();
        ob.QuickSort(a,0,n-1);
        System.out.println("Sorted Array is:");
        for(int i=0;i<n;i++)
        System.out.print(a[i]+" ");
    }  

}
