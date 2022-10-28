
#include<stdio.h>
int main()
{
    int AT[10],BT[10],WT[10],TT[10],n;
    int p,j;
    int burst=0,cmpl_T;
    float Avg_WT,Avg_TT,Total=0;
    printf("Enter number of the process\n");
    scanf("%d",&n);
    printf("Enter Arrival time and Burst time of the process\n");
    printf("AT\tBT\n");
    for(int i=0;i<n;i++)
    {
        scanf("%d%d",&AT[i],&BT[i]);
    }
    int count[10];
    for(int i = 0; i < 10;i++)
    {
      count[i] = -1;
    }
    for(int i = 0; i < n;i++)
    {
      if(count[AT[i]] == -1)
        count[AT[i]] = i;
      else
      {
        j = AT[i];
        p = count[j];
        if(BT[i] < BT[count[j]])
        {
          count[j] = i;
          j++;
          while(count[j] != -1)
            j++;
          count[j] = p;
        }
        else
        {
          while(count[j] != -1)
            j++;
          count[j] = i;
        }


      }
    }

    for(int i = 0; i < 10;i++)
    {
      if(count[i] != -1)
    printf("process %d -> ",count[i]);
  }
  printf("Terminate\n");
}
