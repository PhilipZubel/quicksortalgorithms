package assessedExercise;

public class Algorithms {

	/* Exercise 1a
	 * aa - array which requires sorting
	 * p - starting index
	 * r - index of the pivot
	 * */
	public static void quicksortA(int[] aa, int p, int r) {
		if(p < r) {
			// q is the index of the pivot after partitioning
			int q = partition(aa, p, r);
			quicksortA(aa, p, q-1);
			quicksortA(aa, q+1, r);
		}
	}

	/* Exercise 1b
	 * aa - array which requires sorting
	 * p - starting index
	 * r - index of the pivot
	 * cutoff - minimum number of elements to switch to insertionsort 
	 * */
	public static void quicksortB(int[] aa, int p, int r, int cutoff) {
		if(p + cutoff < r) {
			// q is the index of the pivot after partitioning
			int q = partition(aa, p, r);
			quicksortA(aa, p, q-1);
			quicksortA(aa, q+1, r);
		}else if (p < r) {
			insertionsort(aa, p, r);
		}
	}

	/* Exercise 1c
	 * aa - array which requires sorting
	 * p - starting index
	 * r - index of the pivot
	 * */
	public static void quicksortC(int[] aa, int p, int r) {
		if(p < r) {
			// q is the index of the pivot after partitioning
			int q = partitionMedian(aa, p, r);
			quicksortA(aa, p, q-1);
			quicksortA(aa, q+1, r);
		}
	}

	/* Exercise 1d
	 * aa - array which requires sorting
	 * p - starting index
	 * r - index of the pivot
	 * */
	public static void quicksortD(int[] aa, int p, int r) {
		if(p < r) {
			// q is an array of size 2
			// q[0] stores the value of the index
			// q[1] stores the number of elements with the same value as the pivot
			int[] q = partitionThreeWay(aa, p, r);
			quicksortA(aa, p, q[0]-1);
			quicksortA(aa, q[0]+q[1]+1, r);
		}
	}

	/* This method partitions the array and inserts the pivot in the
	 * correct position. The new index of the pivot is returned
	 * aa - array which requires partitioning
	 * p - starting index
	 * r - ending index (the index of the pivot)
	 */
	private static int partition(int[] aa, int p, int r) {
		int pivotValue = aa[r];
		// i is the greatest index for which the value is smaller than the pivot 
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(aa[j] <= pivotValue) {
				i++;
				// Since i is currently an index of a value greater than the pivot
				// swap the value of i with the value of j
				swapTwoElements(aa, i, j);
			}
		}
		// insert pivot in the correct position
		swapTwoElements(aa, r, i+1);
		return i + 1;
	}
	
	/* This method selects the pivot based on the median, 
	 * partitions the array and inserts the pivot in the
	 * correct position. The new index of the pivot is returned
	 * aa - array which requires partitioning
	 * p - starting index
	 * r - ending index (the index of the pivot)
	 */
	private static int partitionMedian(int[] aa, int p, int r) {
		int pivotIdx;
		int middle = (p+r)/2;
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
	    swapTwoElements(aa, pivotIdx, r);
	    // call partition() to partition the array and return the pivot index
	    return partition(aa, p, r);
	}
	
	/* This method partitions the array and inserts the pivot in the correct position. 
	 * Elements with the same value as the pivot are positioned right after the pivot.
	 * The new index of the pivot and the number of elements with the same value as the pivot are returned.
	 * aa - array which requires partitioning
	 * p - starting index
	 * r - ending index (the index of the pivot)
	 */
	private static int[] partitionThreeWay(int[] aa, int p, int r) {
		int pivotValue = aa[r];
		int sameAsPivot = 0;
		// i is the greatest index for which the value is smaller than the pivot 
		int i = p - 1;
		for(int j = p; j < r; j++) {
			if(aa[j] < pivotValue) {
				i++;
				// Since aa[i] has a value greater than the pivot
				// swap the value of aa[i] with the value of aa[j]
				swapTwoElements(aa, i, j);
				if(sameAsPivot>0) {
					// If an element with the same value as the pivot was moved moved to aa[j],
					// aa[i+sameAsPivot] now has a value different to the pivot value
					// Therefore, swap aa[j] with aa[i+sameAsPivot]
					swapTwoElements(aa, i+sameAsPivot, j);
				}
			}else if(aa[j] == pivotValue) {
				// the values from aa[i+1] up to aa[i+sameAsPivot] should have the same value
				// as the pivot
				sameAsPivot++;
				swapTwoElements(aa, i+sameAsPivot, j);
			}
		}
		// insert pivot one position greater than the last value equal to the pivot
		swapTwoElements(aa, r, i+sameAsPivot+1);
		return new int[] {i + 1, sameAsPivot};
	}

	private static void swapTwoElements(int[] aa, int idx1, int idx2 ) {
		int temp = aa[idx1];
		aa[idx1] = aa[idx2];
		aa[idx2] = temp;
	}
	

	public static void insertionsort(int[] aa, int p, int r) {
		for (int i = p + 1; i <= r; i++){
			 for (int j = i; j > p && aa[j] < aa[j-1]; j--){
				 swapTwoElements(aa, j, j-1);
			 }
		}
	}

	
}
