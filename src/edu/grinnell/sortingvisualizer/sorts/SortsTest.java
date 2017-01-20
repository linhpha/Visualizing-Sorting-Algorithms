package edu.grinnell.sortingvisualizer.sorts;
import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;

import edu.grinnell.sortingvisualizer.sortevents.SortEvent;





public class SortsTest {

	// Testing integer array with duplicate, odd length
	Integer[] intArr = {10, 9 , 8, 7, 6, 5, 4, 3, 5};
	Integer[] intArr2 = {3, 4, 5, 5, 6, 7, 8, 9,10};

	// Testing double array, even length
	Double[] doubArr = {0.0, 2.7, 34.5, 3.4}; 
	Double[] doubArr2 = {0.0, 2.7, 3.4, 34.5}; 

	// Testing integer array with negative elements 
	Integer[] negArr = {-10, 9 , -8, -7, 6, 5, 4, -3, 5};
	Integer[] negArr2 = {-10, -8, -7, -3, 4, 5, 5, 6, 9};

	// Testing already sorted array
	Integer[] intSortedArr = {15 ,16, 17, 18, 19, 20, 21, 22};
	Integer[] intSortedArr1 = {15 ,16, 17, 18, 19, 20, 21, 22};

	// Testing character array 
	Character[] charArr = {'a', 'z', 'd'}; 
	Character[] charArr2 = {'a', 'd', 'z'};

	// Testing reversed character array
	Character[] charReverseArr = {'z', 't', 'm', 'c', 'b', 'a'}; 
	Character[] charReverseArr2 = {'a', 'b', 'c', 'm', 't', 'z'};

	// Testing array containing same elements
	Double[] sameDoubArr = {1.1, 1.1, 1.1}; 

	//Testing array with one element 
	Integer[] oneElementArr = {1}; 

	//Testing empty array 
	Integer[] emptyArr = {};

	public static boolean isSorted (Integer[] arr) {
		for (int j = arr.length - 1; j >= 0; j--) {
			for (int i = j-1; i >= 0; i--) {
				if (arr[j] < arr[i]) { 
					return false; 
				}
			}
		}
		return true;
	}


	@Test
	public void testSelectionSort() {

		Sorts.selectionSort(intArr);
		for (int x = 0; x < intArr.length; x++) {
			assertEquals(intArr2[x], intArr[x]);
		}

		Sorts.selectionSort(charArr);
		for (int x = 0; x < charArr.length; x++) {
			assertEquals(charArr2[x], charArr[x]);
		}

		Sorts.selectionSort(doubArr);
		for (int x = 0; x < doubArr.length; x++) {
			assertEquals(doubArr2[x], doubArr[x]);
		}

		Sorts.selectionSort(negArr);
		for (int x = 0; x < negArr.length; x++) {
			assertEquals(negArr2[x], negArr[x]);
		}

		Sorts.selectionSort(intSortedArr);
		for (int x = 0; x < intSortedArr.length; x++) {
			assertEquals(intSortedArr[x], intSortedArr1[x]);
		}

		Sorts.selectionSort(charReverseArr);
		for (int x = 0; x < charReverseArr.length; x++) {
			assertEquals(charReverseArr[x], charReverseArr2[x]);
		}

		Sorts.selectionSort (sameDoubArr); 
		for (int x = 0; x < sameDoubArr.length; x++) {
			assertEquals (sameDoubArr[x], sameDoubArr[x]); 
		}

		Sorts.selectionSort(oneElementArr); 
		Integer x = 1;
		assertEquals(oneElementArr[0],x);

		Sorts.selectionSort(emptyArr);
		assertEquals (true, isSorted(emptyArr));

	}

	@Test
	public void testInsertionSort() {

		Sorts.insertionSort(intArr);
		for (int x = 0; x < intArr.length; x++) {
			assertEquals(intArr2[x], intArr[x]);
		}

		Sorts.insertionSort(charArr);
		for (int x = 0; x < charArr.length; x++) {
			assertEquals(charArr2[x], charArr[x]);
		}

		Sorts.insertionSort(doubArr);
		for (int x = 0; x < doubArr.length; x++) {
			assertEquals(doubArr2[x], doubArr[x]);
		}

		Sorts.insertionSort(negArr);
		for (int x = 0; x < negArr.length; x++) {
			assertEquals(negArr2[x], negArr[x]);
		}

		Sorts.insertionSort(intSortedArr);
		for (int x = 0; x < intSortedArr.length; x++) {
			assertEquals(intSortedArr[x], intSortedArr1[x]);
		}

		Sorts.insertionSort(charReverseArr);
		for (int x = 0; x < charReverseArr.length; x++) {
			assertEquals(charReverseArr[x], charReverseArr2[x]);
		}

		Sorts.insertionSort (sameDoubArr); 
		for (int x = 0; x < sameDoubArr.length; x++) {
			assertEquals (sameDoubArr[x], sameDoubArr[x]); 
		}

		Sorts.insertionSort(oneElementArr); 
		Integer x = 1;
		assertEquals(oneElementArr[0],x);

		Sorts.insertionSort(emptyArr);
		assertEquals (true, isSorted(emptyArr));
	} 

	@Test
	public void testMergeSort() {

		Sorts.mergeSort(intArr);
		for (int x = 0; x < intArr.length; x++) {
			assertEquals(intArr2[x], intArr[x]);
		}

		Sorts.mergeSort(charArr);
		for (int x = 0; x < charArr.length; x++) {
			assertEquals(charArr2[x], charArr[x]);
		}

		Sorts.mergeSort(doubArr);
		for (int x = 0; x < doubArr.length; x++) {
			assertEquals(doubArr2[x], doubArr[x]);
		}

		Sorts.mergeSort(negArr);
		for (int x = 0; x < negArr.length; x++) {
			assertEquals(negArr2[x], negArr[x]);
		}

		Sorts.mergeSort(intSortedArr);
		for (int x = 0; x < intSortedArr.length; x++) {
			assertEquals(intSortedArr[x], intSortedArr1[x]);
		}

		Sorts.mergeSort(charReverseArr);
		for (int x = 0; x < charReverseArr.length; x++) {
			assertEquals(charReverseArr[x], charReverseArr2[x]);
		}

		Sorts.mergeSort (sameDoubArr); 
		for (int x = 0; x < sameDoubArr.length; x++) {
			assertEquals (sameDoubArr[x], sameDoubArr[x]); 
		}

		Sorts.mergeSort(oneElementArr); 
		Integer x = 1;
		assertEquals(oneElementArr[0],x);

		Sorts.mergeSort(emptyArr);
		assertEquals (true, isSorted(emptyArr));
	}

	@Test
	public void testBubbleSort() {  
		Sorts.bubbleSort(intArr);

		for (int x = 0; x < intArr.length; x++) {
			assertEquals(intArr2[x], intArr[x]);
		}

		Sorts.bubbleSort(charArr);
		for (int x = 0; x < charArr.length; x++) {
			assertEquals(charArr2[x], charArr[x]);
		}

		Sorts.bubbleSort(doubArr);
		for (int x = 0; x < doubArr.length; x++) {
			assertEquals(doubArr2[x], doubArr[x]);
		}

		Sorts.bubbleSort(negArr);
		for (int x = 0; x < negArr.length; x++) {
			assertEquals(negArr2[x], negArr[x]);
		}

		Sorts.bubbleSort(intSortedArr);
		for (int x = 0; x < intSortedArr.length; x++) {
			assertEquals(intSortedArr[x], intSortedArr1[x]);
		}

		Sorts.bubbleSort(charReverseArr);
		for (int x = 0; x < charReverseArr.length; x++) {
			assertEquals(charReverseArr[x], charReverseArr2[x]);
		}

		Sorts.bubbleSort (sameDoubArr); 
		for (int x = 0; x < sameDoubArr.length; x++) {
			assertEquals (sameDoubArr[x], sameDoubArr[x]); 
		}

		Sorts.bubbleSort(oneElementArr); 
		Integer x = 1;
		assertEquals(oneElementArr[0],x);

		Sorts.bubbleSort(emptyArr);
		assertEquals (true, isSorted(emptyArr));
	}

	@Test
	public void testQuickSort() {

		Sorts.quickSort(intArr);
		for (int x = 0; x < intArr.length; x++) {
			assertEquals(intArr[x], intArr2[x]);
		}

		Sorts.quickSort(charArr);
		for (int x = 0; x < charArr.length; x++) {
			assertEquals(charArr2[x], charArr[x]);
		}

		Sorts.quickSort(doubArr);
		for (int x = 0; x < doubArr.length; x++) {
			assertEquals(doubArr2[x], doubArr[x]);
		}

		Sorts.quickSort(negArr);
		for (int x = 0; x < negArr.length; x++) {
			assertEquals(negArr2[x], negArr[x]);
		}

		Sorts.quickSort(intSortedArr);
		for (int x = 0; x < intSortedArr.length; x++) {
			assertEquals(intSortedArr[x], intSortedArr1[x]);
		}

		Sorts.quickSort(charReverseArr);
		for (int x = 0; x < charReverseArr.length; x++) {
			assertEquals(charReverseArr[x], charReverseArr2[x]);
		}

		Sorts.quickSort (sameDoubArr); 
		for (int x = 0; x < sameDoubArr.length; x++) {
			assertEquals (sameDoubArr[x], sameDoubArr[x]); 
		}

		Sorts.quickSort(oneElementArr); 
		Integer x = 1;
		assertEquals(oneElementArr[0],x);

		// We accounted for the empty array case by throwing an exception.  
	}

	@Test
	public void testEventSort() {

		// Testing Integer Array with repeated values
		Integer[] doubleArray = {7, 6, 2, 16, 3, 14, 10, 8, 1, 12, 4, 13, 5, 0, 9, 11, 15};
		Integer[] doubleArray2 = {7, 6, 2, 16, 3, 14, 10, 8, 1, 12, 4, 13, 5, 0, 9, 11, 15};
		List<SortEvent<Integer>> l = Sorts.selectionSort(doubleArray);
		Sorts.eventSort(doubleArray2, l);

		for (int x = 0; x < doubleArray.length; x++) {
			assertEquals (doubleArray[x], doubleArray2[x]); 
		}

		//Testing Character Reverse Array

		Character[] reverseCharArr = {'a', 'b', 'c', 'm', 't', 'z'};
		Character[] reverseCharArr2 = {'a', 'b', 'c', 'm', 't', 'z'};
		List<SortEvent<Character>> l2 = Sorts.insertionSort(reverseCharArr);
		Sorts.eventSort(reverseCharArr2, l2);

		for (int x = 0; x < reverseCharArr.length; x++) {
			assertEquals (reverseCharArr[x], reverseCharArr2[x]); 
		}

		// Testing already sorted array
		Integer[] sortedArr = {15 ,16, 17, 18, 19, 20, 21, 22};
		Integer[] sortedArr2 = {15 ,16, 17, 18, 19, 20, 21, 22};
		List<SortEvent<Integer>> l3 = Sorts.mergeSort(sortedArr);
		Sorts.eventSort(sortedArr2, l3);

		for (int x = 0; x < sortedArr2.length; x++) {
			assertEquals (sortedArr[x], sortedArr2[x]); 
		}


		// Testing array containing same elements
		Double[] sameArray = {1.1, 1.1, 1.1}; 
		List<SortEvent<Double>> l4 = Sorts.bubbleSort(sameArray);
		Sorts.eventSort(sameArray, l4);

		for (int x = 0; x < sameArray.length; x++) {
			assertEquals (sameArray[x], sameArray[x]); 
		}


		// Testing integer array with negative elements 
		Integer[] negativeArray = {-10, 9 , -8, -7, 6, 5, 4, -3, 5};
		Integer[] negativeArray2 = {-10, 9 , -8, -7, 6, 5, 4, -3, 5};
		List<SortEvent<Integer>> l5 = Sorts.quickSort(negativeArray);
		Sorts.eventSort(negativeArray2, l5);

		for (int x = 0; x < negativeArray2.length; x++) {
			assertEquals (negativeArray2[x], negativeArray[x]); 
		}


	}
}
