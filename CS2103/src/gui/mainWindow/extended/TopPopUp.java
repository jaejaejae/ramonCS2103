/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.mainWindow.extended;


import gui.Resource;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import javax.swing.JFrame;

import org.apache.log4j.Logger;


/**
 * pop up on top of the MainJFrame
 * @author Ramon
 */
public class TopPopUp extends JFrame {
	private static Logger logger=Logger.getLogger(TopPopUp.class);

    /**
     * Creates new form TopPopUp
     */
    public static void createTopPopUp() {
    	jFrame = new JFrame();
    	jFrame.setUndecorated(true);
    	initComponents();
    	jFrame.setFocusableWindowState(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private static void initComponents() {
        jLayeredPane1 = new javax.swing.JLayeredPane();
        exitLabel = new javax.swing.JLabel();
        textLabel = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        jFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitLabel.setText("exitLabel");
        exitLabel.setBounds(375, 3, 21, 23);
        jLayeredPane1.add(exitLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        textLabel.setBackground(Color.BLACK);
        textLabel.setBounds(10, 3, 360, 20);
        jLayeredPane1.add(textLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        bgLabel.setBounds(0, 0, 400, 30);
        bgLabel.setIcon(Resource.popupBG);
        bgLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLayeredPane1.add(bgLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(jFrame.getContentPane());
        jFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        exitLabel.setText("");
        exitLabel.setIcon( Resource.exit_small);
        exitLabel.addMouseListener( new 
        	MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if(SHOW) {
						SHOW = !SHOW;
						jFrame.setVisible(false);
					}
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					exitLabel.setIcon(Resource.exit_small_on);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					exitLabel.setIcon(Resource.exit_small);
				}
        });
        

    	jFrame.setBackground(new Color(0,0,0,0));
        jFrame.pack();
    }// </editor-fold>

    // Variables declaration - do not modify
    public static javax.swing.JFrame jFrame;
    private static javax.swing.JTextField jTextField1;
    private static javax.swing.JLabel exitLabel;
    private static javax.swing.JLabel textLabel;
    private static javax.swing.JLayeredPane jLayeredPane1;
    private static javax.swing.JLabel bgLabel;
    private static boolean SHOW = true;
    private static Timer timer;
    private final static int VISIBLE_TIME = 5;
    //private Timer timer;
    // End of variables declaration
    
    /**
     * set location of the pop up
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public static void setPosition(int x, int y) {
    	jFrame.setLocation(x, y);
    }
    
    /** set displayed text of the pop up
     * 
     * @param str displayed text
     */
    public static void setText(String str) {
    	textLabel.setText(makeFirstLetterCapital(str));
    }
    
    /**
     * show the pop up for VISIBLE_TIME second
     */
    public static void showBox() {

    	SHOW = true;
    	jFrame.setVisible(SHOW);
    	jFrame.toFront();
    	
    	if(timer != null){
    		timer.stop();
    	}
    	timer = new Timer(VISIBLE_TIME * 1000, new ActionListener(){
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				hideBox();
			}
	    	
	    });
	    timer.setRepeats(false);
	    timer.start(); 

    }
    
    /**hide the pop up
     * 
     */
    public static void hideBox() {
    	SHOW = false;
    	jFrame.setVisible(SHOW);
    }
    
    /**
     * 
     * @return true if pop up is shown
     */
    public static boolean isShow() {
    	return SHOW;
    }
    
    /**
     * make the first letter capital
     * @param str
     * @return string after modifying the first letter
     */
    private static String makeFirstLetterCapital(String str) {
    	if(str == null) {
    		logger.warn("str in makeFirstLetterCapital is null");
    		return null;
    	}
    	else if(str.length()==1)
    		return str.toUpperCase();
    	else
    		return str.substring(0,1).toUpperCase() + str.substring(1);
    }
    
}