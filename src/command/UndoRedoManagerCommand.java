package command;

import manager.UndoRedoManager;

public class UndoRedoManagerCommand implements MainCommand{
	public void execute() {
		UndoRedoManager undoredomanager = new UndoRedoManager();
		undoredomanager.undoRedoManager();
	}
}
