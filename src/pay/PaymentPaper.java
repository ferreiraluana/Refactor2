package pay;

public class PaymentPaper {
	
	private double payment = 0;
	private String paymentschedule;
	private int paymentday = 0;
	private int paymentmonth = 0;
	private int paymentyear = 0;
	private int paymentdayofweek = 0;
	
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public String getPaymentschedule() {
		return paymentschedule;
	}
	public void setPaymentschedule(String paymentschedule) {
		this.paymentschedule = paymentschedule;
	}
	public int getPaymentday() {
		return paymentday;
	}
	public void setPaymentday(int paymentday) {
		this.paymentday = paymentday;
	}
	public int getPaymentmonth() {
		return paymentmonth;
	}
	public void setPaymentmonth(int paymentmonth) {
		this.paymentmonth = paymentmonth;
	}
	public int getPaymentyear() {
		return paymentyear;
	}
	public void setPaymentyear(int paymentyear) {
		this.paymentyear = paymentyear;
	}
	public int getPaymentdayofweek() {
		return paymentdayofweek;
	}
	public void setPaymentdayofweek(int paymentdayofweek) {
		this.paymentdayofweek = paymentdayofweek;
	}
	

}
