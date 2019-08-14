package manager;

import employee.Employees;
import folhadepagamento.Principal;
import syndicate.Singleton;
import syndicate.SyndicateCG;

public class DisplayManager {
	
	public void display() {
		boolean accept = false;
		SyndicateCG synd = Singleton.getInstance();
		
		if(Principal.employee.size() != 0) {
			for(int i = 1; i <= Principal.totalsize;i++) {
				if(Principal.employee.containsKey(i)) {
					accept = true;
					System.out.println("Nome: " + Principal.employee.get(i).getName());
					System.out.println("Id: " + Principal.employee.get(i).getEmployeeid());
					System.out.println("Tipo: " + Principal.employee.get(i).getType());
					System.out.println("Pagamento em: " + Principal.employee.get(i).getPaymentPaper().getPaymentday() + "/" + Principal.employee.get(i).getPaymentPaper().getPaymentmonth() + "/" + 
					Principal.employee.get(i).getPaymentPaper().getPaymentyear() + " -Dia da Semana: " + Principal.employee.get(i).getPaymentPaper().getPaymentdayofweek());
					System.out.println("Salario: " + Principal.employee.get(i).getSalary());
					if(Principal.employee.get(i).getUnion().getSyndicatestatus().equals("1")) {
						if(Principal.employee.get(i) instanceof Employees) {
							System.out.println("Faz parte de Sindicato");
							System.out.println("ID do Sindicato: " + Principal.employee.get(i).getUnion().getSyndicateId());
							synd.SyndicateCharge(Principal.employee, i);
							System.out.println("Taxa de Sindicato: " + Principal.employee.get(i).getUnion().getSyndicateTax());
							if(Principal.employee.get(i).getUnion().getSyndicateServiceTax() != 0) {
								System.out.println("Taxa de Servico do Sindicato: " + Principal.employee.get(i).getUnion().getSyndicateServiceTax());
								Principal.employee.get(i).getUnion().setSyndicateServiceTax(0);
							}
							else System.out.println("Nao ha Taxas de Servico do Sindicato");
						}
						else System.out.println("Nao foi possivel associar empregado.");
					}
					System.out.println("----------------------------------");
				}
			}
			if(!accept) System.out.println("Nao existem empregados.");
		}
		else System.out.println("Nao existem empregados.");
		
		System.out.println("Pressione enter para continuar.");
		Principal.input.nextLine();
	}
	
	public static void displayInitialInfo (int i) {
		System.out.println("----------------------------------------------");
		System.out.println("Nome: " + Principal.employee.get(i).getName());
		System.out.println("Id: " + Principal.employee.get(i).getEmployeeid());
		System.out.println("Tipo: " + Principal.employee.get(i).getType());
		System.out.println("Pagamento em: " + Principal.employee.get(i).getPaymentPaper().getPaymentday() + "/" + Principal.employee.get(i).getPaymentPaper().getPaymentmonth() + "/" + 
		Principal.employee.get(i).getPaymentPaper().getPaymentyear() + " -Dia da Semana: " + Principal.employee.get(i).getPaymentPaper().getPaymentdayofweek());
		System.out.println("Salario: " + Principal.employee.get(i).getSalary());
	}
	
	public static void displayEmployee (int i) {
		SyndicateCG synd = Singleton.getInstance();
		displayInitialInfo(i);
		if(Principal.employee.get(i).getUnion().getSyndicatestatus().equals("1")) {
			if(Principal.employee.get(i) instanceof Employees) {
				System.out.println("Faz parte de Sindicato");
				System.out.println("ID do Sindicato: " + Principal.employee.get(i).getUnion().getSyndicateId());
				synd.SyndicateCharge(Principal.employee, i);
				System.out.println("Taxa de Sindicato: " + Principal.employee.get(i).getUnion().getSyndicateTax());
				if(Principal.employee.get(i).getUnion().getSyndicateServiceTax() != 0) {
					System.out.println("Taxa de Servico do Sindicato: " + Principal.employee.get(i).getUnion().getSyndicateServiceTax());
					Principal.employee.get(i).getUnion().setSyndicateServiceTax(0);
				}
				else System.out.println("Nao ha Taxas de Servico do Sindicato");
			}
		}
		System.out.println("----------------------------------------------");
	}
}
