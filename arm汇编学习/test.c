#include<stdio.h>
#include<stdlib.h>
int main(){
    int a=1;
    int *p=malloc(sizeof(int));
    *p = 1234;
    printf("%d\n",*p);
    free(p); 
    printf("%d\n",*p);
    return 0;
}