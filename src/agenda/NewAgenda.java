package agenda;

import folhadepagamento.Principal;
import pay.Payment;

public class NewAgenda {
	public void newAgenda() {
		boolean verify = true,acceptindex = true;
		String newPaymentSchedule,employeetype;
		System.out.println("Informe a nova Agenda de Pagamento(Exemplo: mensal 12, semanal 1 segunda, semanal 2 terca): ");
		newPaymentSchedule = Principal.input.nextLine();
		System.out.println("Para qual tipo de empregado?(assalariado,horista,comissionado): ");
		employeetype = Principal.input.nextLine();
		for(int i = 0;i < Principal.PaymentSchedules.size();i++) {
			//Try
			try {
				Principal.PaymentSchedules.get(i);
			}
			catch(IndexOutOfBoundsException e) {
				acceptindex = false;
			}
			if(acceptindex) {
				if(Principal.PaymentSchedules.get(i).getSchedule().equals(newPaymentSchedule) && 
						Principal.PaymentSchedules.get(i).getEmployeeType().equals(employeetype)) {
					System.out.println("Agenda ja existe");
					verify = false;
					break;
				}
			}
			
		}
		if(verify) {
			Payment SetNew = new Payment();
			SetNew.setSchedule(newPaymentSchedule);
			SetNew.setEmployeeType(employeetype);
			Principal.PaymentSchedules.add(SetNew);
			System.out.println("Criado.");
		}
		System.out.println("Pressione enter para continuar.");
		Principal.input.nextLine();
	}
}
