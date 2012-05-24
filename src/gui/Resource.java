package gui;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Resource {
	public final Icon bigLogo = new ImageIcon( getClass().getResource("logo.png"));
	public final Icon exitImg = new ImageIcon( getClass().getResource("exit.png"));
	public final Icon exitOn = new ImageIcon( getClass().getResource("exitOn.png"));
	public final Icon trayLogo = new ImageIcon( getClass().getResource("trayLogo.png"));
}
