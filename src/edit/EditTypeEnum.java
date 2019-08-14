package edit;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import employee.Employees;

public enum EditTypeEnum implements EditTypeStrategy{
	assalariado{

		@Override
		public void setEmployeeType(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String trash = null;
			if(employee.get(currentid) instanceof Employees) {
				System.out.println("Informe o salario mensal: ");
				double salary = 0;
				boolean correctInput = false;
				//Try
				while(!correctInput) {
					try{
						salary = input.nextDouble();
						correctInput = true;
					}
					catch(NumberFormatException e){
						System.out.println("Valor no formato incorreto.");
					}
					catch(InputMismatchException e) {
						System.out.println("Valor no formato incorreto.");
					}
					if(salary <= 0) {
						System.out.println("Valor nao aceito. Digite novamente: ");
						correctInput = false;
					}
					trash = input.nextLine();
				}
				correctInput = false;
				Employees.addEmployee(employee, employee.get(currentid).getName(), employee.get(currentid).getAddress(), "assalariado", employee.get(currentid).getPaymentmethod(), "mensalmente", currentid, salary, employee.get(currentid).getFirstDay(), employee.get(currentid).getFirstMonth(), employee.get(currentid).getFirstYear(), employee.get(currentid).getFirstDayOfWeek(), employee.get(currentid).getUnion().getSyndicatestatus(), employee.get(currentid).getUnion().getSyndicateTax(),0);
			}
			else System.out.println("Nao foi possivel associar." + trash);
			
		}
		
	},
	
	horista{

		@Override
		public void setEmployeeType(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String trash = null;
			if(employee.get(currentid) instanceof Employees) {
				System.out.println("Informe o salario por hora: ");
				double salary = 0;
				boolean correctInput = false;
				//Try
				while(!correctInput) {
					try{
						salary = input.nextDouble();
						correctInput = true;
					}
					catch(NumberFormatException e){
						System.out.println("Valor no formato incorreto.");
					}
					catch(InputMismatchException e) {
						System.out.println("Valor no formato incorreto.");
					}
					if(salary <= 0) {
						System.out.println("Valor nao aceito. Digite novamente: ");
						correctInput = false;
					}
					trash = input.nextLine();
				}
				correctInput = false;
				Employees.addEmployee(employee, employee.get(currentid).getName(), employee.get(currentid).getAddress(), "horista", employee.get(currentid).getPaymentmethod(), "semanalmente", currentid,salary, employee.get(currentid).getFirstDay(), employee.get(currentid).getFirstMonth(), employee.get(currentid).getFirstYear(), employee.get(currentid).getFirstDayOfWeek(), employee.get(currentid).getUnion().getSyndicatestatus(), employee.get(currentid).getUnion().getSyndicateTax(),0);
			}
			else System.out.println("Nao foi possivel associar." + trash);
			
		}
		
	},
	
	comissionado{

		@Override
		public void setEmployeeType(Map<Integer, Employees> employee, int currentid, Scanner input) {
			String trash = null;
			if(employee.get(currentid) instanceof Employees) {
				System.out.println("Informe o salario quinzenal: ");
				double salary = 0;
				boolean correctInput = false;
				//Try
				while(!correctInput) {
					try{
						salary = input.nextDouble();
						correctInput = true;
					}
					catch(NumberFormatException e){
						System.out.println("Valor no formato incorreto.");
					}
					catch(InputMismatchException e) {
						System.out.println("Valor no formato incorreto.");
					}
					if(salary <= 0) {
						System.out.println("Valor nao aceito. Digite novamente: ");
						correctInput = false;
					}
					trash = input.nextLine();
				}
				correctInput = false;
				double commission = 0;
				System.out.println("Informe a comissao(Exemplo: 0,15): ");
				//Try
				while(!correctInput) {
					try{
						commission = input.nextDouble();
						correctInput = true;
					}
					catch(NumberFormatException e){
						System.out.println("Valor no formato incorreto. Digite novamente:");
					}
					catch(InputMismatchException e) {
						System.out.println("Valor no formato incorreto. Digite novamente:");
					}
					if(commission >= 1 || commission <= 0) {
						System.out.println("Valor nao aceito. Digite novamente:");
						correctInput = false;
					}
					trash = input.nextLine();
				}
				correctInput = false;
				Employees.addEmployee(employee, employee.get(currentid).getName(), employee.get(currentid).getAddress(), "comissionado", employee.get(currentid).getPaymentmethod(), "bi-semanalmente", currentid, salary, employee.get(currentid).getFirstDay(), employee.get(currentid).getFirstMonth(), employee.get(currentid).getFirstYear(), employee.get(currentid).getFirstDayOfWeek(), employee.get(currentid).getUnion().getSyndicatestatus(), employee.get(currentid).getUnion().getSyndicateTax(),commission);
			}
			else System.out.println("Nao foi possivel associar." + trash);
			
		}
		
	};
}
