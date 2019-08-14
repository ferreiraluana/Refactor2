package manager;

import java.util.InputMismatchException;

import folhadepagamento.Principal;
import folhadepagamento.Undo_Redo;

public class DeleteManager {
	
	public void delete() {
		int currentemployeeid = -1;
		if(Principal.employee.size() <= 0) {
			System.out.println("Não há empregados");
		}
		else {
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
				Principal.input.nextLine();
			}
			Principal.correctInput = false;
			if(Principal.employee.containsKey(currentemployeeid)) {
				Principal.employee.remove(currentemployeeid);
				System.out.println("Removido");
			}
			else System.out.println("Nao foi possivel encontrar o empregado");
			
			Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
			System.out.println("Pressione enter para continuar.");
			Principal.input.nextLine();
		}
	}
}
