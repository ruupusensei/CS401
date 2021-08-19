
public class SortingTest {
	
	public static void main(String [] args){
	
		int [] before = {2, 1, 0, 5, 7, 8, 3, 4, 11, 10, -1, 9, 22, 18, 34, 33, 45, 37, 78};
		int [] after = null;
		
		Sorters mySorters = new Sorters();
		
		System.out.println("Bubble Sort");
		System.out.println("==========================");
		System.out.println("BEFORE sorting:");
		System.out.println(java.util.Arrays.toString(before));
		after = deepCopy(before);
		mySorters.bubbleSort(after);
		System.out.println("AFTER sorting:");
		System.out.println(java.util.Arrays.toString(after));
		System.out.println();

		System.out.println("Selection Sort");
		System.out.println("==========================");
		System.out.println("BEFORE sorting:");
		System.out.println(java.util.Arrays.toString(before));
		after = deepCopy(before);
		mySorters.selectionSort(after);
		System.out.println("AFTER sorting:");
		System.out.println(java.util.Arrays.toString(after));
		System.out.println();
		
		System.out.println("Insertion Sort");
		System.out.println("==========================");
		System.out.println("BEFORE sorting:");
		System.out.println(java.util.Arrays.toString(before));
		after = deepCopy(before);
		mySorters.insertionSort(after);
		System.out.println("AFTER sorting:");
		System.out.println(java.util.Arrays.toString(after));
		System.out.println();
		
		System.out.println("Shell Sort");
		System.out.println("==========================");
		System.out.println("BEFORE sorting:");
		System.out.println(java.util.Arrays.toString(before));
		after = deepCopy(before);
		mySorters.shellSort(after);
		System.out.println("AFTER sorting:");
		System.out.println(java.util.Arrays.toString(after));
		System.out.println();
		
		System.out.println("Merge Sort");
		System.out.println("==========================");
		System.out.println("BEFORE sorting:");
		System.out.println(java.util.Arrays.toString(before));
		after = deepCopy(before);
		mySorters.mergeSort(after);
		System.out.println("AFTER sorting:");
		System.out.println(java.util.Arrays.toString(after));
		System.out.println();
		
		System.out.println("Quick Sort");
		System.out.println("==========================");
		System.out.println("BEFORE sorting:");
		System.out.println(java.util.Arrays.toString(before));
		after = deepCopy(before);
		mySorters.quickSort(after);
		System.out.println("AFTER sorting:");
		System.out.println(java.util.Arrays.toString(after));
		System.out.println();
		
	}

	public static int[] deepCopy(int [] array){
		int [] arrayCopy = null;
		if (array != null){
			arrayCopy = new int[array.length];
			for (int index = 0; index < array.length; index++){
				arrayCopy[index] = array[index];
			}
		} else {
			System.out.println("ERROR: Null array reference.");
		}
		return arrayCopy;
	}
}
