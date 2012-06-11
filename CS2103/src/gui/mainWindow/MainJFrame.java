/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.mainWindow;


import org.apache.log4j.*;

import data.Task;
import gui.Resource;
import gui.UIController;
import gui.mainWindow.extended.AutoCompletion;
import gui.mainWindow.extended.ExpandComponent;
import gui.mainWindow.extended.HelpFrame;
import gui.mainWindow.extended.TopPopUp;
import logic.JIDLogic;

//import com.seaglasslookandfeel.*;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
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
 * Main Window
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
	private javax.swing.JLabel logo;
	private JLabel bg;
	private MouseListener curdownButton;
	private javax.swing.JPanel jPanel1;
	private	JLayeredPane lp;
	// End of variables declaration

	private static Point point = new Point();
	public static Point currentLocation;
	private final boolean TEST = true;

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
		button2.setToolTipText("minimize");
		
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
		button1.setToolTipText("help");
		
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

	enum STATE {
		ADD, DELETE, EDIT, SEARCH, COMPLETED, ARCHIVE
		, OVERDUE, NULL, LIST, UNDO, EXIT, HELP, REDO
		, IMPORTANT, LOGIN, LOGOUT, DELETEALL, COMPLETEDALL
		, CLEARARCHIVE, EXPORTARCHIVE
	};
	
	boolean edit = false;
	STATE curState;
	STATE prevState = STATE.NULL;
	Task[] tasks;
	String prevText;
	String id;
	int prevIndex;
	String lastCmd = null;
	String command;
	
	/**
	 * set action of JComboBox1 
	 */
	private void setJComboBox1Action() {
		this.getButtonSubComponent(jComboBox1).setVisible(false);
		final AutoCompletion jBoxCompletion = new AutoCompletion(jComboBox1);
		final JTextField editorcomp = (JTextField) jComboBox1.getEditor()
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
								curState= checkCommand(curText);
								curIndex= jComboBox1.getSelectedIndex();
								
								
								logger.debug("------------------------------");
								logger.debug("curText:" + curText);
								logger.debug("prevText: " + prevText);
								logger.debug("state: " +curState);
								logger.debug("prev: " +prevState);
								logger.debug("index: "+ curIndex);
								
								
								
								if(prevState == STATE.EDIT && curState!=prevState && edit == true) {
									logger.debug("canceledit");
									JIDLogic.executeCommand("canceledit");
									edit = false;
								}
								
								if(curState == STATE.NULL && curState!=prevState) {
									jBoxCompletion.setStandardModel();
									id = null;
									editorcomp.setText(curText);
									jComboBox1.setSelectedIndex(-1);
								}
								
								if(curState == STATE.NULL && (e.getKeyCode() == KeyEvent.VK_UP
										|| e.getKeyCode() == KeyEvent.VK_DOWN)) {
									jComboBox1.setPopupVisible(false);
									if(e.getKeyCode() == KeyEvent.VK_UP && lastCmd != null) {
										editorcomp.setText(lastCmd);
										curState = checkCommand(lastCmd);
										curText = lastCmd;
									}
								}
									
								if(((curState == STATE.EDIT && !edit)
									|| curState == STATE.DELETE
									|| curState == STATE.SEARCH
									|| curState == STATE.COMPLETED
									|| curState == STATE.IMPORTANT
									|| curState == STATE.DELETEALL
									|| curState == STATE.COMPLETEDALL)
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
	
											logger.debug("******setCmd: "+curState.toString().toLowerCase());
											JIDLogic.setCommand(curState.toString().toLowerCase());
	
											logger.debug("********exeCmd: "
													+ curText);
											tasks = JIDLogic
													.executeCommand(curText);
	
											jBoxCompletion
													.setNewModel(taskArrayToString(tasks));
											
											jComboBox1.setPopupVisible(true);
	
											editorcomp.setText(curText);
											editorcomp.setSelectionStart(curLocation);
											editorcomp.setSelectionEnd(curLocation);
											//editorcomp.setText(curState.toString() + tasks[0]);
	
											if (tasks != null)
												id = tasks[0].getTaskId();
											else
												id = null;
												//id = "dummyString!@#$";
										}
	
									});
								}

								if(curState != STATE.NULL &&
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
									
								if(e.getKeyCode() == KeyEvent.VK_ENTER && curState!=STATE.NULL) {
									String exeCmd = new String();
									
									logger.debug("*********************enter");
									
									if(curState != STATE.EDIT)
										edit = false;
									
									switch (curState ){
									case DELETE:
									case DELETEALL:
									case COMPLETED:
									case COMPLETEDALL:
									case IMPORTANT:
										if(id!=null)
											exeCmd = curState.toString().toLowerCase() + " "
													+ id + " ";
										id = null;
										break;
									case EDIT:
										if(!edit && id!=null) {
											exeCmd = curState.toString().toLowerCase() + " "
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
									case LIST:
									case UNDO:
									case REDO:							
									case OVERDUE:
									case ARCHIVE:
									case CLEARARCHIVE:
									case EXPORTARCHIVE:
										exeCmd = curText;
									break;
									}
									
									
									logger.debug("******setCmd: " + curState.toString());
									logger.debug("********exeCmd: " + exeCmd);
									
									JIDLogic.setCommand(curState.toString());
									tasks = JIDLogic.executeCommand(exeCmd);
									
									switch(curState) {
									case DELETE:
									case DELETEALL:
									case COMPLETED:
									case COMPLETEDALL:
									case IMPORTANT:
									case ADD:
									case UNDO:
									case REDO:
									case EDIT:
										if(!edit) {
											if(tasks!=null) {
												showPopup( curState.toString()+ " " 
														+ tasks[0]);
												UIController.refresh();
											}
										}
									break;									
									case SEARCH:
										ExpandComponent.updateJTable(tasks);
										expandFrame();
									break;
									case LIST:
										UIController.refresh();
										expandFrame();
									break;
									case EXIT:
										JIDLogic.JIDLogic_close();
										System.exit(0);
										break;
									case HELP:
										HelpFrame.toggleShown();
										break;
									case OVERDUE:
										new Action.OverdueAction().actionPerformed(null);
										break;
									case LOGIN:
										System.out.println("case LOGIN");
										new Action.GCalendarAction().actionPerformed(null);
										break;
									case LOGOUT:
										new Action.GCalendarOutAction().actionPerformed(null);
										break;
									case ARCHIVE:
									case CLEARARCHIVE:
									case EXPORTARCHIVE:
									}
									
									if(UIController.getOperationFeedback() == OperationFeedback.VALID && !edit) {
										jBoxCompletion.setStandardModel();
										editorcomp.setText("");
										curState = STATE.NULL;
									}
									else {
										UIController.showInvalidDisplay();
									}
									UIController.sendOperationFeedback(OperationFeedback.VALID);
								}
								
								prevState = curState;
								prevIndex = curIndex;
								prevText = curText;
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
							
							private STATE checkCommand(String curText) {
								if(curText.equals(""))
									return STATE.NULL;
								
								String delims = "[ ]+";
								String firstWord = curText.trim().split(delims)[0];
								command = firstWord;
								
								if(firstWord.equalsIgnoreCase("add") 
										|| firstWord.equalsIgnoreCase("insert"))
									return STATE.ADD;
								if(firstWord.equalsIgnoreCase("delete")
										|| firstWord.equalsIgnoreCase("remove"))
									return STATE.DELETE;
								if(firstWord.equalsIgnoreCase("modify")
										|| firstWord.equalsIgnoreCase("edit")
										|| firstWord.equalsIgnoreCase("update"))
									return STATE.EDIT;
								if(firstWord.equalsIgnoreCase("search")
										|| firstWord.equalsIgnoreCase("find"))
									return STATE.SEARCH;
								if(firstWord.equalsIgnoreCase("completed")
										|| firstWord.equalsIgnoreCase("done"))
									return STATE.COMPLETED;
								if(firstWord.equalsIgnoreCase("archive"))
									return STATE.ARCHIVE;
								if(firstWord.equalsIgnoreCase("overdue"))
									return STATE.OVERDUE;
								if(firstWord.equalsIgnoreCase("list"))
									return STATE.LIST;
								if(firstWord.equalsIgnoreCase("undo"))
									return STATE.UNDO;
								if(firstWord.equalsIgnoreCase("exit"))
									return STATE.EXIT;
								if(firstWord.equalsIgnoreCase("help"))
									return STATE.HELP;
								if(firstWord.equalsIgnoreCase("redo"))
									return STATE.REDO;
								if(firstWord.equalsIgnoreCase("important"))
									return STATE.IMPORTANT;
								if(firstWord.equalsIgnoreCase("login"))
									return STATE.LOGIN;
								if(firstWord.equalsIgnoreCase("delete.all"))
									return STATE.DELETEALL;
								if(firstWord.equalsIgnoreCase("completed.all"))
									return STATE.COMPLETEDALL;
								if(firstWord.equalsIgnoreCase("archive"))
									return STATE.ARCHIVE;
								if(firstWord.equalsIgnoreCase("cleararchive"))
									return STATE.CLEARARCHIVE;
								if(firstWord.equalsIgnoreCase("exportarchive"))
									return STATE.EXPORTARCHIVE;
								
								command = null;
								return STATE.NULL;
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
		TopPopUp.setPosition(currentLocation.x + 15, currentLocation.y - 30);
		TopPopUp.showBox();
		TopPopUp.jFrame.setFocusable(true);
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
    
}