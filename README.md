# quicksortalgorithms
This code is part of an empirical study which compares the efficiency of 4 different versions of quicksort algorithms to mergesort and insertionsort. 
The following versions of quickort were examined:
- basic version of quicksort where the pivot is the right-most element in the partition.
- version of quickosort which returns without sorting subarrays with fewer than n elements. Then insertion sort is called on the nearly sorted array.
- the median of three partitioning scheme (the median of the left-most, middle and right-most element of a partition is the pivot)
- three way quicksort (values equal to the pivot are not considered in smaller partitions)
