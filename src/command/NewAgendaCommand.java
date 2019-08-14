package command;

import agenda.NewAgenda;

public class NewAgendaCommand implements MainCommand{
	public void execute() {
		NewAgenda newagenda = new NewAgenda();
		newagenda.newAgenda();
	}
}
