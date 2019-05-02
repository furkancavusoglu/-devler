#include <stdio.h>


void reverse(char s[]);

int main(void){
    int i;
	char array[]= {'a','b','c','d','e','f','g','h'};
    reverse(array);
    for(i=0; i<8;i++)
		printf("%c, ",array[i]);
   
    return 0;
}

void reverse(char s[]){
	int beg,end;
	char temp;
	
	for(end=0;s[end]!='\0';++end);
	end--;
	if(s[end-1]=='\n');
	end--;
	
	for(beg=0;beg<end ;beg++, end-- ){
		temp=s[beg];
		s[beg]=s[end];
		s[end]=temp;
	}
}




