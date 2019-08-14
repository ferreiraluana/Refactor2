package command;

import manager.AddManager;

public class AddManagerCommand implements MainCommand {
		public void execute() {
			AddManager addmanager = new AddManager();
			addmanager.add();
		}
}
