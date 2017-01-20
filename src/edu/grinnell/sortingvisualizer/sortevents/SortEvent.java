package edu.grinnell.sortingvisualizer.sortevents;

import java.util.List;

public interface SortEvent<T>{
	/*
	 * Applies this sort event to the given array.
	 * @param arr a T array.
	 */
	public void apply(T[] arr);

	/*
	 * Returns a list containing all of the array indices that this event affects.
	 */
	public List<Integer> getAffectedIndices();

	/*
	 * Return true if this event should be emphasized by the visualizer/audibilizer.
	 */
	public boolean isEmphasized();
}
