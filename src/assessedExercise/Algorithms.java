package assessedExercise;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Algorithms {

	/*
	 * Exercise 1a aa - array which requires sorting, p - starting index, r -
	 * initial index of the pivot
	 */
	public static void quicksortA(int[] aa, int p, int r) {
		if (p < r) {
			// q is the index of the pivot after partitioning
			int q = partition(aa, p, r);
			quicksortA(aa, p, q - 1);
			quicksortA(aa, q + 1, r);
		}
	}

	/*
	 * Exercise 1b aa - array which requires sorting, p - starting index, r - index
	 * of the pivot, cutoff - minimum number of elements to continue partitioning
	 */
	public static void quicksortB(int[] aa, int p, int r, int cutoff) {
		quicksortCutoff(aa, p, r, cutoff);
		insertionsort(aa, p, r);
	}

	private static void quicksortCutoff(int[] aa, int p, int r, int cutoff) {
		if (p + cutoff < r) {
			// q is the index of the pivot after partitioning
			int q = partition(aa, p, r);
			quicksortCutoff(aa, p, q - 1, cutoff);
			quicksortCutoff(aa, q + 1, r, cutoff);
		}
	}

	/*
	 * Exercise 1c aa - array which requires sorting p - starting index r - index of
	 * the pivot
	 */
	public static void quicksortC(int[] aa, int p, int r) {
		if (p < r) {
			// q is the index of the pivot after partitioning
			int q = partitionMedian(aa, p, r);
			quicksortC(aa, p, q - 1);
			quicksortC(aa, q + 1, r);
		}
	}

	/*
	 * Exercise 1d aa - array which requires sorting p - starting index r - index of
	 * the pivot
	 */
	public static void quicksortD(int[] aa, int p, int r) {
		if (p < r) {
			// q is an array of size 2
			// q[0] stores the value of the index
			// q[1] stores the number of elements with the same value as the pivot
			int[] q = partitionThreeWay(aa, p, r);
			quicksortD(aa, p, q[0] - 1);
			quicksortD(aa, q[0] + q[1] + 1, r);
		}
	}

	public static void insertionsort(int[] aa, int p, int r) {
		for (int i = p + 1; i <= r; i++) {
			for (int j = i; j > p && aa[j] < aa[j - 1]; j--) {
				swap(aa, j, j - 1);
			}
		}
	}

	public static void mergesort(int a[], int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergesort(a, p, q);
			mergesort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

	private static void merge(int a[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] L = new int[n1 + 1];
		int[] R = new int[n2 + 1];
		for (int i = 0; i < n1; i++)
			L[i] = a[p + i];
		for (int j = 0; j < n2; j++)
			R[j] = a[q + 1 + j];
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
		}
	}

	/*
	 * This method partitions the array and inserts the pivot in the correct
	 * position. The new index of the pivot is returned aa - array which requires
	 * partitioning p - starting index r - ending index (the index of the pivot)
	 */
	private static int partition(int[] aa, int p, int r) {
		int pivotValue = aa[r];
		// i is the greatest index for which the value is smaller than the pivot
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (aa[j] <= pivotValue) {
				i++;
				// Since i is currently an index of a value greater than the pivot
				// swap the value of i with the value of j
				swap(aa, i, j);
			}
		}
		// insert pivot in the correct position
		swap(aa, r, i + 1);
		return i + 1;
	}

	/*
	 * This method selects the pivot based on the median, partitions the array and
	 * inserts the pivot in the correct position. The new index of the pivot is
	 * returned aa - array which requires partitioning p - starting index r - ending
	 * index (the index of the pivot)
	 */
	private static int partitionMedian(int[] aa, int p, int r) {
		int pivotIdx;
		int middle = (p + r) / 2;
		// checking for middle
		if ((aa[p] <= aa[middle] && aa[middle] <= aa[r]) || (aa[r] <= aa[middle] && aa[middle] <= aa[p])) {
			pivotIdx = middle;
		}
		// Checking for r
		else if ((aa[p] <= aa[r] && aa[r] <= aa[middle]) || (aa[middle] <= aa[r] && aa[r] <= aa[p])) {
			pivotIdx = r;
		}
		// Otherwise the median is p
		else {
			pivotIdx = p;
		}
		swap(aa, pivotIdx, r);
		// call partition() to partition the array and return the pivot index
		return partition(aa, p, r);
	}

	/*
	 * This method partitions the array and inserts the pivot in the correct
	 * position. Elements with the same value as the pivot are positioned right
	 * after the pivot. The new index of the pivot and the number of elements with
	 * the same value as the pivot are returned. aa - array which requires
	 * partitioning p - starting index r - ending index (the index of the pivot)
	 */
	private static int[] partitionThreeWay(int[] aa, int p, int r) {
		int pivotValue = aa[r];
		int sameAsPivot = 0;
		// i is the greatest index for which the value is smaller than the pivot
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (aa[j] < pivotValue) {
				i++;
				// Since aa[i] has a value greater than the pivot
				// swap the value of aa[i] with the value of aa[j]
				swap(aa, i, j);
				if (sameAsPivot > 0) {
					// If an element with the same value as the pivot was moved moved to aa[j],
					// aa[i+sameAsPivot] now has a value different to the pivot value
					// Therefore, swap aa[j] with aa[i+sameAsPivot]
					swap(aa, i + sameAsPivot, j);
				}
			} else if (aa[j] == pivotValue) {
				// the values from aa[i+1] up to aa[i+sameAsPivot] should have the same value
				// as the pivot
				sameAsPivot++;
				swap(aa, i + sameAsPivot, j);
			}
		}
		// insert pivot one position greater than the last value equal to the pivot
		swap(aa, r, i + sameAsPivot + 1);
		return new int[] { i + 1, sameAsPivot };
	}

	// swaps two indices of array aa
	private static void swap(int[] aa, int idx1, int idx2) {
		int temp = aa[idx1];
		aa[idx1] = aa[idx2];
		aa[idx2] = temp;
	}
	
	// This function generates random distinct numbers and uses
	// QuadraticTimeQuickSort() to reorder the numbers in a way 
	// that quicksortc would run with complexity O(n^2)
	public static int[] generateArray(int len) {
		Set<Integer> set = new HashSet<Integer>();
		Random rand = new Random(); 
		// Create random integers and add them to the set
		while(set.size() < len) {
			int number = rand.nextInt();
			set.add(number);
		}
		// convert the set to array of int values
		int[] aa = set.stream() 
	            .mapToInt(Integer::intValue) 
	            .toArray();
		
		// reorder indices of array aa
		QuadraticTimeQuickSort(aa, 0, len-1);
		return aa;
	}

	// This function sorts an array in such a way that
	// quicksortc would run with complexity O(n^2)
	// [6,2,7,9,8,1,3,5,0,4] -> [0,2,4,6,8,1,3,5,7,9]
	// [3,6,1,2,8,7,0,4,5] -> [0,2,4,6,8,1,3,5,7]
	private static void QuadraticTimeQuickSort(int[] aa, int p, int r) {
		int n = aa.length;
		// sort the array
		Algorithms.insertionsort(aa, 0, n - 1);
		for (int i = 1; i < n / 2; i += 2) {
			if (n % 2 == 0) {
				// if array has an even number of elements
				swap(aa, i, n - i - 1);
			} else {
				// if array has an odd number of elements
				swap(aa, i, n - i);
			}

		}
		// sort the two halves of the array
		Algorithms.insertionsort(aa, 0, (n - 1) / 2);
		Algorithms.insertionsort(aa, (n - 1) / 2 + 1, n - 1);
	}
	
	

}
