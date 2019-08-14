package command;

import folhadepagamento.Timecard;

public class TimecardCommand implements MainCommand{
	public void execute() {
		Timecard timecard = new Timecard();
		timecard.card();
	}
}
