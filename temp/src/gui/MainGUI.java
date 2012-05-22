package gui;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class MainGUI {
	
	private MainJFrame mainJFrame;
	private SystemTray tray;
	
	MainGUI() {
		addTray();
		mainJFrame = new MainJFrame();
	}
	
	public static void main(String[] args) {
		new MainGUI();
	}
	
	private void addTray() {
		tray = SystemTray.getSystemTray();
		
		Image img = Toolkit.getDefaultToolkit().getImage("taskMeter.gif");
		
		PopupMenu popup = new PopupMenu();
		
		MenuItem mItem1 = new MenuItem("Exit");
		mItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		popup.add(mItem1);

		TrayIcon trayIcon = new TrayIcon(img, "Tray Demo", popup);
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.err.println("Problem loading Tray icon");
		}
		
		trayIcon.displayMessage("Attention", "Please Click here", TrayIcon.MessageType.WARNING);
		System.out.println("finish adding tray");
	}
}