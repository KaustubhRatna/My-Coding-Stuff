
#include<stdio.h>

#include<sys/types.h>
#include<stdlib.h>
#include<unistd.h>
int main()
{
    int p=5, abc;
abc=fork();
if (abc==0) 
{
 p = p + 3; 
printf("%d,%d\n", p, &p); 
} 
else
 {
 p = p - 3; 
printf("%d, %d\n", p, &p); 
}
}