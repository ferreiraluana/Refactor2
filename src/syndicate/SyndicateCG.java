package syndicate;

import java.util.Map;

import employee.Employees;

public class SyndicateCG {
	public void SyndicateCharge(Map<Integer,Employees> employee,int employeeindex) {
		if(employee.get(employeeindex).getUnion().getSyndicatestatus().equals("1") && employee.get(employeeindex).getPaymentPaper().getPayment() != 0) {
			double salary = employee.get(employeeindex).getPaymentPaper().getPayment();
			double tax =  employee.get(employeeindex).getUnion().getSyndicateTax();
			double servicetax = employee.get(employeeindex).getUnion().getSyndicateServiceTax();
			tax = salary * (tax+servicetax);
			salary = salary - tax;
			employee.get(employeeindex).getPaymentPaper().setPayment(salary);
		}
	}
}
