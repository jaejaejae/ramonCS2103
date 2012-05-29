/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import data.Task;
import logic.JIDLogic;

import com.seaglasslookandfeel.*;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.text.JTextComponent;

import javax.swing.JTextField;

import data.Task;
import data.TaskArrayList;

/**
 * 
 * @author Ramon
 */
public class MainJFrame extends javax.swing.JFrame {

	enum STATE {
		ADD, DELETE, EDIT, SEARCH, COMPLETED, ARCHIVE, OVERDUE, NULL, LIST, UNDO
	};
	boolean edit = false;
	STATE curState;
	STATE prevState = STATE.NULL;
	Task[] prevTasks;

	   Task[] tasks;
	String prevText;
	String id;
	int prevIndex;
	
	// Variables declaration - do not modify
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private ExpandJPanel expandJPanel = new ExpandJPanel();
	// End of variables declaration

	private static Point point = new Point();
	private final boolean TEST = true;
	private TopPopUp popup;

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

		/*
		 * Create and display the form
		 */
		java.awt.EventQueue.invokeLater(new Runnable() {

			public void run() {
				setVisible(true);
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

		jLabel1 = new javax.swing.JLabel("", Resource.bigLogo,
				SwingConstants.CENTER);
		jLabel2 = new javax.swing.JLabel("", Resource.exitImg,
				SwingConstants.CENTER);
		jLabel3 = new javax.swing.JLabel("", Resource.down,
				SwingConstants.CENTER);

		jPanel1 = new javax.swing.JPanel();
		jComboBox1 = new javax.swing.JComboBox();

		setPreferredSize(new java.awt.Dimension(378, 300));

		jComboBox1.setEditable(true);
		jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												jLabel1,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												56,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(0,
																				0,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel2))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jComboBox1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				291,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				7,
																				Short.MAX_VALUE)
																		.addComponent(
																				jLabel3,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				22,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				25,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jComboBox1,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								29,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(0,
																				11,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)))
										.addContainerGap()));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		setIconImage((Resource.bigLogo).getImage());
		setUndecorated(true);
		setSize(400, 100);
		// pack();

	}// </editor-fold>

	/**
	 * setting drag option
	 * 
	 */
	private void setAction() {
		setJFrameAction();
		// setButtonAction();
		setJComboBox1Action();
		setJLabel1Action();
		setJLabel2Action();
		setJLabel3Action();
	}

	private void setJLabel3Action() {
		// TODO Auto-generated method stub
		jLabel3.setToolTipText("Expand");

		jLabel3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				jLabel3.setIcon(Resource.downPress);
				Timer timer = new Timer(100, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						jLabel3.setIcon(Resource.down);
						if (MainJFrame.this.getSize().equals(
								new Dimension(400, 400))) {
							MainJFrame.this.remove(expandJPanel);
							MainJFrame.this.setSize(400, 100);
						} else {
							MainJFrame.this.setLayout(new BorderLayout());
							MainJFrame.this.add(expandJPanel,
									BorderLayout.SOUTH);
							MainJFrame.this.setSize(400, 400);

						}
					}

				});
				timer.setRepeats(false);
				timer.start();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

				jLabel3.setIcon(Resource.downOn);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

				jLabel3.setIcon(Resource.down);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

				jLabel3.setIcon(Resource.downPress);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

				jLabel3.setIcon(Resource.down);
			}
		});
	}

	private void setJLabel2Action() {
		// TODO Auto-generated method stub
		jLabel2.setToolTipText("Close");

		jLabel2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				if (popup != null && popup.isShow())
					popup.hideBox();
				MainJFrame.this.setVisible(false);
				//JIDLogic.JIDLogic_close();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				jLabel2.setIcon(Resource.exitOn);
				//MainJFrame.this.revalidate();
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				jLabel2.setIcon(Resource.exitImg);
				//MainJFrame.this.revalidate();
			}

		});

	}

	private void setJLabel1Action() {
		// TODO Auto-generated method stub

	}

	private void setJComboBox1Action() {
		
		int index;
		// TODO Auto-generated method stub
		this.getButtonSubComponent(jComboBox1).setVisible(false);
		final AutoCompletion jBoxCompletion = new AutoCompletion(jComboBox1);

		final JTextField editorcomp = (JTextField) jComboBox1.getEditor()
				.getEditorComponent();
		editorcomp.setText("");
		jComboBox1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub

			}

		});

		
		
		editorcomp.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				final KeyEvent e = arg0;
				 SwingUtilities.invokeLater(
				      new Runnable() {
					    	int curIndex;
					    	String command;
					    	String curText;
							@Override
							public void run() {

						    	curText = editorcomp.getText();
								jBoxCompletion.stopWorking();
								//curText= editorcomp.getText();
								curState= checkCommand(curText);curIndex= getIndex();
								System.out.println("curText:" + curText);
								System.out.println("prevText: " + prevText);
								//System.out.println("cmd: " + command);
								System.out.println("state: " +curState);
								System.out.println("prev: " +prevState);
								System.out.println("index: "+ curIndex);

								if(prevState == STATE.NULL && curState!=prevState) {
									command = new String(curText);
								}
								
								if(curState == STATE.NULL && curState!=prevState) {
									jBoxCompletion.setStandardModel();
									//jBoxCompletion.startWorking();
									jComboBox1.setSelectedIndex(-1);
								}
								
								if(((curState == STATE.EDIT && !edit)
									|| curState == STATE.DELETE
									|| curState == STATE.SEARCH
									|| curState == STATE.COMPLETED)
									&& curText.length() > curState.toString().length() +1) {
									if((e.getKeyCode() == KeyEvent.VK_BACK_SPACE || !e.isActionKey())
									&& e.getKeyCode() != KeyEvent.VK_ENTER
									&& e.getKeyCode() != KeyEvent.VK_UP
									&& e.getKeyCode() != KeyEvent.VK_DOWN){
										
									 SwingUtilities.invokeLater(
									new Runnable() {
	
										@Override
										public void run() {
											// TODO Auto-generated method stub
											System.out
													.println("***enter interstate: ");
	
											JIDLogic.setCommand(curState.toString().toLowerCase());
	
											System.out.println("********exeCmd: "
													+ curText);
											tasks = JIDLogic
													.executeCommand(curText);
	
											System.out.println(tasks[0].getName());
	
											jBoxCompletion.stopWorking();
											jBoxCompletion
													.setNewModel(taskArrayToString(tasks));
	
											jComboBox1.setPopupVisible(true);
	
											jComboBox1.setSelectedIndex(-1);
											editorcomp.setText(curText);
											//editorcomp.setText(curState.toString() + tasks[0]);
	
											if (tasks != null)
												id = tasks[0].getTaskId();
											else
												id = "dummyString!@#$";
										}
	
									});
								}

								if(curState != STATE.NULL &&
										(e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_DOWN)) {
										curText = prevText;
										tasks = JIDLogic.executeCommand(curText);
										id = tasks[jComboBox1.getSelectedIndex()].getTaskId();
										editorcomp.setText(curText);
										return;
									}
								}
									
								if(e.getKeyCode() == KeyEvent.VK_ENTER && curState!=STATE.NULL) {
									String exeCmd = new String();
									
									System.out.println("*********************enter");
									//System.out.println(prevTasks[0].getName());
									
									switch (curState ){
									case DELETE:
									case COMPLETED:
										
										exeCmd = curState.toString().toLowerCase() + " "
												+ id + " ";
										break;
									case EDIT:
										if(!edit) {
											exeCmd = curState.toString().toLowerCase() + " "
													+ id;
											editorcomp.setText(
													curState.toString().toLowerCase() + " " + taskToString(storagecontroller.StorageManager.getTaskById(id)));
											edit = true;
										}
										else {
											exeCmd = curText;
											edit = false;
										}
										break;
									case ADD:
										exeCmd = curText;
										break;
									case SEARCH:
										exeCmd = curText;
										break;
									case LIST:
										exeCmd = curText;
									}
									
									System.out.println("********exeCmd: " + exeCmd);
									JIDLogic.setCommand(curState.toString());
									tasks = JIDLogic.executeCommand(exeCmd);
									
									switch(curState) {
									case DELETE:
									case COMPLETED:
									case ADD:
									case EDIT:
										if(!edit) {
											if(tasks!=null) {
												showPopup(taskToString(tasks[0]) + " " +  curState.toString());
												expandJPanel.updateJTable();
											}else
												showPopup("invalid input");
										}
									break;									
									case SEARCH:
										expandJPanel.updateJTable(tasks);
										expandFrame();
									break;
									case LIST:
									case UNDO:
										expandJPanel.updateJTable();
										expandFrame();
										showPopup(tasks[0].getName());
										break;
									}
									
									
									if(tasks==null)
										System.out.println("error");
									else
										System.out.println(tasks[0].toString());
								}
								
								prevState = curState;
								prevIndex = curIndex;
								prevText = curText;
								prevTasks = tasks;
							}
							
							private int getIndex() {
								int idx = jComboBox1.getSelectedIndex();
								
								if(idx <0 ) return idx;
								
								String selected = (String)jComboBox1.getItemAt(idx);
								
						//		if(curText.length() <= selected.length() 
							//			&& selected.substring(0, curText.length()).equalsIgnoreCase(curText))
									return idx;
								
							//	return -1;
							}

							private String[] taskArrayToString (Task[] tasks) {
								String[] strings = new String[tasks.length];
								for(int i=0; i<tasks.length; i++)
									strings[i]= curState.toString() + " " + taskToString(tasks[i]);
								
								System.out.println("str[0]: "+strings[0]);
								return strings;
							}
							
							private String taskToString(Task task) {
								String str = new String();
								str = task.getName() ;
								if(task.getStartDateTime() != null)
									str += " start:" + task.getStartDateTime().presentableToString();
								if(task.getEndDateTime() != null)
									str += " end:" + task.getEndDateTime().presentableToString();
								return str;
							}
							
							private STATE checkCommand(String curText) {
								String delims = "[ ]+";
								String firstWord = curText.split(delims)[0];
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
								return STATE.NULL;
							} 

				      } );
				}


			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

				/**
				 * //update state //update combo box
				 * 
				 */
			}

		});

		editorcomp.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				editorcomp.selectAll();
			}

		});

	}

	private void setJFrameAction() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();

			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = getLocation();
				setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
				if (popup != null) {
					Point popupP = popup.getLocation();
					popup.setLocation(popupP.x + e.getX() - point.x, popupP.y
							+ e.getY() - point.y);
				}
			}
		});

		this.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (TEST)
					if (e.getKeyChar() == 'b') {
						System.out.println("B");
					}
			}

		});
	}

	private void showPopup(String str) {
		if (popup == null) {
			popup = new TopPopUp();
		}

		popup.setText(str);
		popup.setPosition(this.getLocation().x, this.getLocation().y - 30);
		popup.showBox();

	}

	public void showFrame() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				MainJFrame.this.setVisible(true);
			}

		});
	}

	public void hideFrame() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				MainJFrame.this.setVisible(false);
			}

		});
	}

	public void setInputText(final String string) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				jComboBox1.setSelectedItem(string);
				jComboBox1.getEditor().getEditorComponent()
						.requestFocusInWindow();
			}

		});
	}

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
	
	private void expandFrame() {
		if(MainJFrame.this.getSize().equals(new Dimension(400, 100))) {
			MainJFrame.this.setLayout(new BorderLayout());
			MainJFrame.this.add(expandJPanel, BorderLayout.SOUTH);
			MainJFrame.this.setSize(400,400);
		}
	}
}
