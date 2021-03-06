package gui.mainWindow.extended;

import gui.Resource;

import java.awt.Component;
import java.awt.Point;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.Logger;

import logic.JIDLogic;

import data.Task;

/**
 * an update JTable
 * @author Ramon
 *
 */
public class TaskTable {
	private static Logger logger=Logger.getLogger(TaskTable.class);
	
	private JTable jTable;
	private DefaultTableModel model;
    private Vector<String> listLabel = new Vector<String>();
    private Task[] tasks;
	
    /**
     * Constructor
     * @param jTable that needs to be updated
     */
	TaskTable(final JTable jTable){
		this.jTable = jTable;
		addListener();
		model = (DefaultTableModel) this.jTable.getModel();
		updateJTable();
	}

	int row=-1, col=-1;
	/**
	 * add listener on the table
	 */
	private void addListener() {
		
		jTable.addMouseListener(new MouseAdapter()
		{		    
		    @Override
		    public void mousePressed(MouseEvent e) {
			       Point pnt = e.getPoint();
			       row = jTable.rowAtPoint(pnt);
			       col = jTable.columnAtPoint(pnt);

			       	
			       	if(col == 0)
			       		jTable.changeSelection(row, 1, true, true);
			       	else{
			       		jTable.changeSelection(row, 0, true, true);
			       		
				       System.out.println("Pressed on star!");
				       JIDLogic.setCommand("IMPORTANT");
				       JIDLogic.executeCommand("IMPORTANT " + tasks[row].getTaskId());
				       updateJTable();
			       	}
		    }
		});
	}
	
	/**
	 * manage appearance of table
	 */
	private void setAppearance() {
		jTable.setRowHeight(60);
		while(model.getRowCount()>0)
			model.removeRow(0);
		jTable.getColumnModel().getColumn(0).setCellRenderer(new MyRenderer());
		jTable.getColumnModel().getColumn(1).setCellRenderer(new MyRenderer());
		for(int i=0; i<listLabel.size(); i++) {
			model.addRow(new Object[]{listLabel.get(i), tasks[i]});
		}
	}
	

	/**
	 * make JLabel for display
	 * @param task the task that needs to be displayed
	 */
    private void makeJLabel(Task task) {
    	String str;
    	String completedFont = "<font color = \"#BBBBBB\">";
    	
    	str = "<HTML><b><font size =\"4\">";
    	
    	if(task.getCompleted()) {
    		str+=completedFont;
    	}
    	
    	else if(task.getImportant()) {
    		str += "<font color=\"red\">";
    	}
    	
    	str += makeFirstLetterCapital(task.getName());
    	str += "<br/></b>";
    	str += tagToCode(task);
    	
    	if(task.getCompleted())
    		str+=completedFont;
    	
    	if(task.getStart()!= null) {
    		str+="<br/><i>start: </i>"+task.getStart().presentableToString();
    	}
    	
    	if(task.getEnd()!=null) {
    		str+="<i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
    				"end: </i>"+task.getEnd().presentableToString();
    	} 
    	str += "</font></HTML>";
    	
    	listLabel.add(str);
    }
    
    /**
     * make the first letter of the string become capital
     * @param str input string
     * @return
     */
    private String makeFirstLetterCapital(String str) {
    	if(str == null) {
    		logger.warn("string is null.");
    		return null;
    	}
    	String newStr = new String();
    	
    	newStr += str.toUpperCase().charAt(0);
    	if(str.length() >= 1)
    		newStr += str.substring(1);
    	return newStr;
    }
    
    /**
     * change labels in task to HTML code
     * @param task a task that containing label
     * @return String that has HTML code
     */
    private String tagToCode(Task task) {
    	String str = new String();
    	if(task.getLabels()!=null)
	    	for(int i=0; i<task.getLabels().size() && task.getLabels().get(i)!=null; i++) {
	    		str += "<FONT style=\"BACKGROUND-COLOR: #FFFFCC\">"
	    			+ task.getLabels().get(i)
	    			+ "</FONT> ";
	    	}
		return str;
	}

    /**
     * make all displaying JLabel
     * @param tasks tasks that need to be converted to JLabel
     */
	private void makeAllJLabel(Task[] tasks) {
    	
    	for(int i=0; i<tasks.length; i++) {
    		makeJLabel(tasks[i]);
    	}
    }
    
    /**
     * show all tasks on the table
     */
    public void updateJTable() {
    	/*
    	Timer timer = new Timer(100, new ActionListener(){

    	  		@Override
			public void actionPerformed(ActionEvent arg0) {*/
		    	listLabel = new Vector<String>();
		    	JIDLogic.setCommand("find");
		    	tasks = JIDLogic.executeCommand("find *.*");
		    	makeAllJLabel(tasks);
		    	setAppearance();
		/*    	}
			});
    	timer.setRepeats(false);
    	timer.start();*/
    	
    }
    
    /**
     * show some tasks on the table
     * @param tasks tasks that will be displayed on the table
     */
    public void updateJTable(final Task[] tasks) {
    	/*Timer timer = new Timer(1, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {*/
		    	if(tasks==null)
		    		while(model.getRowCount()>0)
		    			model.removeRow(0);
		    	else {
			    	listLabel = new Vector<String>();
			    	makeAllJLabel(tasks);
			    	setAppearance();
		    	}
		//	}});
    	/*timer.setRepeats(false);
    	timer.start();*/
    }
    
    /**
     * making JLabel inside table change colors when selected
     * @author Ramon
     *
     */
    class MyRenderer extends DefaultTableCellRenderer {
    	  /*
    	   * @see TableCellRenderer#getTableCellRendererComponent(JTable, Object, boolean, boolean, int, int)
    	   */
    	public Component getTableCellRendererComponent(JTable table, Object value,
    	                                                 boolean isSelected, boolean hasFocus, 
    	                                                 int row, int column) {
    		
    		JLabel label = new JLabel();
	    	if(isSelected){
	    		label.setBackground(table.getSelectionBackground());
	    		label.setForeground(table.getSelectionForeground());
	    	}
	    	else {
	    		label.setBackground(table.getBackground());
	    		label.setForeground(table.getForeground());
	    	}

    		label.setOpaque(true);
    		
    		if(column == 0) {
	    		label.setText(value.toString()); 	
    		}    		
    		else{    			
    			if(((Task)value).getImportant())
    				label.setIcon(Resource.starImportant);
    			else
    				label.setIcon(Resource.starUnimportant);
    	        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
    	        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    		}    		
    		return label;
    	}    	  
    }
    	  
    /**
     * 
     * @return tasks in the JTable
     */
    public Task[] getTasks() {
    	return tasks;
    }
}
