package employee;

import java.util.Map;
import java.util.Scanner;

import edit.EditMenuEnum;
import manager.DisplayManager;
import pay.Pay;
import pay.Payment;
import pay.PaymentPaper;
import syndicate.Union;

public class Employees implements Pay{
	
	private String name;
	private String address;
	private String type;
	private String paymentmethod;
	private int employeeid;
	private double salary;
	
	//Criar objeto que cuide disso 
	private int firstDay;
	private int firstMonth;
	private int firstYear;
	private int firstDayOfWeek;
	
	private PaymentPaper pp = new PaymentPaper();
	private Union union;
	
	public Union getUnion() {
		return this.union;
	}
	
	public PaymentPaper getPaymentPaper() {
		return this.pp;
	}
	
	public Employees(String ename, String eaddress, String etype, String pmethod,String epschedule,int eid, double esalary, int fday,int fmonth, int fyear, int fdayofweek,String esyndicate,double esyndicatetax) {
		
		this.name = ename;
		this.address = eaddress;
		this.type = etype;
		this.paymentmethod = pmethod;
		this.employeeid = eid;
		this.salary = esalary;
		
		this.pp.setPaymentschedule(epschedule);
		
		setFirstDay(fday);
		setFirstMonth(fmonth);
		setFirstYear(fyear);
		setFirstDayOfWeek(fdayofweek);
		
		this.union = new Union(esyndicate, eid+1000, esyndicatetax, 0);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getFirstDay() {
		return firstDay;
	}
	public void setFirstDay(int firstDay) {
		this.firstDay = firstDay;
	}
	public int getFirstMonth() {
		return firstMonth;
	}
	public void setFirstMonth(int firstMonth) {
		this.firstMonth = firstMonth;
	}
	public int getFirstYear() {
		return firstYear;
	}
	public void setFirstYear(int firstYear) {
		this.firstYear = firstYear;
	}
	public int getFirstDayOfWeek() {
		return firstDayOfWeek;
	}
	public void setFirstDayOfWeek(int firstDayOfWeek) {
		this.firstDayOfWeek = firstDayOfWeek;
	}
	
	public static void addEmployee(Map<Integer,Employees> employee,String ename,String eaddress,String etype,String pmethod,String epschedule,int eid,double esalary,int fday,int fmonth,int fyear,int fdayofweek,String esyndicate,double esyndicatetax,double ecommission) {
		Employees newemployee;
		boolean acceptadd = true;
		//Try
		try {
			etype.equals("assalariado");
		}
		catch(NullPointerException e) {
			System.out.println("Nao foi possivel adicionar.");
			acceptadd = false;
		}
		try {
			etype.equals("horista");
		}
		catch(NullPointerException e) {
			System.out.println("Nao foi possivel adicionar.");
			acceptadd = false;
		}
		try {
			etype.equals("comissionado");
		}
		catch(NullPointerException e) {
			System.out.println("Nao foi possivel adicionar.");
			acceptadd = false;
		}
		if(acceptadd) {
			if(etype.equals("assalariado")) {
				newemployee = new Employees(ename,eaddress,etype,pmethod,epschedule,eid,esalary,fday,fmonth,fyear,fdayofweek,esyndicate,esyndicatetax);
			}
			else if(etype.equals("horista")) {
				newemployee = new Hourly(-1,-1,0,0,ename,eaddress,etype,pmethod,epschedule,eid,esalary,fday,fmonth,fyear,fdayofweek,esyndicate,esyndicatetax);
			}
			else {
				newemployee = new Commissioned(0,0,ename,eaddress,etype,pmethod,epschedule,eid,esalary,fday,fmonth,fyear,fdayofweek,esyndicate,esyndicatetax,ecommission);
			}
			if(employee.size() != 0) {
				if(employee.containsValue(newemployee)) {
						System.out.println("Empregado ja existe.");
				}
				else {
					employee.put(eid,newemployee);
					Payment.SetPaymentSchedule(employee, eid);
				}
			}
			else {
				employee.put(eid,newemployee);
				Payment.SetPaymentSchedule(employee, eid);
			}
		}
		
	}
	
	public static void EditProfile(Map<Integer,Employees> employee,int currentid,Scanner input) {
		while(true) {	
			System.out.println("Digite a característica que deseja alterar:");
			System.out.println("[a]Nome\n[b]Endereço\n[c]Tipo: horista, comissionado ou assalariado\n[d]Método de Pagamento");
			System.out.println("[e]Salário\n[f]Status do Sindicato\n[0]Voltar");
			String c = input.nextLine();
			if(!c.equals("0")) {
				//try
				try {
					EditMenuEnum.valueOf(c).change(employee, currentid, input);
				} catch (IllegalArgumentException e){
					System.out.println("Entrada invalida!");
				}
				
			}
			else break;
			DisplayManager.displayEmployee(currentid);
		}	
		System.out.println("Pressione enter para continuar.");
		String trash = input.nextLine();
		System.out.println(trash);
	
	}	
	
	public void calculateSalary(Map<Integer,Employees> employee,int employeeindex) {
		employee.get(employeeindex).getPaymentPaper().setPayment(employee.get(employeeindex).getSalary());
	}
}
