package manager;
import java.util.InputMismatchException;

import employee.Employees;
import folhadepagamento.Principal;
import folhadepagamento.Undo_Redo;

public class AddManager {
	
	public void add() {
		String emname = null,emaddress = null ,emtype = null,empmethod = null,empschedule = null,emsyndicate = null;
		double salary = 0,syndicatetax = 0,commission = 0;
		System.out.println("Informe o nome do novo empregado: ");
		emname = Principal.input.nextLine();
		System.out.println("Informe o endereco do novo empregado: ");
		emaddress = Principal.input.nextLine();
		while(!Principal.acceptentry) {
			System.out.println("Informe o tipo do novo empregado(assalariado,horista,comissionado): ");
			emtype = Principal.input.nextLine();
			if(emtype.equals("assalariado")) {
				System.out.println("Informe o salario mensal: ");
				empschedule = "mensalmente";
				Principal.acceptentry = true;
			}
			else if(emtype.equals("horista")) {
				System.out.println("Informe o salario por hora: ");
				empschedule = "semanalmente";
				Principal.acceptentry = true;
			}
			else if(emtype.equals("comissionado")) {
				System.out.println("Informe a comissao(Exemplo: 0,15): ");
				//Try
				while(!Principal.correctInput) {
					try{
						commission = Principal.input.nextDouble();
						Principal.correctInput = true;
					}
					catch(NumberFormatException e){
						Principal.input.reset();
						System.out.println("Valor no formato incorreto.");
					}
					catch(InputMismatchException e) {
						Principal.input.reset();
						System.out.println("Valor no formato incorreto.");
					}
					if(commission >= 1 || commission <= 0) {
						System.out.println("Valor nao aceito. Digite novamente: ");
						Principal.correctInput = false;
					}
					Principal.input.nextLine();
				}
				Principal.correctInput = false;
				System.out.println("Informe o salario quinzenal: ");
				empschedule = "bi-semanalmente";
				Principal.acceptentry = true;
			}
			else {
				System.out.println("Tipo de empregado nao aceito. Digite novamente\n");
			}
			
		}
		Principal.acceptentry = false;
		//Try
		while(!Principal.correctInput) {
			try{
				salary = Principal.input.nextDouble();
				Principal.correctInput = true;
			}
			catch(NumberFormatException e){
				System.out.println("Valor no formato incorreto.");
			}
			catch(InputMismatchException e) {
				System.out.println("Valor no formato incorreto.");
			}
			if(salary <= 0) {
				System.out.println("Valor nao aceito. Digite novamente: ");
				Principal.correctInput = false;
			}
			Principal.input.nextLine();
		}
		Principal.correctInput = false;
		System.out.println("Faz parte de algum sindicato, se sim pressione 1. Se nao pressione 2");
		emsyndicate = Principal.input.nextLine();
		if(emsyndicate.equals("1")) {
			System.out.println("Informe a Taxa de Sindicato(Exemplo: 0,15): ");
			//Try
			while(!Principal.correctInput) {
				try{
					syndicatetax = Principal.input.nextDouble();
					Principal.correctInput = true;
				}
				catch(NumberFormatException e){
					System.out.println("Valor no formato incorreto.");
				}
				catch(InputMismatchException e) {
					System.out.println("Valor no formato incorreto.");
				}
				if(syndicatetax >= 1 || syndicatetax <= 0) {
					System.out.println("Valor nao aceito. Digite novamente:");
					Principal.correctInput = false;
				}
				Principal.input.nextLine();
			}
			Principal.correctInput = false;
		}
		System.out.println("Informe o metodo de pagamento(deposito,cheque): ");
		empmethod = Principal.input.nextLine();
		if(empmethod.equals("cheque")) {
			String optionmethod;
			System.out.println("Cheque em maos(1)\nCheque pelos correios(2)");
			optionmethod = Principal.input.nextLine();
			if(optionmethod.equals("1")) empmethod = "cheque em maos";
			else if(optionmethod.equals("2")) empmethod = "cheque pelos correios";
		}
		Principal.id++;
		Principal.totalsize++;
		Employees.addEmployee(Principal.employee, emname, emaddress, emtype, empmethod, empschedule,Principal.id, salary, Principal.calendar.day, 
				Principal.calendar.month, Principal.calendar.year,	Principal.calendar.dayofweek,emsyndicate,syndicatetax,commission);
		Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
		System.out.println("Pressione enter para continuar.");
		Principal.input.nextLine();
	}
}
