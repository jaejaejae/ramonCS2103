package operation;


import storagecontroller.StorageManager;

import data.Task;

public class Delete extends BaseSearch {
	
	private Task taskDeleted;
	public Delete(){
		commandName="delete";
	}
	public Delete(String intendedOperation) {
		// TODO Auto-generated constructor stub
		commandName=intendedOperation;
	}

	
	public boolean delete(Task taskToBeDeleted)
	
	{
		if (taskToBeDeleted!=null)
		{
			return StorageManager.deleteTask(taskToBeDeleted);
		}
		return false;
	}

	public Task[] execute(Task taskToBeDeleted)
	{
		Task taskToDelete = StorageManager
				.getTaskById(taskToBeDeleted.getTaskId());

		boolean deleted = delete(taskToDelete);
		if (deleted) {
			isUndoAble = true;
			taskDeleted = taskToDelete;
			Task[] resultOfDelete = new Task[1];
			resultOfDelete[0] = taskToDelete;
			return resultOfDelete;
		}

		return null;
		
	}
	@Override
	public Task[] undo() {
		// TODO Auto-generated method stub
		Task[] undoneArray = new Task[1];
		Add addObject = new Add();
		if (addObject.add(taskDeleted)) {
			undoneArray[0] = taskDeleted;
			return undoneArray;
		}
		return null;
	}

	@Override
	public boolean isUndoAble() {
		// TODO Auto-generated method stub
		return isUndoAble;
	}

	@Override
	public boolean isInputCorrect(String command) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return "Task could not be deleted";
	}

	@Override
	public String getOperationName() {
		// TODO Auto-generated method stub
		return commandName;
	}

	@Override
	public Task[] execute(String userCommand) {
		// TODO Auto-generated method stub
		return null;
	}
	

}