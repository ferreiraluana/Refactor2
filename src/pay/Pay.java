package pay;
import java.util.Map;

import employee.Employees;

public interface Pay {
	public void calculateSalary (Map<Integer,Employees> employee,int employeeindex);
}
