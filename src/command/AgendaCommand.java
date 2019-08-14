package command;

import agenda.Agenda;

public class AgendaCommand implements MainCommand{
	public void execute() {
		Agenda agenda = new Agenda();
		agenda.agenda();
	}
}
