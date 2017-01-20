package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvents;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvents;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvents;



public class Sorts {
	/*
	 * Selection Sort 
	 * @param arr a T array 
	 * @return returns a list of SortEvents.
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>(); 

		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j].compareTo(arr[minIndex]) < 0) {
					minIndex = j;
					events.add((SortEvent<T>) new CompareEvents<T>(i, j));
				}
			}
			T temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
			events.add((SortEvent<T>) new SwapEvents<T>(minIndex, i));
		}
		return events;
	}


	/*
	 * Insertion Sort
	 * @param arr a T array 
	 * @return returns a list of SortEvents.
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>(); 
		for (int i = 0; i < arr.length; i++) {
			int j = i;   //index of unsorted element
			while (j > 0 && arr[j-1].compareTo(arr[j]) > 0) {
				events.add((SortEvent<T>) new CompareEvents<T>(j, j-1));
				T temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				events.add((SortEvent<T>) new SwapEvents<T>(j, j-1));
				j--;
			}
		}
		return events;
	}


	/*
	 * Operates merge.
	 * @param arr a T array. 
	 * @param lo an integer indicating lower bound.
	 * @param hi an integer indicating upper bound.
	 * @param mid an integer indicating the middle index. 
	 * @param events a list of sortEvents. 
	 * @return returns a list of SortEvents.	
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> List<SortEvent<T>> merge (T[] arr, int lo, int mid, 
			int hi, List<SortEvent<T>> events){
		int k = 0;
		Object[] arrNew = new Object[hi - lo];
		int i = lo;
		int j= mid;
		while (i < mid && j < hi) {
			if(arr[i].compareTo(arr[j]) > 0){
				events.add((SortEvent<T>) new CompareEvents<T>(i, j));
				arrNew[k] = arr[j];
				events.add((SortEvent<T>) new CopyEvents<>(j, arr[j]));
				k++;
				j++;
			}
			else {
				arrNew[k] = arr[i];
				events.add((SortEvent<T>) new CopyEvents<>(i, arr[i]));
				k++;
				i++;
			}
		}
		while (i < mid) {
			arrNew[k] = arr[i]; 
			events.add((SortEvent<T>) new CopyEvents<>(i, arr[i]));
			k++;
			i++;
		}
		while (j < hi) {
			arrNew[k] = arr[j];
			events.add((SortEvent<T>) new CopyEvents<>(j, arr[j]));
			k++;
			j++;
		}

		for (int m = 0; m < arrNew.length; m++) {
			arr[lo + m] = (T) arrNew[m];
			events.add((SortEvent<T>) new CopyEvents<>(m, arr[lo + m]));
		}
		return events;
	}


	/*
	 * Performs merge sort.
	 * @param arr a T array. 
	 * @param lo an integer indicating lower bound.
	 * @param hi an integer indicating upper bound.
	 * @return returns a list of SortEvents.
	 */
	private static <T extends Comparable<T>>  List<SortEvent<T>> mergeSort(T[] arr, int lo, int hi,
			List<SortEvent<T>> events) {
		int mid = (hi + lo) / 2;
		if ((hi - lo) > 1) {
			mergeSort(arr, lo, mid, events);
			mergeSort(arr, mid, hi, events);
			merge(arr, lo, mid, hi, events);
		}
		return events;
	}


	/*
	 * Merge Sort
	 * @param arr a T array 
	 * @return returns a list of SortEvents.
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
		List<SortEvent<T>> events = new ArrayList<>();
		return mergeSort(arr, 0, arr.length, events);
	}


	/*
	 * Bubble Sort
	 * @param arr a T array 
	 * @return returns a list of SortEvents.
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {  
		List<SortEvent<T>> events = new ArrayList<>();
		for(int i=0; i < arr.length; i++){
			for(int j=1; j < (arr.length-i); j++){
				if(arr[j-1].compareTo(arr[j]) > 0){
					events.add((SortEvent<T>) new CompareEvents<T>(j-1, j));
					//swap the elements!
					T temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					events.add((SortEvent<T>) new SwapEvents<T>(j-1, j));
				}
			}
		}
		return events;
	}


	/*
	 * Operates partition.
	 * @param arr a T array. 
	 * @param lo an integer indicating lower bound.
	 * @param hi an integer indicating upper bound.
	 * @return returns a list of SortEvents.	
	 */
	public static <T extends Comparable<T>> List<SortEvent<T>> partition(T arr[], int lo, int hi, 
			List<SortEvent<T>> events) {
		int i = lo, j = hi;
		int mid = lo + (hi - lo) /2;
		T pivot = arr[mid];		

		while (i <= j) {
			while (arr[i].compareTo(pivot) < 0) {
				events.add((SortEvent<T>) new CompareEvents<T>(i, mid));
				i++;
			}
			while (arr[j].compareTo(pivot) > 0) {
				events.add((SortEvent<T>) new CompareEvents<T>(j, mid));
				j--;
			}
			if (i <= j) {
				T tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				events.add((SortEvent<T>) new SwapEvents<T>(i, j));
				i++;
				j--;
			}
		}
		if (lo < i - 1)
			partition(arr, lo, i - 1, events);
		if (i < hi)
			partition(arr, i, hi, events);

		return events;
	}


	/*
	 * Quick Sort
	 * @param arr a T array 
	 * @return returns a list of SortEvents.
	 */

	public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T arr[]) {
		if (arr.length == 0) {
			throw new ArrayIndexOutOfBoundsException 
			("To operate partition, a pivot position must be given.");
		}

		List<SortEvent<T>> events = new ArrayList<SortEvent<T>>();
		return partition(arr, 0, arr.length - 1, events);
	}


	/* 
	 * Event Sort
	 * Applies events given in the events list to a given array.
	 * @param arr a T array 
	 * @param events a list of sortEvents. 
	 */
	public static <T extends Comparable<T>> void eventSort(T[] arr, List<SortEvent<T>> events) {
		for (int i = 0; i < events.size(); i++) { 
			events.get(i).apply(arr);
		}
	}
}


