package folhadepagamento;

import java.util.InputMismatchException;

import employee.Employees;

public class Edit {
	
	public void edit() {
		int currentemployeeid = -1;
		System.out.println("Informe o Id do empregado: ");
		//Try
		while(!Principal.correctInput) {
			try{
				currentemployeeid = Principal.input.nextInt();
				Principal.correctInput = true;
			}
			catch(NumberFormatException e){
				System.out.println("Valor no formato incorreto. Digite novamente:");
			}
			catch(InputMismatchException e) {
				System.out.println("Valor no formato incorreto. Digite novamente:");
			}
			Principal.trash = Principal.input.nextLine();
		}
		Principal.correctInput = false;
		if(Principal.employee.containsKey(currentemployeeid)) {
			Employees.EditProfile(Principal.employee,currentemployeeid,Principal.input);
			Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
		}
		else System.out.println("Nao foi possivel encontrar o empregado.");
	}
}
