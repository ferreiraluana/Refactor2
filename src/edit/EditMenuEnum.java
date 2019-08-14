package edit;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import employee.Employees;
import pay.Payment;

public enum EditMenuEnum implements EditStrategy{
	a{

		@Override
		public void change(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String newname;
			System.out.println("Informe o novo nome: ");
			newname = input.nextLine();
			employee.get(currentid).setName(newname);			
		}
		
	},
	
	b{

		@Override
		public void change(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String newaddress;
			System.out.println("Informe o novo endereco: ");
			newaddress = input.nextLine();
			employee.get(currentid).setAddress(newaddress);			
		}
		
	},
	
	c{

		@Override
		public void change(Map<Integer, Employees> employee, int currentid, Scanner input) {
			boolean correctInput = false;
			String newtype;
			while(!correctInput) {
				System.out.println("Informe o novo tipo(assalariado,horista,comissionado): ");
				newtype = input.nextLine();
				employee.get(currentid).setType(newtype);
				//try
				try {
					EditTypeEnum.valueOf(newtype).setEmployeeType(employee, currentid, input);
					correctInput = true;
				} catch (IllegalArgumentException e){
					System.out.println("Entrada invalida!");
				}				
			}
			Payment.SetPaymentSchedule(employee,currentid);
		}
		
	},
	
	d{

		@Override
		public void change(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String newpmethod;
			System.out.println("Informe o novo Metodo de pagamento: ");
			newpmethod = input.nextLine();
			if(newpmethod.equals("cheque")) {
				String optionmethod;
				System.out.println("Cheque em maos(1)\nCheque pelos correios(2)");
				optionmethod = input.nextLine();
				if(optionmethod.equals("1")) {
					newpmethod = "cheque em maos";
					employee.get(currentid).setPaymentmethod(newpmethod);
				}
				else if(optionmethod.equals("2")) {
					newpmethod = "cheque pelos correios";
					employee.get(currentid).setPaymentmethod(newpmethod);
				}
			}
			
		}
		
	},
	
	e{

		@Override
		public void change(Map<Integer, Employees> employee, int currentid, Scanner input) {
			double newsalary = 0;
			boolean correctInput = false;
			String trash = null;
			System.out.println("Informe o novo Salario: ");
			//Try
			while(!correctInput) {
				try{
					newsalary = input.nextDouble();
					correctInput = true;
				}
				catch(NumberFormatException e){
					System.out.println("Valor no formato incorreto.");
				}
				catch(InputMismatchException e) {
					System.out.println("Valor no formato incorreto.");
				}
				if(newsalary <= 0) {
					System.out.println("Valor nao aceito. Digite novamente:");
					correctInput = false;
				}
				trash = input.nextLine();
			}
			correctInput = false;
			employee.get(currentid).setSalary(newsalary);
			System.out.println(trash);
		}
		
	},
	
	f{

		@Override
		public void change(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String trash = null;
			String entry;
			boolean correctInput = false;
			if(employee.get(currentid).getUnion().getSyndicatestatus().equals("1")) {
				
				System.out.println("ID do Sindicato: " + employee.get(currentid).getUnion().getSyndicateId());
				System.out.println("Deseja sair do Sindicato? Se sim,pressione 1. Caso contrario, pressione enter.");
				entry = input.nextLine();
				if(entry.equals("1")) {
					employee.get(currentid).getUnion().setSyndicatestatus("2");
					employee.get(currentid).getUnion().setSyndicateId(-1);
					employee.get(currentid).getUnion().setSyndicateServiceTax(-1);
					employee.get(currentid).getUnion().setSyndicateTax(-1);
				}
				else {
					System.out.println("Taxa de Sindicato atual: " + employee.get(currentid).getUnion().getSyndicateTax());
					System.out.println("Deseja modificar a Taxa de Sindicato? Se sim, pressione 1. Caso contrario, pressione enter");
					entry = input.nextLine();
					if(entry.equals("1")) {
						double newtax = 0;
						System.out.println("Informe a nova Taxa de Sindicato: ");
						//Try
						while(!correctInput) {
							try{
								newtax = input.nextDouble();
								correctInput = true;
							}
							catch(NumberFormatException e){
								System.out.println("Valor no formato incorreto.");
							}
							catch(InputMismatchException e) {
								System.out.println("Valor no formato incorreto.");
							}
							if(newtax >= 1 || newtax <= 0) {
								System.out.println("Valor nao aceito. Digite novamente:");
								correctInput = false;
							}
							trash = input.nextLine();
						}
						correctInput = false;
						employee.get(currentid).getUnion().setSyndicateTax(newtax);
					}
				}
			}
			else if(employee.get(currentid).getUnion().getSyndicatestatus().equals("2")) {
				System.out.println("Deseja entrar em Sindicato? Se sim,pressione 1. Caso contrario, pressione enter.");
				entry = input.nextLine();
				if(entry.equals("1")) {
					double syndicatetax = 0;
					System.out.println("Informe a Taxa de Sindicato: ");
					//Try
					while(!correctInput) {
						try{
							syndicatetax = input.nextDouble();
							correctInput = true;
						}
						catch(NumberFormatException e){
							System.out.println("Valor no formato incorreto.");
						}
						catch(InputMismatchException e) {
							System.out.println("Valor no formato incorreto.");
						}
						if(syndicatetax >= 1 || syndicatetax <= 0) {
							System.out.println("Valor nao aceito. Digite novamente:");
							correctInput = false;
						}
						trash = input.nextLine();
					}
					correctInput = false;
					employee.get(currentid).getUnion().setSyndicatestatus("1");
					employee.get(currentid).getUnion().setSyndicateId(currentid+1000);
					employee.get(currentid).getUnion().setSyndicateTax(syndicatetax);
					System.out.println(trash);
				}
			}
		}
	};	
}
