package gui;

import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class MainJPanelTest {
	public static void main(String[] args) {
		JFrame app = new JFrame("MainJPanel Test");
		MainJPanel test = new MainJPanel();
		
		app.setSize(300, 100);
		app.setResizable(false);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(test);
		app.setUndecorated(true);
		app.setVisible(true);
	}
}
