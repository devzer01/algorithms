# include <stdio.h>

/* Function to swap values at two pointers */
void swap (char *x, char *y)
{
    char temp;
    temp = *x;
    *x = *y;
    *y = temp;
}

/* Function to print permutations of string
   This function takes three parameters:
   1. String
   2. Starting index of the string
   3. Ending index of the string. */
void permute(char *a, int i, int n)
{
   int j;
   if (i == n)
     printf("%s\n", a);
   else
   {
        for (j = i; j <= n; j++)
       {
          swap((a+i), (a+j));
          permute(a, i+1, n);
          swap((a+i), (a+j)); //backtrack
       }
   }
}

#define N    5   // number of elements to permute.  Let N > 2
void display(unsigned int *a, unsigned int j, unsigned int i) {
	unsigned int x;
   	for(x = 0; x < N; x++)
   		printf("%d ",a[x]);
    printf("   swapped(%d, %d)\n", j, i);
    //getch();  // Remove comment for "Press any key to continue" prompt.
} // display()

void QuickPerm(void) {
   unsigned int a[N], p[N];
   register unsigned int i, j, tmp; // Upper Index i; Lower Index j

   for(i = 0; i < N; i++) {  // initialize arrays; a[N] can be any type
      a[i] = i + 1;   // a[i] value is not revealed and can be arbitrary
      p[i] = 0;       // p[i] == i controls iteration and index boundaries for i
   }
   display(a, 0, 0);   // remove comment to display array a[]
   i = 1;   // setup first swap points to be 1 and 0 respectively (i & j)
   while(i < N) {
      if (p[i] < i) {
         j = i % 2 * p[i];   // IF i is odd then j = p[i] otherwise j = 0
         tmp = a[j];         // swap(a[j], a[i])
         a[j] = a[i];
         a[i] = tmp;
         display(a, j, i); // remove comment to display target array a[]
         p[i]++;             // increase index "weight" for i by one
         i = 1;              // reset index i to 1 (assumed)
      } else {               // otherwise p[i] == i
         p[i] = 0;           // reset p[i] to zero
         i++;                // set new index value for i (increase by one)
      } // if (p[i] < i)
   } // while(i < N)
} // QuickPerm()

/* Driver program to test above functions */
int main(void) {
//   char a[] = "ABC";
//   permute(a, 0, 2);
//   getchar();
	QuickPerm();
   return 0;
}
