/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import data.Task;

/**
 *
 * @author Ramon
 */
public class AlarmFrame extends javax.swing.JFrame {

	Task task;
	ActionListener alarmcontrol;
    /**
     * Creates new form AlarmFrame
     * @param task 
     */
    public AlarmFrame(Task task) {
    	this.task = task;
        initComponents();
        //this.setTextTaskDetailLabel(task);
        AlarmSound.music(true);
        this.addAction();
        this.setVisible(true);
    }

    private void addAction() {
		// TODO Auto-generated method stub
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AlarmSound.music(false);
				AlarmFrame.this.dispose();
			}
		});
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        taskDetailLabel = new javax.swing.JLabel();
        stopButton = new javax.swing.JButton();
        bgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taskDetailLabel.setBounds(10, 40, 220, 60);
        jLayeredPane1.add(taskDetailLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        stopButton.setText("stop");
        stopButton.setBounds(140, 110, 90, 30);
        jLayeredPane1.add(stopButton, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bgLabel.setBounds(0, 0, 240, 150);
        jLayeredPane1.add(bgLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
        );

        this.setUndecorated(true);
        this.pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			/*
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }*/
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlarmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlarmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlarmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlarmFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AlarmFrame(new Task()).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel taskDetailLabel;
    // End of variables declaration
    
    private void setTextTaskDetailLabel(Task task) {
    	String str;
    	String completedFont = "<font color = \"#BBBBBB\">";
    	
    	str = "<HTML><b>";
    	if(task.getCompleted()) {
    		str+=completedFont;
    		System.out.println("completed task");
    	}
    	else if(task.getImportant()) {
    		str += "<font color=\"red\">";
    	}
    	str += task.getName();
    	str += "<br/></b>";
    	if(task.getCompleted())
    		str+=completedFont;
    	if(task.getStartDateTime()!= null) {
    		str+="<br/><i>start: </i>"+task.getStartDateTime().presentableToString();
    	}
    	if(task.getEndDateTime()!=null) {
    		str+="<i>                  end: </i>"+task.getEndDateTime().presentableToString();
    	}
    	str += "</HTML>";
    	
    	taskDetailLabel.setText(str);
    }
}
