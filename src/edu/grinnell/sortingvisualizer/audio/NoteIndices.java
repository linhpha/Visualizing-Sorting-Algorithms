package edu.grinnell.sortingvisualizer.audio;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
	public Integer[] indices;
	public Boolean[] boolNoteArr;
	/**
	 * @param n the size of the scale object that these indices map into
	 */
	public NoteIndices(int n) {
		initializeAndShuffle(n);
	}

	/**
	 * Reinitializes this collection of indices to map into a new scale object
	 * of the given size.  The collection is also shuffled to provide an
	 * initial starting point for the sorting process.
	 * @param n the size of the scale object that these indices map into
	 */
	public void initializeAndShuffle(int n) {
		indices = new Integer[n];
		for (int i = 0; i < n; i++) {
			indices[i] = i;
		}

		boolNoteArr = new Boolean[n];
		for (int i = 0; i < n; i++) {
			boolNoteArr[i] = false;
		}
		shuffleArr(indices);
	}

	public static void shuffleArr(Integer[] arr) { 
		Random rnd = ThreadLocalRandom.current();
		for (int i = arr.length-1; i > 0; i--) {
			int index = rnd.nextInt(i+1);
			Integer a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
	}

	/** @return the indices of this NoteIndices object */
	public Integer[] getNotes() { 
		return this.indices;
	}

	/**
	 * Highlights the given index of the note array
	 * @param index the index to highlight
	 */
	public void highlightNote(int index) {
		boolNoteArr[index] = true;
	}

	/** @return true if the given index is highlighted */
	public boolean isHighlighted(int index) {
		if (boolNoteArr[index] == true) {
			return true;
		}
		return false;
	}

	/** Clears all highlighted indices from this collection */
	public void clearAllHighlighted() {
		for (int i = 0; i < boolNoteArr.length; i++) {
			boolNoteArr[i] = false;
		}
	}
}
