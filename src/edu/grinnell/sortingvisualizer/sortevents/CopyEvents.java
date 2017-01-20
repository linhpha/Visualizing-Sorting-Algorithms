package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvents<T> implements SortEvent<T> {
	public int i; 
	public T element;

	public CopyEvents (int i, T element) {  
		this.i = i;
		this.element = element;
	}

	public void apply (T[] arr) {
		arr[i] = element;
	}

	public List<Integer> getAffectedIndices() {
		List<Integer> l = new ArrayList<Integer> ();
		l.add(i);
		return l;
	}

	public boolean isEmphasized() {
		return true;
	}
}
