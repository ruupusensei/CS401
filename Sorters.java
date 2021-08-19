import java.util.Random;

public class Sorters {
	
	public void bubbleSort(int [] array){
		if (array != null){
			int temporary;
			for (int i = 0; i < (array.length-1); i++){
				for (int j = 0; j < (array.length-i-1); j++){
					if (array[j] > array[j+1]){
						temporary = array[j];
						array[j] = array[j+1];
						array[j+1] = temporary;
					}
				}
			}
		} else {
			System.out.println("ERROR: Null array reference.");
		}	
	}

	public void selectionSort(int [] array){
		if (array != null){
			int temp;
			int max;
			for (int i = 0; i < array.length - 1; i++){
				max = 0;
				for (int j = 0; j < array.length-i-1; j++){
					if (array[j] < array[j+1]){
						max = j+1;
					}
				}
				temp = array[max];
				array[max] = array[array.length - i - 1];
				array[array.length - i - 1] = temp;
			}
		} else {
			System.out.println("ERROR: Null array reference.");
		}	
	}
	
	public void insertionSort(int [] array){
		if (array != null){
			int j, temp;
			for (int i = 1; i < array.length; i++ ) {
				j = i;
				temp = array[i];
				while (j != 0 && array[j - 1] > temp){
				  array[j] = array[j - 1];
				  j--;
				}
				array[j] = temp;
			}
		} else {
			System.out.println("ERROR: Null array reference.");
		}	
	}
	
	public void shellSort(int [] array){
		
		if (array != null){
			int n = array.length;
			
			for (int gap = n /2; gap > 0; gap /= 2) {
				
				for (int i = gap; i < n; i++) {
				
					int temp = array[i];
					int j;
					for (j = i; j >= gap && array[j - gap] > temp; j-=gap) {
						array[j] = array[j-gap];
					}
					array[j] = temp;
				}
			}
		} 
		
		else {
			System.out.println("ERROR: Null array reference.");
		}	
	}
	
	public void mergeSort(int[] array){

		this.mergeSortRecursive(array, 0, array.length - 1);
	}
	
	private void mergeSortRecursive(int[] array, int low, int high) {
		
		if ( low < high ) { 
		
			int middle = ( high + low ) / 2; //find the middle point to split the array
			this.mergeSortRecursive(array, low, middle); // call recursively to sort the lower half
			this.mergeSortRecursive(array, middle + 1, high); // call recursively to sort the upper half
			//once  the array is broken fully into subarrays of length 1, merge 
			this.merge(array, low, middle, high);
		}
	}
	
	private void merge(int[] array, int low, int middle, int high) {
		
		int[] leftArray = new int[ middle - low + 1]; //create left and right temp arrays
		int[] rightArray = new int[high - middle];
		
		for ( int i = 0; i < leftArray.length; i++) { //copy array data into temp arrays 
			leftArray[i] = array[low + i];
		}
		for ( int i = 0; i < rightArray.length; i++) {
			rightArray[i] = array[i + middle + 1];
		}
		
		int left = 0; //index for tracking left sub array
		int right = 0; //index for tracking right sub array
		
		for ( int i = low; i < high + 1; i++) { // runs through entire array given in method parameter
			if ( left < leftArray.length && right < rightArray.length) { // stops if either index is out of bounds
				if (leftArray[left] <= rightArray[right]) { // if left array value is less than right, copy left into original array
					array[i] = leftArray[left];
					left++; // move up the sub array
				}
				else { // left is greater than right, so copy right value
					array[i] = rightArray[right];
					right++; // move up the sub array
				}
			}
			//only one of the below 2 conditions is ever met at a time 
			else if (left < leftArray.length) { //copy any leftover values from left array
				array[i] = leftArray[left];
				left++;
			}
			else if (right < rightArray.length) { // copy any leftover values from right array
				array[i] = rightArray[right];
				right++;	
			}
		}
	}
	
	public void quickSort(int[] array){
		this.quickSortRecursive(array, 0, array.length -1);
	}
		
	private void quickSortRecursive(int[] array, int low, int high) {
		
		if (low < high + 1) {
			int partitionIndex = this.partition(array, low, high);
			this.quickSortRecursive(array, low, partitionIndex -1); //sort left partition
			this.quickSortRecursive(array, partitionIndex + 1, high); // sort right partition
		}
	}
	
	private int partition(int[] array, int low, int high) {
		
		this.swap(array, low, this.getRandomPivot(low, high));
		
		int current = low + 1;
		
		for (int i = current; i <= high; i++) {
			if (array[i] < array[low]) {
				swap(array, i, current);
				current++;	
			} 
		}
		swap(array, low, current -1);
		return current - 1; 
	}
	
	private void swap(int[] array, int index1, int index2) {
		int temp;
		temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
	private int getRandomPivot(int low, int high) {
		Random random = new Random();
		return random.nextInt((high - low) + 1 ) + low;
	}
}
