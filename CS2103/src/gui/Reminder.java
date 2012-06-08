package gui;

import java.awt.SystemTray;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.Task;

import logic.JIDLogic;

import data.Task;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JDialog;
import javax.swing.Timer;

public class Reminder {
	
	SystemTray tray;
	long timeLeft;
	long delay = 0;
	Task task;
	Timer timer;
	ActionListener reminderPerformer;

	public Reminder(SystemTray tray) {
		this.tray = tray;
		init();
		runReminder();
		// swingworker
		// check every second for new task coming.
	}

	private void init() {
		reminderPerformer = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(task.getImportant()) {
					//new JFrame that have noice
				}
				else
					UIController.showTrayMsg("REMINDER", task.getName() + " is starting at " 
							+ task.getStartDateTime().formattedToString());
				
				task = null;
				try {
					wait(1000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				runReminder();
			}
		};
	}

	private void setUpdateNextHour() {
		// TODO Auto-generated method stub
		Timer autoRefresh = new Timer( 1000*60*60, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runReminder();
			}
		});
		autoRefresh.setRepeats(false);
		autoRefresh.start();
	}

	protected void runReminder() {
		// TODO Auto-generated method stub
		task = findLatestTask();
		timeLeft = findTimeLeft();
		
		if(timeLeft >= 0)
			setTimer((int)timeLeft);
		else
			setUpdateNextHour();
	}

	private void setTimer(int timeLeft) {
		// TODO Auto-generated method stub

		if(timer != null) 
			timer.stop();

		timer = new Timer(timeLeft, reminderPerformer);
	}

	private long findTimeLeft() {
		if(task == null)
			return -1;
		
		GregorianCalendar now = new GregorianCalendar();
		
		long nextReminderMilli = task.getStartDateTime().getTimeMilli();
		long nowMilli = now.getTimeInMillis();
		
		long timeDiff = nextReminderMilli - nowMilli - delay;
		
		if(timeDiff <0)
			return -1;
		
		if(timeDiff > Integer.MAX_VALUE)
			return -1;
		
		return timeDiff;
	}

	private Task findLatestTask() {
		JIDLogic.setCommand("find");
		return JIDLogic.executeCommand("find *.*")[0];
	}

	
	public static void main(String[] arguments) {
	}
}
