package constant;

public enum OperationFeedback {
	
	VALID,
	INVALID_DATE,
	INVALID_TIME,
	INVALID_TASK_DETAILS,
	INVALID_LABEL,
	INVALID_INCORRECTLOGIN, //incorrect username or password
	INVALID_NOINTERNET, //not connect to internet
	NOT_FOUND;
	
	private static String msg;
	
	public void setMsg(String Newmsg) {
		msg = Newmsg;
	}
	
	public String getMsg() {
		return msg;
	}
}
