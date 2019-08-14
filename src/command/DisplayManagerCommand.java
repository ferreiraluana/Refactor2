package command;

import manager.DisplayManager;

public class DisplayManagerCommand implements MainCommand {
	public void execute() {
		DisplayManager displayManager = new DisplayManager();
		displayManager.display();
	}
}
