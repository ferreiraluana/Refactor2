package command;

import pay.Payroll;

public class PayrollCommand implements MainCommand{
	public void execute() {
		Payroll payroll = new Payroll();
		payroll.payroll();
	}
}
