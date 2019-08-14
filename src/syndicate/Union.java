package syndicate;

public class Union {
	
	private String syndicatestatus;
	private int syndicateId;
	private double syndicateTax;
	private double syndicateServiceTax;
	
	public Union(String syndicatestatus, int syndicateId, double syndicateTax, double syndicateServiceTax) {
		
		this.syndicatestatus = syndicatestatus;
		this.syndicateId = syndicateId;
		this.syndicateTax = syndicateTax;
		this.syndicateServiceTax = syndicateServiceTax;
	}
	public String getSyndicatestatus() {
		return syndicatestatus;
	}
	public void setSyndicatestatus(String syndicatestatus) {
		this.syndicatestatus = syndicatestatus;
	}
	public int getSyndicateId() {
		return syndicateId;
	}
	public void setSyndicateId(int syndicateId) {
		this.syndicateId = syndicateId;
	}
	public double getSyndicateTax() {
		return syndicateTax;
	}
	public void setSyndicateTax(double syndicateTax) {
		this.syndicateTax = syndicateTax;
	}
	public double getSyndicateServiceTax() {
		return syndicateServiceTax;
	}
	public void setSyndicateServiceTax(double syndicateServiceTax) {
		this.syndicateServiceTax = syndicateServiceTax;
	}
}
	