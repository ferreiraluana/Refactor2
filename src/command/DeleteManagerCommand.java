package command;

import manager.DeleteManager;

public class DeleteManagerCommand implements MainCommand{
	public void execute() {
		DeleteManager deleteManager = new DeleteManager();
		deleteManager.delete();
	}
}
