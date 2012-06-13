/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.mainWindow;


import org.apache.log4j.*;

import data.Task;
import gui.Action;
import gui.Resource;
import gui.STATE;
import gui.UIController;
import gui.mainWindow.extended.AutoCompletion;
import gui.mainWindow.extended.ExpandComponent;
import gui.mainWindow.extended.HelpFrame;
import gui.mainWindow.extended.TopPopUp;
import logic.JIDLogic;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import constant.OperationFeedback;

/**
 * Main Window that interacts with users.
 * @author Ramon
 */
public class MainJFrame extends javax.swing.JFrame {

	private static Logger logger=Logger.getLogger(MainJFrame.class);
	
	static boolean expand = false;
	
	// Variables declaration - do not modify
    private javax.swing.JLabel bgLabel;
    private javax.swing.JLabel button1;
    private javax.swing.JLabel button2;
    private javax.swing.JLabel button3;
    private javax.swing.JLabel downButton;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private static javax.swing.JTextField editorcomp;
	private javax.swing.JLabel logo;
	private MouseListener curdownButton;
	public static Point currentLocation;
	// End of variables declaration


	// End of variables declaration

	/**
	 * Creates new form MainJFrame
	 */
	public MainJFrame() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			/*
			 * for (javax.swing.UIManager.LookAndFeelInfo info :
			 * javax.swing.UIManager.getInstalledLookAndFeels()) { if
			 * ("Nimbus".equals(info.getName())) {
			 * javax.swing.UIManager.setLookAndFeel(info.getClassName());
			 * UIManager. break; } }
			 */
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		initComponents();
		setAction();
		this.setFocusable(true);
		this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.currentLocation = new Point(this.getLocation());
		
		addBindings();
		
		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				showFrame();
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
		jComboBox1 = new javax.swing.JComboBox();
		jComboBox1.setEditable(true);
		jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
		
        jLayeredPane1 = new javax.swing.JLayeredPane();
        button1 = new javax.swing.JLabel();
        button2 = new javax.swing.JLabel();
        button3 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        downButton = new javax.swing.JLabel();
        bgLabel = new javax.swing.JLabel();

        jComboBox1.setBounds(90, 40, 260, 30);
        jLayeredPane1.add(jComboBox1, 2);

        button1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button1.setIcon(Resource.helpImg);
        button1.setBounds(300, 0, 30, 30);
        jLayeredPane1.add(button1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        button2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button2.setIcon(Resource.minimizeImg);
        button2.setBounds(330, 0, 30, 30);
        jLayeredPane1.add(button2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        button3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button3.setIcon(Resource.exitImg); 
        button3.setBounds(360, 0, 30, 30);
        jLayeredPane1.add(button3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        logo.setIcon(Resource.bigLogo);
        logo.setBounds(10, 0, 70, 80);
        jLayeredPane1.add(logo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        downButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        downButton.setIcon(Resource.down);
        downButton.setBounds(360, 40, 30, 30);
        jLayeredPane1.add(downButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPane1.add(ExpandComponent.getJScrollPane(), JLayeredPane.DEFAULT_LAYER);
        
        bgLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        bgLabel.setIcon(Resource.smallBG);
        bgLabel.setBounds(0, 0, 400, 400);
        jLayeredPane1.add(bgLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

		this.setIconImage((Resource.bigLogo).getImage());
		this.setUndecorated(true);
		this.setBackground(new Color(0,0,0,0));
		//this.pack();
		this.setSize(400, 100);
	}
	
	/**
	 * set action of each component in MainJFrame
	 */
	private void setAction() {
		setJFrameAction();
		setJComboBox1Action();
		setlogoAction();
		setbutton1Action();
		setbutton2Action();
		setbutton3Action();
		setdownButtonActionExpand();
	}
	
	/**
	 * set action of the 2nd button to minimize frame when clicked
	 */
	private void setbutton2Action() {
		button2.setToolTipText("Minimize");
		
		button2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainJFrame.this.hideFrame();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				button2.setIcon(Resource.minimizeImgOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				button2.setIcon(Resource.minimizeImg);
			}

		});
		
	}

	/**
	 * set action of the first button to toggle help window
	 */
	private void setbutton1Action() {
		button1.setToolTipText("Help");
		
		button1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(!HelpFrame.isShown())
					HelpFrame.showHelp();
				else
					HelpFrame.hideHelp();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				button1.setIcon(Resource.helpImgOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				button1.setIcon(Resource.helpImg);
			}			
		});
	}

	/**
	 * set the expand/contract button to be a contract button to contract when clicked
	 */
	public void setdownButtonActionContract() {
		downButton.setToolTipText("Contract");

		downButton.setIcon(Resource.up);
		
		downButton.removeMouseListener(curdownButton);
		downButton.addMouseListener(curdownButton = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				downButton.setIcon(Resource.upPress);
				if (MainJFrame.this.expand) {
					contractFrame();
				} else {
					expandFrame();
				}
				
				Timer timer = new Timer(100, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						downButton.setIcon(Resource.down);
					}

				});
				timer.setRepeats(false);
				timer.start();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				downButton.setIcon(Resource.upOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				downButton.setIcon(Resource.up);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				downButton.setIcon(Resource.upPress);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(!MainJFrame.this.expand)
					downButton.setIcon(Resource.down);
			}
		});
	}

	/**
	 * set expand/contract button to be an expand button to expand when clicked
	 */
	public void setdownButtonActionExpand() {
		downButton.setToolTipText("Expand");

		downButton.setIcon(Resource.down);
		downButton.removeMouseListener(curdownButton);
		
		downButton.addMouseListener(curdownButton = new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				downButton.setIcon(Resource.downPress);

				if (MainJFrame.this.expand) {
					contractFrame();
				} else {
					expandFrame();
				}
				
				Timer timer = new Timer(100, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						downButton.setIcon(Resource.up);
					}

				});
				timer.setRepeats(false);
				timer.start();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				downButton.setIcon(Resource.downOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				downButton.setIcon(Resource.down);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				downButton.setIcon(Resource.downPress);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				if(MainJFrame.expand)
					downButton.setIcon(Resource.up);
			}
		});
	}

	
	/**
	 * set action of the third button to exit when clicked
	 */
	private void setbutton3Action() {
		button3.setToolTipText("Close");

		button3.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (TopPopUp.isShow())
					TopPopUp.hideBox();
				MainJFrame.this.setVisible(false);
				JIDLogic.JIDLogic_close();
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				button3.setIcon(Resource.exitOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				button3.setIcon(Resource.exitImg);
			}

		});
	}
	
	/**
	 * set logo button
	 */
	private void setlogoAction() {
	}
	
	boolean edit = false;
	Task[] tasks;
	String prevText;
	String id;
	String lastCmd = null;
	String command;
	
	/**
	 * set action of JComboBox1 
	 */
	private void setJComboBox1Action() {
		this.getButtonSubComponent(jComboBox1).setVisible(false);
		final AutoCompletion jBoxCompletion = new AutoCompletion(jComboBox1);
		editorcomp = (JTextField) jComboBox1.getEditor()
				.getEditorComponent();
		editorcomp.setText("");
		
		editorcomp.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				final KeyEvent e = arg0;
				 SwingUtilities.invokeLater(
				      new Runnable() {
					    	int curIndex;
					    	int curLocation;
					    	String curText;
							@Override
							public void run() {
								
								curLocation = editorcomp.getSelectionStart();
						    	curText = editorcomp.getText();
								STATE.setState(curText);
								command = STATE.getCommand();
								curIndex= jComboBox1.getSelectedIndex();
								
								/*
								logger.debug("------------------------------");
								logger.debug("curText:" + curText);
								logger.debug("prevText: " + prevText);
								logger.debug("state: " +STATE.getState());
								logger.debug("prev: " +STATE.getPrevState());
								logger.debug("index: "+ curIndex);
								*/
								
								
								if(STATE.getPrevState() == STATE.EDIT && STATE.getState()!=STATE.getPrevState() && edit == true) {
									logger.debug("canceledit");
									JIDLogic.executeCommand("canceledit");
									edit = false;
								}
								
								if(STATE.getState() == STATE.NULL && STATE.getState()!=STATE.getPrevState()) {
									jBoxCompletion.setStandardModel();
									id = null;
									editorcomp.setText(curText);
									jComboBox1.setSelectedIndex(-1);
								}
								
								if(STATE.getState() == STATE.NULL && (e.getKeyCode() == KeyEvent.VK_UP
										|| e.getKeyCode() == KeyEvent.VK_DOWN)) {
									jComboBox1.setPopupVisible(false);
									if(e.getKeyCode() == KeyEvent.VK_UP && lastCmd != null) {
										editorcomp.setText(lastCmd);
										STATE.setState(lastCmd);
										command = STATE.getCommand();
										curText = lastCmd;
									}
								}
									
								if(((STATE.getState() == STATE.EDIT && !edit)
									|| STATE.getState() == STATE.DELETE
									|| STATE.getState() == STATE.SEARCH
									|| STATE.getState() == STATE.COMPLETED
									|| STATE.getState() == STATE.IMPORTANT
									|| STATE.getState() == STATE.DELETEALL
									|| STATE.getState() == STATE.COMPLETEDALL)
									&& curText.length() > command.length()+1) {
									if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE || !e.isActionKey())
									&& e.getKeyCode() != KeyEvent.VK_ENTER
									&& (e.getKeyCode() != KeyEvent.VK_UP)
									&& e.getKeyCode() != KeyEvent.VK_DOWN){
										
									 SwingUtilities.invokeLater(
									new Runnable() {
	
										@Override
										public void run() {
											System.out.println("***enter interstate: ");
	
											logger.debug("******setCmd: "+STATE.getState().toString().toLowerCase());
											JIDLogic.setCommand(STATE.getState().toString().toLowerCase());
	
											logger.debug("********exeCmd: "
													+ curText);
											tasks = JIDLogic
													.executeCommand(curText);
	
											jBoxCompletion
													.setNewModel(taskArrayToString(tasks));
										
											
											jComboBox1.setPopupVisible(true);
											jComboBox1.setSelectedIndex(-1);
											
											editorcomp.setText(curText);
											editorcomp.setSelectionStart(curLocation);
											editorcomp.setSelectionEnd(curLocation);
											
											if (tasks != null)
												id = tasks[0].getTaskId();
											else
												id = null;
										}
	
									});
								}

								if(STATE.getState() != STATE.NULL &&
										(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN)) {
										
										curText = prevText;
										
										logger.debug("********exeCmd: "
												+ curText);
										tasks = JIDLogic.executeCommand(curText);
										
										int selectedIndex = jComboBox1.getSelectedIndex();
										
										if(selectedIndex >= 0 && tasks!= null)
											id = tasks[jComboBox1.getSelectedIndex()].getTaskId();
										editorcomp.setText(curText);
										return;
									}
								}
								
								prevText = curText;						
								
								if(e.getKeyCode() == KeyEvent.VK_ENTER && STATE.getState() == STATE.NULL)
									showPopup("Invalid Command");
								if(e.getKeyCode() == KeyEvent.VK_ENTER && STATE.getState()!=STATE.NULL) {
									String exeCmd = new String();
									
									logger.debug("*********************enter");
									
									if(STATE.getState() != STATE.EDIT)
										edit = false;
									
									switch (STATE.getState() ){
									case DELETE:
									case DELETEALL:
									case COMPLETED:
									case COMPLETEDALL:
									case IMPORTANT:
										if(id!=null)
											exeCmd = STATE.getCommand() + " "
													+ id + " ";
										id = null;
										break;
									case EDIT:
										if(!edit && id!=null) {
											exeCmd = STATE.getCommand() + " "
													+ id;
											editorcomp.setText(
													command + " " 
													+ storagecontroller.StorageManager.getTaskById(id));
											id = null;
											edit = true;
										}
										else {
											exeCmd = curText;
											edit = false;
										}
										break;
									case ADD:
										exeCmd = curText;
										lastCmd = curText;
										break;
									case SEARCH:
										ExpandComponent.updateJTable(tasks);
										expandFrame();
										UIController.showFeedbackDisplay(tasks);
										return;
									case LIST:
										new Action.ListAction().actionPerformed(null);
										return;
									case EXIT:
										new Action.ExitAction().actionPerformed(null);
										return;
									case HELP:
										new Action.HelpAction().actionPerformed(null);
										return;
									case OVERDUE:
										new Action.OverdueAction().actionPerformed(null);
										return;
									case LOGIN:
										new Action.GCalendarAction().actionPerformed(null);
										return;
									case EXPAND:
										new Action.ExpandAction().actionPerformed(null);
									default:
										logger.warn("default execmd: " + curText);
										exeCmd = curText;
										break;
									}

									logger.debug("******setCmd: " + STATE.getState().toString());
									logger.debug("********exeCmd: " + exeCmd);
									
									JIDLogic.setCommand(STATE.getState().toString());
									tasks = JIDLogic.executeCommand(exeCmd);
									
									if(!edit) {
										if(UIController.getOperationFeedback() == OperationFeedback.VALID) {
											jBoxCompletion.setStandardModel();
											editorcomp.setText("");
										}
										UIController.showFeedbackDisplay(tasks);
									}
								}
							}
							

							private String[] taskArrayToString (Task[] tasks) {
								if(tasks!=null) {
									String[] strings = new String[tasks.length];
									for(int i=0; i<tasks.length; i++)
										strings[i]= command + " " 
												+ tasks[i];
																		
									return strings;
								}
								else {
									return null;
								}
							}
				      } );
				}
		});

		editorcomp.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				editorcomp.selectAll();
			}

		});

	}

	

	private static Point point = new Point();
	
	/**
	 * add Frame actions :
	 * (1) making other components hide/show according to the Frame
	 * (2) making it and its extended components movable
	 */
	private void setJFrameAction() {
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowActivated(WindowEvent arg0) {
				if(HelpFrame.isShown())
					HelpFrame.showHelp();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				if(HelpFrame.isShown() && !UIController.isLoginOn()) {
					HelpFrame.hideHelpTempolarily();
				}
			}
		});		
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				currentLocation = MainJFrame.this.getLocation();
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				//move itself
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
				
				//move topPopUp
				Point popupP = TopPopUp.jFrame.getLocation();
				TopPopUp.setPosition(popupP.x + e.getX() - point.x, popupP.y
							+ e.getY() - point.y);
				
				//move HelpFrame
				Point helpP = HelpFrame.getPosition();
				HelpFrame.setPosition(helpP.x + e.getX() - point.x
						, helpP.y + e.getY() - point.y);
			}
		});

	}

	/**show pop up on the top
	 * 
	 * @param str text in pop up
	 */
	public static void showPopup(String str) {
		logger.debug("-----------------POPUP-----------------------");
		TopPopUp.setText(str);
		TopPopUp.setPosition(currentLocation.x, currentLocation.y - 30);
		TopPopUp.showBox();
		TopPopUp.jFrame.setFocusable(true);
	}

	/**Show pop up on the top
	 * 
	 * @param name will get cut if it is too long
	 * @param detail that must be shown and will appear after the first String
	 */
	public static void showPopup(String name, String detail) {
		String str = name + " " + detail;
		if(str.length() > 50)
			str = name.substring(0, 50-detail.length()-3) + "... " + detail;
		showPopup(str);
	}
	/**
	 * show the current window
	 */
	public void showFrame() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {				
				MainJFrame.this.setVisible(true);
				MainJFrame.this.toFront();
				
				jComboBox1.requestFocus();
			}

		});
	}
	

	/**
	 * hide the current window
	 */
	public void hideFrame() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				TopPopUp.hideBox();
				MainJFrame.this.setVisible(false);
				UIController.showTrayMsg("Jot It Down!", "is hiding!");
			}

		});
	}

	/**
	 * set the input text field
	 * @param string the text that is needed to be shown
	 */
	public void setInputText(final String string) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				jComboBox1.setSelectedItem(string);
				jComboBox1.getEditor().getEditorComponent()
						.requestFocusInWindow();
			}

		});
	}
/**
 * get a JButton sub component of a container
 * @param container that we want to extract
 * @return JButton sub component
 */
	private static JButton getButtonSubComponent(Container container) {
		if (container instanceof JButton) {
			return (JButton) container;
		} else {
			Component[] components = container.getComponents();
			for (Component component : components) {
				if (component instanceof Container) {
					return getButtonSubComponent((Container) component);
				}
			}
		}
		return null;
	}
	
	/** expand the frame if it is contracted
	 * 
	 */
	public void expandFrame() {
		if(!expand) {
			MainJFrame.this.setSize(400,400);
			jLayeredPane1.setSize(400,400);
			bgLabel.setIcon(Resource.largeBG);
			expand = true;
			setdownButtonActionContract();
		}
	}
	/**
	 * contract the frame if it is expanded
	 */
	public void contractFrame() {
		if (expand) {
			MainJFrame.this.setSize(400, 100);
			expand = false;
			setdownButtonActionExpand();
			bgLabel.setIcon(Resource.smallBG);
		}
	}
	
	/**
	 * check whether it is expanded or not
	 * @return boolean value true if it is expanded
	 */
	public boolean isExpand() {
		return expand;
	}
	
	/**
	 * add hotkey to mainJFrame
	 */
    protected void addBindings() {
        InputMap inputMap = this.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getRootPane().getActionMap();
        
        new Binding(this, inputMap, actionMap);
    }    
    
    /**
     * remove text from jCOmboBox
     */
    public static void clearCommandLine() {
    	editorcomp.setText("");
    }
}