package edit;

import java.util.Map;
import java.util.Scanner;

import employee.Employees;

public interface EditStrategy {
	public void change (Map<Integer,Employees> employee,int currentid,Scanner input);
}
