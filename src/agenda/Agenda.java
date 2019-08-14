package agenda;

import java.util.InputMismatchException;

import employee.Employees;
import folhadepagamento.Principal;
import pay.Payment;

public class Agenda {
	public void agenda(){
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
			Principal.input.nextLine();
		}
		Principal.correctInput = false;
		if(Principal.employee.containsKey(currentemployeeid)) {
			if(Principal.employee.get(currentemployeeid) instanceof Employees) {
				String entry;
				System.out.println("Agenda de Pagamento atual - O Empregado e pago: " + 
				Principal.employee.get(currentemployeeid).getPaymentPaper().getPaymentschedule());
				System.out.println("Deseja modificar a Agenda de Pagamento? Se sim, pressione 1. Se nao, pressione enter");
				entry = Principal.input.nextLine();
				if(entry.equals("1")) {
					boolean acceptindex = true;
					System.out.println("Informe uma das opcoes abaixo: ");
					for(int i = 0;i < Principal.PaymentSchedules.size();i++) {
						//Try
						try {
							Principal.PaymentSchedules.get(i);
						}
						catch(IndexOutOfBoundsException e) {
							acceptindex = false;
						}
						if(acceptindex) {
							//Payment current = Payment.getPaymentByEmployee(Principal.PaymentSchedules,Principal.employee.get(currentemployeeid).getType());
							if(Principal.employee.get(currentemployeeid).getType().equals(Principal.PaymentSchedules.get(i).getEmployeeType())) {
								System.out.println(Principal.PaymentSchedules.get(i).getSchedule());
							}
							acceptindex = true;
						}
					}
					acceptindex = true;
					boolean validateschedule = false;
					String schedule;
					schedule = Principal.input.nextLine();
					for(int i = 0;i < Principal.PaymentSchedules.size();i++) {
						//Try
						try {
							Principal.PaymentSchedules.get(i);
						}
						catch(IndexOutOfBoundsException e) {
							acceptindex = false;
						}
						if(acceptindex) {
							if(schedule.equals(Principal.PaymentSchedules.get(i).getSchedule()) && 
									Principal.employee.get(currentemployeeid).getType().equals(Principal.PaymentSchedules.get(i).getEmployeeType())) {
								validateschedule = true;
								break;
							}
							acceptindex = true;
						}
					}
					if(validateschedule) {
						if(Principal.employee.get(currentemployeeid).getType().equals("assalariado") && (!(schedule.equals("mensalmente") && 
								!(schedule.equals("mensal $"))))) {
							String now = null;
							int DayOFMonth = 0;
							now = schedule.replaceAll("[^0-9]", "");
							DayOFMonth = Integer.parseInt(now);
							if(DayOFMonth > Principal.calendar.day) {
								Principal.employee.get(currentemployeeid).getPaymentPaper().setPaymentschedule(schedule);
								Payment.SetPaymentSchedule(Principal.employee, currentemployeeid);
							}
							else System.out.println("Nao foi possivel atualizar, data invalida");
						}
						else {
							Principal.employee.get(currentemployeeid).getPaymentPaper().setPaymentschedule(schedule);
							Payment.SetPaymentSchedule(Principal.employee, currentemployeeid);
						}
					}
					else System.out.println("Agenda nao existe.");
				}
			}
			else System.out.println("Nao foi possivel associar empregado.");
		}
		else System.out.println("Nao foi possivel encontrar o empregado.");
		System.out.println("Pressione enter para continuar.");
		Principal.input.nextLine();
	}
}
