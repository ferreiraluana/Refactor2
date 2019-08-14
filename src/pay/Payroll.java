package pay;

import employee.Hourly;
import folhadepagamento.Principal;
import folhadepagamento.Undo_Redo;

public class Payroll {
	public void payroll() {
		for(int i = 1;i <= Principal.totalsize;i++) {
			if(Principal.employee.containsKey(i)) {
				if(Principal.employee.get(i).getType().equals("horista")) {
					Hourly currentemployee = (Hourly) Principal.employee.get(i);
					currentemployee.setChecksetofday(0);
					Principal.employee.get(i).calculateSalary(Principal.employee,i);
				}
				Principal.employee.get(i).calculateSalary(Principal.employee, i);
			}
		}
		Payment.PassDay(Principal.employee, Principal.calendar.day,Principal.calendar.month,Principal.calendar.year,Principal.calendar.dayofweek, Principal.totalsize);
		Principal.calendar.nextDay();
		Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
		System.out.println("Pressione enter para continuar.");
		Principal.input.nextLine();
	}
}
