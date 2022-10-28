#include<pthread.h>
#include<stdio.h>
#include<semaphore.h>
#include<sys/types.h>
#include<stdlib.h>
#include<unistd.h>

int buff[5];
sem_t full,empty,mux;

void *producer(void *arg)
{
  int i,j;
  for(i = 0;;i++)
  {
    sem_wait(&empty);
    sem_wait(&mux);
    //crtitial setion
    buff[(j++)%5] = i;
    printf("Producer has produced %d\n",i);
    sleep(1);
    sem_post(&mux);
    sem_post(&full);
  }
}

void *consumer(void *arg)
{
  int i,j;
  for(i = 0;;i++)
  {
    sem_wait(&full);
    sem_wait(&mux);
    //crtitial setion
    printf("Consumer has consumed %d\n",buff[(j++)%5]);
    sleep(1);
    sem_post(&mux);
    sem_post(&empty);
  }
}

int main()
{
  pthread_t tc,tp;
  sem_init(&full,0,0);
  sem_init(&empty,0,5);
  sem_init(&mux,0,1);
  pthread_create(&tc,NULL,consumer,NULL);
  pthread_create(&tp,NULL,producer,NULL);
  pthread_join(tc,NULL);
  pthread_join(tp,NULL);
}
