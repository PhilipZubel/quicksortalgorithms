package assessedExercise;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class AssessedExercise {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		for(String fileName: Test.fileNames) {
//			int[] aa = Test.importArray(fileName);
//			System.out.println(Arrays.toString(aa));
//			Algorithms.quicksortD(aa, 0, aa.length -1);
//			System.out.println(Arrays.toString(aa));
//			Algorithms.insertionsort(aa, 0, aa.length -1);
//			System.out.println(Arrays.toString(aa));
//			boolean b = Test.isSorted(aa);
//			System.out.println(fileName+" "+b);
			
			Test.measureTime(fileName, "quicksortd");
		}
		
//		for(int i=2; i<20;i++) {
//			Test.measureTime("intBig.txt", i);
//		}
		
		
		
		
	}
	

}
