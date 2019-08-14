package folhadepagamento;

import java.util.InputMismatchException;

import employee.Commissioned;
import employee.Employees;

public class Sale {
	
	public void sale() {
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
			if(Principal.employee.get(currentemployeeid).getType().equals("comissionado")) {
				if(Principal.employee.get(currentemployeeid) instanceof Employees) {
					double sellvalue = 0;
					String selldate = null;
					Commissioned currentemployee = (Commissioned) Principal.employee.get(currentemployeeid);
					System.out.println("Informe a data da venda(dia/mes/ano): ");
					selldate = Principal.input.nextLine();
					System.out.println("Informe o valor da venda: ");
					//Try
					while(!Principal.correctInput) {
						try{
							sellvalue = Principal.input.nextDouble();
							Principal.correctInput = true;
						}
						catch(NumberFormatException e){
							System.out.println("Valor no formato incorreto.");
						}
						catch(InputMismatchException e) {
							System.out.println("Valor no formato incorreto.");
						}
						if(sellvalue <= 0) {
							System.out.println("Valor nao aceito. Digite novamente:");
							Principal.correctInput = false;
						}
						Principal.trash = Principal.input.nextLine();
					}
					Principal.correctInput = false;
					System.out.println("Informacoes da venda: " + " - Data da Venda: " + selldate + " - Valor da venda: " + sellvalue);
					currentemployee.setSells(sellvalue);
					Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
				}
				else System.out.println("Nao foi possivel associar empregado.Tente novamente");
			}
			else System.out.println("Empregado nao e horista.Tente novamente");
		}
		else System.out.println("Nao foi possivel encontrar o empregado.Tente novamente");
		
		System.out.println("Pressione enter para continuar.");
		Principal.trash = Principal.input.nextLine();
	}
}
