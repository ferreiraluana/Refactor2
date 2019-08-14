package command;

import folhadepagamento.Service;

public class ServiceCommand implements MainCommand{
	public void execute() {
		Service service = new Service();
		service.service();
	}
}
