package folhadepagamento;

public class Date {
	public int day; 
	public int month;
	public int year;
	public int dayofweek;
	int[] maxdays = new int[13];	
	
	public Date() {		
		setMaxDays();
		boolean correctInput = false;
		
		System.out.println("Iniciando o sistema...\nDigite a data atual:");
		while(!correctInput)
			try {
			System.out.println("Ano:");
			this.year = Principal.input.nextInt();
			if(this.year <= 0) {
				throw new Exception("Entrada inválida. O ano não pode ser negativo.\nDigite novamente.\n");
			}Principal.input.nextLine();				
			
			System.out.println("Mês:");
			this.month = Principal.input.nextInt();			
				if(this.month <= 0 || this.month > 12) {
					throw new Exception("Entrada inválida. O mês está fora do intervalo 1-12.\nDigite Novamente.\n");
				}Principal.input.nextLine();
			
			System.out.println("Dia do mês:");
			this.day = Principal.input.nextInt();
				if(this.day <= 0 || this.day > 31) {
					throw new Exception("Entrada inválida. O dia está fora do intervalo 1-31.\\nDigite Novamente.\\n");
				}Principal.input.nextLine();
			
			System.out.println("Dia da semana:\n(1)Dom\n(2)Seg\n(3)Ter\n(4)Qua\n(5)Qui\n(6)Sex\n(7)Sáb");
			this.dayofweek = Principal.input.nextInt();
				if(this.dayofweek <=0 || this.dayofweek > 7) {
					throw new Exception("Entrada inválida. O dia da semana está fora do intervalo 1-7.\\nDigite Novamente.\\n");
				}Principal.input.nextLine();
			
			correctInput = true;
			
			} catch (Exception e) {
				System.out.println(e);
			}
	}
	
	public void nextDay(){
		day++;
		dayofweek++;
		int actualMonth = Principal.calendar.month;
		int actualDay = Principal.calendar.day;
		if(dayofweek == 8) dayofweek = 1;
		if(actualDay > Principal.calendar.maxdays[actualMonth]) {
			if(actualMonth == 12) {
				Principal.calendar.day = 1;
				Principal.calendar.month = 1;
				Principal.calendar.year += 1;
			}
			else {
				Principal.calendar.day = 1;
				Principal.calendar.month += 1;
			}
		}
	}
	
	public void setMaxDays() {
		this.maxdays[1] = 31;
		this.maxdays[2] = 28;
		this.maxdays[3] = 31;
		this.maxdays[4] = 30;
		this.maxdays[5] = 31;
		this.maxdays[6] = 30;
		this.maxdays[7] = 31;
		this.maxdays[8] = 31;
		this.maxdays[9] = 30;
		this.maxdays[10] = 31;
		this.maxdays[11] = 30;
		this.maxdays[12] = 31;
	}
}