package edu.grinnell.sortingvisualizer.rendering;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import edu.grinnell.sortingvisualizer.audio.NoteIndices;

public class ArrayPanel extends JPanel {

	private NoteIndices notes;
	private int width; 
	private int height;

	/**
	 * Constructs a new ArrayPanel that renders the given note indices to
	 * the screen.
	 * @param notes the indices to render
	 * @param width the width of the panel
	 * @param height the height of the panel
	 */
	public ArrayPanel(NoteIndices notes, int width, int height) {
		this.notes = notes;
		this.setPreferredSize(new Dimension(width, height));
		this.width = width; 
		this.height = height;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);

		List<Color> l = new ArrayList<Color>();
		l.add(new Color (198, 226, 255));
		l.add(new Color (135, 206, 255));
		l.add(new Color (100, 149, 237));

		for (int i = 0; i < notes.indices.length; i++) {
			int xCor = width/notes.indices.length*i;
			int yCor = height - ((height/notes.indices.length)*notes.indices[i]);
			int boxWidth = width/notes.indices.length;
			int boxHeight = (height/notes.indices.length)*notes.indices[i];

			if (notes.isHighlighted(i) == true) {
				g.setColor(new Color (220, 20, 60));
				g.fillRect(xCor, yCor, boxWidth, boxHeight);
			} else {
				g.setColor(l.get(i % 3));
				g.fillRect(xCor, yCor, boxWidth, boxHeight);
			}		
		}
		notes.clearAllHighlighted();
	}
}
