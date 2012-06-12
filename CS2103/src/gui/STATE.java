package gui;

/**
 * to see what command user is currently using
 * different commands result in different action from GUI
 * @author Ramon
 *
 */
public enum STATE {
	
	
	ADD, DELETE, EDIT, SEARCH, COMPLETED, ARCHIVE
	, OVERDUE, NULL, LIST, UNDO, EXIT, HELP, REDO
	, IMPORTANT, LOGIN, LOGOUT, DELETEALL, COMPLETEDALL
	, CLEARARCHIVE, EXPORTARCHIVE;
	
	
	private static STATE state;
	
	public static void setState(STATE newState) {
		state = newState;
	}
	
	public static STATE getState() {
		return state;
	}
	
}
