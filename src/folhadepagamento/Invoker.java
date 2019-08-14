package folhadepagamento;

import java.util.HashMap;
import java.util.Map;

import command.AddManagerCommand;
import command.AgendaCommand;
import command.DeleteManagerCommand;
import command.DisplayManagerCommand;
import command.EditCommand;
import command.MainCommand;
import command.NewAgendaCommand;
import command.PayrollCommand;
import command.SaleCommand;
import command.ServiceCommand;
import command.TimecardCommand;
import command.UndoRedoManagerCommand;

public class Invoker {
	public static Map<String, MainCommand> commands = new HashMap<String, MainCommand>();
	static {
		try {
		commands.put("1", new AddManagerCommand());
		commands.put("2", new DisplayManagerCommand());
		commands.put("3", new DeleteManagerCommand());
		commands.put("4", new TimecardCommand());
		commands.put("5", new SaleCommand());
		commands.put("6", new ServiceCommand());
		commands.put("7", new EditCommand());
		commands.put("8", new PayrollCommand());
		commands.put("9", new UndoRedoManagerCommand());
		commands.put("10", new AgendaCommand());
		commands.put("11", new NewAgendaCommand());
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void invoker (String comando){
		commands.get(comando).execute();
	}
	
}
