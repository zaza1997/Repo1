package Coera.INT01;

public class Edge {
       
	private int distance;
	private ATM atm;
	public Edge(ATM atm, int distance){
		this.atm = atm;
		this.distance = distance;
	}
	
	public void setAtm(ATM atm) {
		this.atm = atm;
	}
	
	public void setDistance(int d) {
		this.distance = d;
	}
	
	public ATM getAtm() {
		return atm;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String toString() {
		return "(" + this.atm.getAtmNumber() + "," + this.distance + ")"; 
	}
}
