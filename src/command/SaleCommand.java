package command;

import folhadepagamento.Sale;

public class SaleCommand implements MainCommand{
	public void execute() {
		Sale sale = new Sale();
		sale.sale();
	}
}
