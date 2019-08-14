package folhadepagamento;

import java.util.InputMismatchException;

import employee.Employees;
import employee.Hourly;

public class Timecard {

		public void card() {
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
				if(Principal.employee.get(currentemployeeid).getType().equals("horista")) {
					int arrival = -1,exit = -1;
					if(Principal.employee.get(currentemployeeid) instanceof Employees) {
						boolean acceptindex = true;
						Hourly currentemployee = (Hourly) Principal.employee.get(currentemployeeid);
						if(currentemployee.getChecksetofday() == 0) {
							Hourly newhourly = new Hourly(-1,-1,0,0,currentemployee.getName(),currentemployee.getAddress(),
									currentemployee.getType(),currentemployee.getPaymentmethod(),currentemployee.getPaymentPaper().getPaymentschedule(),
									currentemployee.getEmployeeid(),currentemployee.getSalary(),currentemployee.getFirstDay(),
									currentemployee.getFirstMonth(),currentemployee.getFirstYear(),
									currentemployee.getFirstDayOfWeek(),currentemployee.getUnion().getSyndicatestatus(),
									currentemployee.getUnion().getSyndicateTax());
							newhourly.setArrivaltime(-1);
							newhourly.setExittime(-1);
							newhourly.setDailypayment(0);
							currentemployee.getPaymentDaily().add(newhourly);
							currentemployee.setChecksetofday(1);
							Principal.positioninarray = currentemployee.getPaymentDaily().size()-1;
						}
						if(currentemployee.getChecksetofday() == 1){
							//Try
							try {
								currentemployee.getPaymentDaily().get(Principal.positioninarray).getArrivaltime();
							}
							catch(IndexOutOfBoundsException e) {
								System.out.println("Nao foi possivel acessar.Necessario informar hora de chegada "
										+ "novamente.Selecione a opcao novamente.");
								Principal.positioninarray--;
								acceptindex = false;
							}
							if(acceptindex)
							{
								if((currentemployee.getPaymentDaily().get(Principal.positioninarray).getArrivaltime() == -1)) {
									System.out.println("Informe a hora de chegada do empregado: ");
									//Try
									while(!Principal.correctInput) {
										try{
											arrival = Principal.input.nextInt();
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
									currentemployee.getPaymentDaily().get(Principal.positioninarray).setArrivaltime(arrival);
									Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
								}
								else if(currentemployee.getPaymentDaily().get(Principal.positioninarray).getExittime() == -1) {
										System.out.println("Informe a hora de saida do empregado: ");
										//Try
										while(!Principal.correctInput) {
											try{
												exit = Principal.input.nextInt();
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
										currentemployee.getPaymentDaily().get(Principal.positioninarray).setExittime(exit);
										Undo_Redo.Save(Principal.option1,Principal.totalsize,Principal.positioninarray,Principal.employee);
								}
							}
						}
					}
					else System.out.println("Nao foi possivel associar empregado.");
				}
				else System.out.println("Empregado nao e horista.");
			}
			else System.out.println("Nao foi possivel encontrar o empregado.");
			
			System.out.println("Pressione enter para continuar.");
			Principal.trash = Principal.input.nextLine();
		}
}
