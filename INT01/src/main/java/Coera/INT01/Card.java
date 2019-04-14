package Coera.INT01;



public class Card {
	private String creditCard;
	private double fee;
	private int limit;
	private MyDate expiration ;
	private int amount;
	
	public Card(String creditCard, double fee, int limit, MyDate expiration, int amount) {
			
		this.creditCard = creditCard;
		this.expiration = expiration;
		this.fee = fee; 
		this.limit= limit;
		this.amount = amount;
		
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public MyDate getExpiration() {
		return expiration;
	}

	public void setExpiration(MyDate expiration) {
		this.expiration = expiration;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
