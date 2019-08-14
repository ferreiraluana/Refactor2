package folhadepagamento;

import java.util.InputMismatchException;

import employee.Employees;

public class Service {
	public void service() {
		int currentemployeeid = -1;
		System.out.println("Informe a Id do empregado");
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
			if(Principal.employee.get(currentemployeeid).getUnion().getSyndicatestatus().equals("1")){
				if(Principal.employee.get(currentemployeeid)instanceof Employees) {
					double taxvalue = 0;
					System.out.println("Informe o valor da taxa de servico(Exemplo: 0,15): ");
					//Try
					while(!Principal.correctInput) {
						try{
							taxvalue = Principal.input.nextDouble();
							Principal.correctInput = true;
						}
						catch(NumberFormatException e){
							System.out.println("Valor no formato incorreto.");
						}
						catch(InputMismatchException e) {
							System.out.println("Valor no formato incorreto.");
						}
						if(taxvalue >= 1 || taxvalue <= 0) {
							System.out.println("Valor nao aceito. Digite novamente:");
							Principal.correctInput = false;
						}
						Principal.trash = Principal.input.nextLine();
					}
					Principal.correctInput = false;
					Principal.employee.get(currentemployeeid).getUnion().setSyndicateServiceTax(taxvalue);
					Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
				}
				else System.out.println("Nao foi possivel associar empregado.");
			}
			else System.out.println("Nao faz parte de Sindicato.");
		}
		else System.out.println("Nao foi possivel encontrar o empregado.");
		
		System.out.println("Pressione enter para continuar.");
		Principal.trash = Principal.input.nextLine();
	}
}
