package assessedExercise;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class AssessedExercise {

	public static void main(String[] args) throws FileNotFoundException {
		
		
//		String[] files = Test.getFileNames();
//		System.out.println("Files:");
//		System.out.println(Arrays.toString(files));
//		
//		double[] testTime = Test.getTimes("quicksorta");
//		System.out.println("quicksortA");
//		System.out.println(Arrays.toString(testTime));
//		
		double [] testTime = Test.getTimesQuicksortB(11);
		System.out.println("quicksortB 11");
		System.out.println(Arrays.toString(testTime));
//		
//		testTime = Test.getTimes("quicksortc");
//		System.out.println("quicksortC");
//		System.out.println(Arrays.toString(testTime));
//		
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
