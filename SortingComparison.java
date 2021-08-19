import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SortingComparison {
	public static void main(String [] args){
		int [] before = null;
		int [] after = null;
		
		long startTime;
		long endTime;
		long timeElapsed;
		int numberOfRuns = 500; // You can change it
		int size = 2000; // You can change it
		int numberOfAlgorithms = 5;
		int numberOfArraySizes = 3000; // You can change it

		int [] arraySizes = new int[numberOfArraySizes];
		double [][] results = new double[numberOfAlgorithms][numberOfArraySizes];
		
		Sorters mySorters = new Sorters();
		
		for (int k = 0; k < numberOfArraySizes; k++){
			before = generateArray(size);
			arraySizes[k] = size;

			startTime = System.nanoTime();
			for (int i = 0; i < numberOfRuns; i++){
				after = deepCopy(before);
				mySorters.bubbleSort(after);
			}
			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			results[0][k] = (double)timeElapsed/numberOfRuns;

			startTime = System.nanoTime();
			for (int i = 0; i < numberOfRuns; i++){
				after = deepCopy(before);
				mySorters.selectionSort(after);
			}
			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			results[1][k]= (double)timeElapsed/numberOfRuns;
			
			startTime = System.nanoTime();
			for (int i = 0; i < numberOfRuns; i++){
				after = deepCopy(before);
				mySorters.insertionSort(after);
			}
			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			results[2][k] = (double)timeElapsed/numberOfRuns;

			startTime = System.nanoTime();
			for (int i = 0; i < numberOfRuns; i++){
				after = deepCopy(before);
				mySorters.mergeSort(after);
			}
			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			results[3][k] = (double)timeElapsed/numberOfRuns;
			
			startTime = System.nanoTime();
			for (int i = 0; i < numberOfRuns; i++){
				after = deepCopy(before);
				mySorters.quickSort(after);
			}
			endTime = System.nanoTime();
			timeElapsed = endTime - startTime;
			results[4][k] = (double)timeElapsed/numberOfRuns;
			
			size = size + 200;  // You can change it
		}
		save(results, arraySizes);
	}
	
	public static void save(double [][] array, int [] arraySizes){
		if (array != null && arraySizes  != null){
			String [] algorithmNames = {"Bubble Sort", "Selection Sort", "Insertion Sort", "Merge Sort", "Quick Sort"};
			
			FileOutputStream fos = null;
				
			PrintWriter pw = null;
			try {
				fos = new FileOutputStream("results.csv", false);
				
				pw = new PrintWriter(fos);
				
				pw.print("Array size,");
				for (int i = 0; i < arraySizes.length; i++){
					pw.print(arraySizes[i]);
					if (i < arraySizes.length-1){
						pw.print(",");
					} else {
						pw.print("\n");
					}
				}
				
				for (int i = 0; i < array.length; i++){
					pw.print(algorithmNames[i] + ",");
					for (int j = 0; j < array[i].length; j++){
						pw.print(array[i][j]);
						if (j < array[i].length-1){
							pw.print(",");
						} else {
							pw.print("\n");
						}
					}
				}
			} catch (FileNotFoundException fnfe) {
				System.out.println("ERROR: File not found.");
			} finally {
				pw.close();
			}
		}
	}
	
	public static int [] generateArray(int n){
		int [] array = null;
		if (n > 0){
			array = new int[n];
			Random rng = new Random();
			for(int i = 0; i < array.length; i++){
				array[i] = rng.nextInt(1000);
			}
		}
		return array;
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
