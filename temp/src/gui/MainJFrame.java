package gui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class MainJFrame extends JFrame{
	private MainJPanel mainJPanel;
	private static Point point = new Point();
	
	MainJFrame() {
		initComponents();
		addListener();

		this.setUndecorated(true);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initComponents() {
		mainJPanel = new MainJPanel();
		this.add(mainJPanel);
	}
	
	private void addListener() {
		
		addMouseListener(new MouseAdapter() {
		      public void mousePressed(MouseEvent e) {
		        point.x = e.getX();
		        point.y = e.getY();
		      }
		    });
		
		 addMouseMotionListener(new MouseMotionAdapter() {
		      public void mouseDragged(MouseEvent e) {
		        Point p = getLocation();
		        setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
		      }
		    });
	}
	
	public void updateInput(String str) {
		mainJPanel.updateJTextField1(str);
	}
}
