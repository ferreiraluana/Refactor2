package folhadepagamento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import employee.Employees;
import pay.Payment;

public class Principal{
	
	public static int id = 0;
	public static Scanner input = new Scanner(System.in);
	public static boolean correctInput = false; 
	public static boolean acceptentry = false;
	static String trash;
	public static Date calendar = new Date();
	public static Map<Integer,Employees> employee = new HashMap<Integer,Employees>();
	public static String option1 = null;
	public static int totalsize = 0;
	public static int positioninarray = -1;
	public static ArrayList<Payment> PaymentSchedules = new ArrayList<Payment>();
	
	public static void main(String[] args) {
		Scheduleinit();		
		Undo_Redo.Save(option1,totalsize,positioninarray,employee);
		while(true) {
			printMenu();			
			option1 = input.nextLine();
			if(option1.equals("0")) {
				System.out.println("Obrigado(a) por utilizar nossos serviços!\n****Fim!****");
				break;
			}
			Invoker.invoker(option1);
		}
		input.close();
	}
	
	public static void Scheduleinit() {
		
		Payment SetDefault0 = new Payment();
		SetDefault0.setSchedule("semanalmente");
		SetDefault0.setEmployeeType("horista");
		PaymentSchedules.add(SetDefault0);
		
		Payment SetDefault1 = new Payment();
		SetDefault1.setSchedule("mensalmente");
		SetDefault1.setEmployeeType("assalariado");
		PaymentSchedules.add(SetDefault1);
		
		Payment SetDefault2 = new Payment();
		SetDefault2.setSchedule("bi-semanalmente");
		SetDefault2.setEmployeeType("comissionado");
		PaymentSchedules.add(SetDefault2);		
	}
	
	public static void printMenu() {
		System.out.println("*******************************************");
		System.out.println("Bem-vindo ao sistema de folha de pagamento!");
		System.out.println("Data de hoje: " + calendar.day + '/' + calendar.month + '/' + calendar.year);
		System.out.println("[1]Adicionar Empregado\n[2]Visualizar Empregados\n[3]Remover Empregado\n[4]Lançar"
				+ " Cartao de Ponto\n[5]Lancar Resultado de Venda\n[6]Lancar Taxa de Servico\n[7]Alterar Empregado\n[8]Rodar"
				+ " a folha de Pagamento\n[9]Undo/Redo\n[10]Agenda de Pagamento\n[11]Criar Agenda de Pagamento\n[0]Sair\n");
		System.out.println("*******************************************");
	}
}