#include <stdio.h>
#include <stdlib.h>
int main()
{
    int weights[]={10,20,25,5};
    int prices[]={60,100,175,40};
    int ratio[4];
    int i=0;
    for(i=0;i<4;i++)
    {
        ratio[i]=prices[i]/weights[i];
    }
  
    for(i=0;i<4;i++)
    {
        int j=i+1;
        int key=ratio[j];
        int key1=prices[j];
        int key2=weights[j];
        while(j>0&&key<ratio[j-1])
        {
            ratio[j]=ratio[j-1];
            prices[j]=prices[j-1];
            weights[j]=weights[j-1];
            j--;
        }
        ratio[j]=key;
        prices[j]=key1;
        weights[j]=key2;
    }
    for(i=0;i<4;i++)
    {
        printf("%d\t",weights[i]);
    }
int bag=45;
i=3;int sum=0;
while(bag>=0&&weights[i]>=bag)
{
    bag=bag-weights[i];
    sum=sum+prices[i];
    printf("\nCurrent sum is:%d",sum);
    printf("\nBag size is:%d",bag);
    i=i-1;
}
if(i>0)
sum=sum+bag*ratio[i];
printf("\ntotal sum is:%d",sum);
}