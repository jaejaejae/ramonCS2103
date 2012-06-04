package gui;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import logic.JIDLogic;

public class JotItDownTray {
	final MainJFrame mainJFrame;
	static SystemTray tray = SystemTray.getSystemTray();
	
	JotItDownTray(final MainJFrame mainJFrame) {
		this.mainJFrame = mainJFrame;
		
		// TODO Auto-generated method stub
		tray = SystemTray.getSystemTray();
		Image img = Resource.trayImage;
		//Image img = Toolkit.getDefaultToolkit().getImage( "D:\\JAVAworkspace2\\GUITemp\\bin\\gui\\trayLogo.png");
		
		
		PopupMenu popup = new PopupMenu();
		
		MenuItem mItem1 = new MenuItem("Exit");
		mItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JIDLogic.JIDLogic_close();
				System.exit(0);
			}
		});	
		
		MenuItem mItem2 = new MenuItem("Add from clipboard");
		mItem2.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub]
				String input = UIController.getClipboard();
				if(!mainJFrame.isVisible())
					mainJFrame.showFrame();
				mainJFrame.setInputText("add "+input);
			}
		});
		
		
		popup.add(mItem2);
		popup.add(mItem1);
		
		TrayIcon trayIcon = new TrayIcon(img, "Jot It Down!", popup);
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			System.err.println("Problem loading Tray icon");
		}
		
		trayIcon.addMouseListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//mainJFrame.setVisible(true);
			    SwingUtilities.invokeLater(
	    	       new Runnable() {
					@Override
					public void run() {
						if(!mainJFrame.isVisible()) {
							mainJFrame.showFrame();
						}
		   			}
	    	       });
			}
		});
	}
	
	public SystemTray getTray() {
		return tray;
	}
}
