package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvents<T> implements SortEvent<T> {
	public int i, j;

	public CompareEvents (int i, int j) { 
		this.i = i;
		this.j = j;
	}

	public void apply (T[] arr) {
		return;		
	}

	public List<Integer> getAffectedIndices() {
		List<Integer> l = new ArrayList<Integer> ();
		l.add(i);
		l.add(j);
		return l;
	}

	public boolean isEmphasized() {
		return false;
	}
}
