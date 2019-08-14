package manager;

import employee.Commissioned;
import employee.Employees;
import folhadepagamento.Principal;
import folhadepagamento.Undo_Redo;

public class UndoRedoManager {
	public void undoRedoManager() {String entry;
	System.out.println("Undo ou Redo?");
	entry = Principal.input.nextLine();
	if(entry.equals("Undo")) {
		Undo_Redo undo;
		undo = Undo_Redo.undo();
		if(undo != null) {
			Undo_Redo.SaveRedo(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
			Principal.option1 = undo.getOldoption();
			Principal.calendar.day = undo.getOldday();
			Principal.calendar.month = undo.getOldmonth();
			Principal.calendar.year = undo.getOldyear();
			Principal.calendar.dayofweek = undo.getOlddayofweek();
			Principal.employee.clear();
			double commission = 0;
			for(int currentid = 1;currentid <= Principal.totalsize;currentid++) {
				if(undo.getOldmap().containsKey(currentid)) {
					if(undo.getOldmap().get(currentid) instanceof Employees) {
						if(undo.getOldmap().get(currentid).getType().equals("comissionado")) {
							Commissioned current = (Commissioned) undo.getOldmap().get(currentid);
							commission = current.getCommission();
						}
						Employees.addEmployee(Principal.employee, undo.getOldmap().get(currentid).getName(), 
								undo.getOldmap().get(currentid).getAddress(), undo.getOldmap().get(currentid).getType(), 
								undo.getOldmap().get(currentid).getPaymentmethod(),
								undo.getOldmap().get(currentid).getPaymentPaper().getPaymentschedule(), 
								currentid, undo.getOldmap().get(currentid).getSalary(), 
								undo.getOldmap().get(currentid).getFirstDay(), 
								undo.getOldmap().get(currentid).getFirstMonth(), 
								undo.getOldmap().get(currentid).getFirstYear(), undo.getOldmap().get(currentid).getFirstDayOfWeek(), 
								undo.getOldmap().get(currentid).getUnion().getSyndicatestatus(),
								undo.getOldmap().get(currentid).getUnion().getSyndicateTax(),commission);
					}
				}
			}
			Principal.positioninarray = undo.getOldpositioninarray();
			System.out.println("Undone.");
			Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
		}
		else System.out.println("Nao pode Undo.");
		
	}
	else if(entry.equals("Redo")) {
		Undo_Redo redo;
		redo = Undo_Redo.redo();
		if(redo != null) {
			Principal.option1 = redo.getOldoption();
			Principal.calendar.day = redo.getOldday();
			Principal.calendar.month = redo.getOldmonth();
			Principal.calendar.year = redo.getOldyear();
			Principal.calendar.dayofweek = redo.getOlddayofweek();
			Principal.employee.clear();
			double commission = 0;
			for(int currentid = 1;currentid <= Principal.totalsize;currentid++) {
				if(redo.getOldmap().containsKey(currentid)) {
					if(redo.getOldmap().get(currentid) instanceof Employees) {
						if(redo.getOldmap().get(currentid).getType().equals("comissionado")) {
							Commissioned current = (Commissioned) redo.getOldmap().get(currentid);
							commission = current.getCommission();
						}
						Employees.addEmployee(Principal.employee, redo.getOldmap().get(currentid).getName(), 
								redo.getOldmap().get(currentid).getAddress(), redo.getOldmap().get(currentid).getType(), 
								redo.getOldmap().get(currentid).getPaymentmethod(),
								redo.getOldmap().get(currentid).getPaymentPaper().getPaymentschedule(), 
								currentid, redo.getOldmap().get(currentid).getSalary(), 
								redo.getOldmap().get(currentid).getFirstDay(), 
								redo.getOldmap().get(currentid).getFirstMonth(), 
								redo.getOldmap().get(currentid).getFirstYear(), 
								redo.getOldmap().get(currentid).getFirstDayOfWeek(), 
								redo.getOldmap().get(currentid).getUnion().getSyndicatestatus(), 
								redo.getOldmap().get(currentid).getUnion().getSyndicateTax(),commission);
					}
				}
			}
			Principal.positioninarray = redo.getOldpositioninarray();
			System.out.println("Redone.");
			Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
		}
		else System.out.println("Nao pode Redo.");
	}
	else System.out.println("Entrada Invalida.");
		
	}
}
