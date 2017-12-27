#include <stdlib.h>
#include <stdio.h>
void bubbleSort(int *array, int length) {
	for (int i = 0; i < length; i++) {
		for (int j = 1; j < length; j++) {
			if (array[j] < array[j-1]) {
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
			}
		}
	} 
}

int main(int argc, char **argv){
	int arr[] = {3,4,2,5,3,4,1,4,2};
	bubbleSort(arr, 9);
	for (int i = 0; i < 9; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");
}
