package assessedExercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Test {

	private static String[] fileNames = { "int10.txt", "int50.txt", "int100.txt", "int1000.txt", "int20k.txt",
			"int500k.txt", "intBig.txt", "dutch.txt", };

	private static String[] algorithms = { "quicksorta", "quicksortc", "quicksortd", "insertion", "merge", };

	// returns all the filenames inside numbers - this array must be
	// updated if numbers folder is modified
	public static String[] getFileNames() {
		return fileNames;
	}

	// checks if the array is sorted in ascending order by iterating through
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

	// returns an array of integers from the file <fileName>
	public static int[] importArray(String fileName) throws FileNotFoundException {

		String URL = System.getProperty("user.dir") + "/numbers/" + fileName;
		File file = new File(URL);

		// from:
		// https://mkyong.com/java/how-to-get-the-total-number-of-lines-of-a-file-in-java/
		int lines = 0;
		try (LineNumberReader lnr = new LineNumberReader(new FileReader(file))) {
			while (lnr.readLine() != null)
				;
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

	// returns an array of the computational times required for an algorithm to sort
	// each array in fileNames
	public static double[] getTimes(String algorithm) throws FileNotFoundException {
		double[] times = new double[fileNames.length];
		boolean isSorted = true;
		for (int i = 0; i < fileNames.length; i++) {
			int aa[] = importArray(fileNames[i]);

			double time1 = System.currentTimeMillis();
			switch (algorithm) {
			case "quicksorta":
				Algorithms.quicksortA(aa, 0, aa.length - 1);
				break;
			case "quicksortc":
				Algorithms.quicksortC(aa, 0, aa.length - 1);
				break;
			case "quicksortd":
				Algorithms.quicksortD(aa, 0, aa.length - 1);
				break;
			case "insertion":
				Algorithms.insertionsort(aa, 0, aa.length - 1);
				break;
			case "merge":
				Algorithms.mergesort(aa, 0, aa.length - 1);
				break;
			default:
				System.out.println("Algorithm not found.");
				break;
			}

			double time2 = System.currentTimeMillis();
			double timeTaken = time2 - time1;

			times[i] = timeTaken;

			isSorted = isSorted(aa) && isSorted;
		}
		System.out.println(algorithm+" - Sort successful: " + isSorted);

		return times;
	}

	// returns an array of the computational times required for quicksortB to sort
	// each array in fileNames, cutoff - minimum number of elements in a partition
	// for which sub-partitions are created
	public static double[] getTimesQuicksortB(int cutoff) throws FileNotFoundException {
		double[] times = new double[fileNames.length];
		boolean isSorted = true;
		for (int i = 0; i < fileNames.length; i++) {
			int aa[] = importArray(fileNames[i]);

			double time1 = System.currentTimeMillis();
			Algorithms.quicksortB(aa, 0, aa.length - 1, cutoff);
			double time2 = System.currentTimeMillis();
			double timeTaken = time2 - time1;

			times[i] = timeTaken;

			isSorted = isSorted(aa) && isSorted;
		}
		System.out.println("quicksortb("+cutoff+") - Sort successful: " + isSorted);

		return times;
	}

	// returns an array of the computational times required for an algorithm to sort
	// the array aa
	public static double getTimeForArray(int[] aa, String algorithm) {
		System.out.println("Sorting using "+algorithm);

		double time1 = System.currentTimeMillis();
		if (algorithm == "quicksorta") {
			Algorithms.quicksortA(aa, 0, aa.length - 1);
		} else if (algorithm == "quicksortc") {
			Algorithms.quicksortC(aa, 0, aa.length - 1);
		} else if (algorithm == "quicksortd") {
			Algorithms.quicksortD(aa, 0, aa.length - 1);
		} else if (algorithm == "insertion") {
			Algorithms.insertionsort(aa, 0, aa.length - 1);
		} else if (algorithm == "merge") {
			Algorithms.mergesort(aa, 0, aa.length - 1);
		} else {
			System.out.println("Algorithm not found.");
		}

		double time2 = System.currentTimeMillis();
		double timeTaken = time2 - time1;

		System.out.print("Time taken: " + timeTaken + " milliseconds\n");
		boolean b = isSorted(aa);
		System.out.println(algorithm+" - Sort successful: " + b + "\n");
		return timeTaken;
	}

	// returns the computational time required for quicksortB to sort
	// the file <fileName>, cutoff - minimum number of elements in a partition
	// for which sub-partitions are created
	public static double getTimeQuicksortBForFile(String fileName, int cutoff) throws FileNotFoundException {
		int aa[] = importArray(fileName);
		System.out.println("Sorting " + fileName + "using quicksortb cutoff: " + cutoff);

		double time1 = System.currentTimeMillis();
		Algorithms.quicksortB(aa, 0, aa.length - 1, cutoff);

		double time2 = System.currentTimeMillis();
		double timeTaken = time2 - time1;

		System.out.print("Time taken: " + timeTaken + " milliseconds\n");
		boolean b = isSorted(aa);
		System.out.println("quicksortb("+cutoff+") - Sort successful: " + b + "\n");
		return timeTaken;
	}

	// returns the computational time required for an algorithm to sort
	// the file <fileName>
	public static double getTimeForFile(String fileName, String algorithm) throws FileNotFoundException {
		int aa[] = importArray(fileName);
		System.out.println("Sorting " + fileName + " using " + algorithm);

		double time1 = System.currentTimeMillis();
		if (algorithm == "quicksorta") {
			Algorithms.quicksortA(aa, 0, aa.length - 1);
		} else if (algorithm == "quicksortc") {
			Algorithms.quicksortC(aa, 0, aa.length - 1);
		} else if (algorithm == "quicksortd") {
			Algorithms.quicksortD(aa, 0, aa.length - 1);
		} else if (algorithm == "insertion") {
			Algorithms.insertionsort(aa, 0, aa.length - 1);
		} else if (algorithm == "merge") {
			Algorithms.mergesort(aa, 0, aa.length - 1);
		} else {
			System.out.println("Algorithm not found.");
		}

		double time2 = System.currentTimeMillis();
		double timeTaken = time2 - time1;

		System.out.print("Time taken: " + timeTaken + " milliseconds\n");
		boolean b = isSorted(aa);
		System.out.println(algorithm+" - Sort successful: " + b + "\n");
		return timeTaken;
	}

	// returns the times required for each algorithm (except for quicksortb) to sort
	// each file in algorithms; every row represents an algorithm and each column
	// represents a different file in fileNames
	public static double[][] getAllTimes() throws FileNotFoundException {
		int col = fileNames.length;
		int row = algorithms.length;
		double[][] array = new double[row][col];
		for (int i = 0; i < row; i++) {
			array[i] = getTimes(algorithms[i]);
		}

		return array;
	}

	// returns the times required for quicksortB to sort
	// each file in algorithms; every row represents a different cutoff value (from
	// 1 to 24) and each column represents a different file in fileNames
	public static double[][] getAllTimesQuicksortB() throws FileNotFoundException {
		int col = fileNames.length;
		int row = 24;
		double[][] array = new double[row][col];
		for (int i = 1; i < row + 1; i++) {
			array[i - 1] = getTimesQuicksortB(i);
		}
		return array;
	}

	// stores the computational times of all algorithms (except for quicksortB) in a
	// csv file
	public static void storeTimesCSV() throws IOException {

		double[][] numbers = getAllTimes();

		// from
		// https://stackoverflow.com/questions/19493084/write-values-from-multidimensional-array-to-csv-file-in-java
		BufferedWriter br = new BufferedWriter(new FileWriter("results.csv"));
		StringBuilder sb = new StringBuilder();

		sb.append(","); // leave first cell blank
		for (String fileName : fileNames) {
			sb.append(fileName);
			sb.append(",");
		}
		sb.append("\n");
		int algorithmCount = 0;
		for (double[] row : numbers) {
			sb.append(algorithms[algorithmCount]);
			sb.append(",");
			for (double number : row) {
				sb.append(number);
				sb.append(",");
			}
			sb.append("\n");
			algorithmCount++;
		}
		br.write(sb.toString());
		br.close();

		System.out.println("Results written to results.txt");
	}

	// stores the computational times of quicksortB for different cutoff values in a
	// csv file
	public static void storeTimesQuicksortBCSV() throws IOException {

		double[][] numbers = getAllTimesQuicksortB();

		// from
		// https://stackoverflow.com/questions/19493084/write-values-from-multidimensional-array-to-csv-file-in-java
		BufferedWriter br = new BufferedWriter(new FileWriter("resultsb.csv"));
		StringBuilder sb = new StringBuilder();

		sb.append(","); // leave first cell blank
		for (String fileName : fileNames) {
			sb.append(fileName);
			sb.append(",");
		}
		sb.append("\n");
		int algorithmCount = 1;
		for (double[] row : numbers) {
			sb.append("quicksortb(" + algorithmCount + ")");
			sb.append(",");
			for (double number : row) {
				sb.append(number);
				sb.append(",");
			}
			sb.append("\n");
			algorithmCount++;
		}
		br.write(sb.toString());
		br.close();

		System.out.println("Results written to resultsb.txt");
	}

}
