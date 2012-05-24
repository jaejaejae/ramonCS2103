package gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class Main {
	static MainJFrame mainJFrame;
	Reminder reminder;
	static SystemTray tray = SystemTray.getSystemTray();
	
	
	public static void main(String[] args) {
		initializeTray();
		MainJFrame mainJFrame = new MainJFrame();
		Reminder reminder = new Reminder(tray);
	}


	private static void initializeTray() {
		// TODO Auto-generated method stub
		tray = SystemTray.getSystemTray();
		
		Image img = Toolkit.getDefaultToolkit().getImage( "D:\\JAVAworkspace2\\GUITemp\\bin\\gui\\trayLogo.png");
		
		
		PopupMenu popup = new PopupMenu();
		
		MenuItem mItem1 = new MenuItem("Exit");
		mItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});	
		
		MenuItem mItem2 = new MenuItem("Add from clipboard");
		mItem2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		popup.add(mItem2);
		popup.add(mItem1);
		
		TrayIcon trayIcon = new TrayIcon(img, "Tray Demo", popup);
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.err.println("Problem loading Tray icon");
		}
		
		trayIcon.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
			    SwingUtilities.invokeLater(
	    	       new Runnable() {
					@Override
					public void run() {
		   				if(mainJFrame!= null)
		   					mainJFrame.showFrame();
		   				else
		   					mainJFrame = new MainJFrame(); }
						}   	   	
	    	    );
			}
		});
	}
	
}
