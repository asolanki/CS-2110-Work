package edu.virginia.cs2110;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.ScrollPaneLayout.*;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;


public class MainGui{

	private JFrame guiFrame;
	
	private JTabbedPane chats;
	private JScrollPane chatHolder;
	private JList list;
	
	private BuddyCellRenderer render;
	
	private JTextField chatInput;
	private JTextArea chatLog;
	
	public MainGui() {
		initializeBuddyList();
	}
	
	private void initializeBuddyList() {
		
		DefaultListModel listModel = new DefaultListModel();
	
		
		
		
		
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		
		
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		
		Buddy b = new Buddy("Adarsh", "lol@lol.com", new ArrayList<String>());
		
		render = new BuddyCellRenderer();
		render.getListCellRendererComponent(list, b, 1, true, true);

		
		
		
		
		
		
		guiFrame = new JFrame("Buddy List");
		guiFrame.setBounds(300,100,300,800);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setVisible(true);
//		guiFrame.setContentPane(list);
		
		
		chatHolder = new JScrollPane(list);
		chatHolder.setBounds(300,100,300,800);
		chatHolder.setLayout(new ScrollPaneLayout());
		chatHolder.setWheelScrollingEnabled(true);
		
		
		
		
		
		

		
		chatHolder.setVisible(true);
		
		
	}
	
	
	
}


//MouseListener mouseListener = new MouseAdapter() {
//    public void mouseClicked(MouseEvent e) {
//        if (e.getClickCount() == 2) {
//            int index = list.locationToIndex(e.getPoint());
//            System.out.println("Double clicked on Item " + index);
//         }
//    }
//};
//list.addMouseListener(mouseListener);