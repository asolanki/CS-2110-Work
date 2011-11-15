package edu.virginia.cs2110;

import java.awt.Color;
import java.awt.Component;

import javax.swing.*;

@SuppressWarnings("serial")
public class BuddyCellRenderer extends JTextArea implements ListCellRenderer {

	
	public BuddyCellRenderer() {
		setOpaque(true);
	}
	
	
	@Override
	public Component getListCellRendererComponent(JList bList, Object buddy, int index, boolean isSelected, boolean cellHasFocus) {
		
		setText(buddy.toString());

        Color background;
        Color foreground;

        // check if this cell represents the current DnD drop location
        JList.DropLocation dropLocation = bList.getDropLocation();
        if (dropLocation != null
                && !dropLocation.isInsert()
                && dropLocation.getIndex() == index) {

            background = Color.BLUE;
            foreground = Color.WHITE;

        // check if this cell is selected
        } else if (isSelected) {
            background = Color.RED;
            foreground = Color.WHITE;

        // unselected, and not the DnD drop location
        } else {
            background = Color.WHITE;
            foreground = Color.BLACK;
        };

        setBackground(background);
        setForeground(foreground);

        return this;
	}

}
