package command;

import folhadepagamento.Edit;

public class EditCommand implements MainCommand{
	public void execute() {
		Edit edit = new Edit();
		edit.edit();
	}
}
