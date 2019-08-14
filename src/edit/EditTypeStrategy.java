package edit;
import java.util.Map;
import java.util.Scanner;

import employee.Employees;

public interface EditTypeStrategy {
	public void setEmployeeType (Map<Integer, Employees> employee, int currentid, Scanner input);
}
