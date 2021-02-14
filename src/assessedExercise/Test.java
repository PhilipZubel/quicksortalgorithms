package assessedExercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;


public class Test {
	
	public static String[] fileNames = { 
			"int10.txt",
			"int50.txt",
			"int100.txt",
			"int1000.txt",
			"int20k.txt",
			"int500k.txt",
			"dutch.txt",
			"intBig.txt",
			};

	// checks if the array a is sorted in ascending order by iterating through
	// all elements in aa - complexity of algorithm O(n)
	public static boolean isSorted(int aa[]) {
		int n = aa.length;
		for (int i = 0; i < n - 1; i++) {
			if (aa[i] > aa[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	// returns an array of integers from the file <filename>
	public static int[] importArray(String fileName) throws FileNotFoundException {
		
		String URL = System.getProperty("user.dir")+"/numbers/"+fileName;
		File file = new File(URL);
		
		// from: https://mkyong.com/java/how-to-get-the-total-number-of-lines-of-a-file-in-java/
	    int lines = 0;
	    try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
	    	while (lnr.readLine() != null);
	    	lines = lnr.getLineNumber();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
		Scanner scanner = new Scanner(file);
		int[] array = new int[lines];
		for (int idx = 0; idx < array.length; idx++) {
			array[idx] = scanner.nextInt();
		}
		scanner.close();
		
		return array;
	}
	
	// This method can be used with quicksortB 
	// measures the time of the sort
	public static void measureTime(String fileName, int cutoff) throws FileNotFoundException {
		int aa[] = importArray(fileName);
		System.out.println("Sorting "+fileName+" cutoff: "+cutoff);
		
		double time1=System.currentTimeMillis();
		//Algorithms.quicksortA(aa, 0, aa.length-1);
		Algorithms.quicksortB(aa, 0, aa.length-1, cutoff);
		
		double time2=System.currentTimeMillis();
		double timeTaken = time2-time1;
		
		System.out.print("Time taken: "+timeTaken + " milliseconds\n");
		boolean b = isSorted(aa);
		System.out.println("Sort successful: "+b+"\n");
	}
	
	// This method can be used with all implemented algorithms except for quicksortB 
	// measures the time of the sort
	public static void measureTime(String fileName, String algorithm) throws FileNotFoundException {
		int aa[] = importArray(fileName);
		System.out.println("Sorting "+fileName);
		
		double time1=System.currentTimeMillis();
		if(algorithm == "quicksorta") {
			Algorithms.quicksortA(aa, 0, aa.length-1);
		}else if(algorithm == "quicksortc"){
			Algorithms.quicksortC(aa, 0, aa.length-1);
		}else if(algorithm == "quicksortd") {
			Algorithms.quicksortD(aa, 0, aa.length-1);
		}else if(algorithm == "insertion") {
			Algorithms.insertionsort(aa, 0, aa.length-1);
		}else {
			System.out.println("algorithm not found");
		}
		
		
		double time2=System.currentTimeMillis();
		double timeTaken = time2-time1;
		
		System.out.print("Time taken: "+timeTaken + " milliseconds\n");
		boolean b = isSorted(aa);
		System.out.println("Sort successful: "+b+"\n");
	}
	
}
