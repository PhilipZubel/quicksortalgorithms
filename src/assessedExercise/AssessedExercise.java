package assessedExercise;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class AssessedExercise {

	public static void main(String[] args) throws IOException {

//		Exercise 1
//		int[] aa = Test.importArray("int10.txt");
//		int cutoff = 5;
//		int p =0;
//		int r = aa.length-1;
//		// run simple version of quicksort
//		Algorithms.quicksortA(aa, p, r);
//		// run quicksort which uses insertionsort
//		Algorithms.quicksortB(aa, p, r, cutoff);
//		// run median-of-three quicksort 
//		Algorithms.quicksortC(aa, p, r);
//		// run 3-way-quicksort
//		Algorithms.quicksortD(aa, p, r);


//		Exercise 2
//		import file to array; make sure the file is in the numbers directory 
		int[] aa = Test.importArray("int10.txt");
//		checks if aa array is sorted
		boolean isTrue = Test.isSorted(aa);
//		returns the time needed to sort aa using quicksortA
//		valid algorithms: "quicksorta", "quicksortc", "quicksortd", "merge", "insertion"
		double time = Test.getTimeForArray(aa, "quicksorta");
// 		returns the time needed to sort the array in the specified file
		time = Test.getTimeForFile("int10.txt", "quicksorta");
//      returns the times needed to sort the arrays for each file
		double[] times = Test.getTimes("quicksorta");
// 		returns running times for all files for all algorithms stated earlier
		double[][] allTimes = Test.getAllTimes();
//		stores the values of Test.getAllTimes() in CSV format
		Test.storeTimesCSV();
// --------------------------------------------------------------------------------------
//		returns the time needed to sort using quicksortB with a cutoff value = 5
		time = Test.getTimeQuicksortBForFile("int10.txt", 5);
//		returns the time needed to sort aa using quicksortB for a cutoff value = 5
		times = Test.getTimesQuicksortB(5);
// 		returns running times for all files for quicksortB for cutoffs between 1-24 
		allTimes = Test.getAllTimesQuicksortB();
//		stores the values of Test.getAllTimesQuicksortB() in CSV format
		Test.storeTimesQuicksortBCSV();
		
		
		
		//Test.storeTimesCSV();
		//Test.storeTimesQuicksortBCSV();
		
//		String[] files = Test.getFileNames();
//		System.out.println("Files:");
//		System.out.println(Arrays.toString(files));
//		
//		double[] testTime = Test.getTimes("quicksorta");
//		System.out.println("quicksortA");
//		System.out.println(Arrays.toString(testTime));
//		
//		double [] testTime = Test.getTimesQuicksortB(11);
//		System.out.println("quicksortB 11");
//		System.out.println(Arrays.toString(testTime));
//		
//		double [] testTime = Test.getTimes("quicksortc");
//		System.out.println("quicksortC");
//		System.out.println(Arrays.toString(testTime));
		
//		double[] testTime = Test.getTimes("quicksortd");
//		System.out.println("quicksortD");
//		System.out.println(Arrays.toString(testTime));
//		
//		testTime = Test.getTimes("merge");
//		System.out.println("mergesort");
//		System.out.println(Arrays.toString(testTime));
//		
//    	double [] testTime = Test.getTimes("insertion");
//		System.out.println("insertion");
//		System.out.println(Arrays.toString(testTime));
		
//		finding best value for quicksortB 
//		double[][] testTimes = new double[19][8];
//		double[] testTime;
//		for(int i=2; i<20; i++) {
//			testTime = Test.getTimesQuicksortB(i);
//			System.out.println(i+": "+Arrays.toString(testTime));
//			//testTimes[i-2] = testTime;
//		}
		
//		System.out.println("Sorting");
//		int[] aa = Test.importArray("int20k.txt");
//		Algorithms.QuadraticTimeQuickSort(aa, 0, aa.length-1);
//		Test.measureSortingTimeArray(aa, "quicksortc");
//		
//		
//		
}
//	
//	public static void swap(int[] aa , int idx1, int idx2) {
//		int temp = aa[idx1];
//		aa[idx1] = aa[idx2];
//		aa[idx2] = temp;		
//	}
	

}
