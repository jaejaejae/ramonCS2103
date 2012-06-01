/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JFrame;


/**
 *
 * @author Ramon
 */
public class TopPopUp extends JFrame {

    /**
     * Creates new form TopPopUp
     */
    public TopPopUp() {
    	setUndecorated(true);
    	initComponents();
    	this.setFocusableWindowState(false);
    	showBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1))
        );

        
        jButton1.setText("");
        jButton1.setIcon( Resource.exitImg);
        jButton1.addActionListener( new 
        	ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(SHOW) {
						SHOW = !SHOW;
						setVisible(false);
					}
				}
        	
        });
        

        setIconImage((Resource.bigLogo).getImage());
        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TopPopUp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jButton1;
    private boolean SHOW = true;
    private Timer timer;
    private final int VISIBLE_TIME = 5;
    //private Timer timer;
    // End of variables declaration
    
    
    public void setPosition(int x, int y) {
    	setLocation(x, y);
    }
    
    public void setText(String str) {
    	jTextField1.setText(str);
    }
    
    public void showBox() {

    	SHOW = true;
    	setVisible(SHOW);
    	toFront();
    	
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
    
    public void hideBox() {
    	SHOW = false;
    	setVisible(SHOW);
    }
    
    public boolean isShow() {
    	return SHOW;
    }
    
}