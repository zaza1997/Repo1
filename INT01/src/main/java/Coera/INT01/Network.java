package Coera.INT01;

import java.util.LinkedList;
import java.util.List;

public class Network {
	
	List<Edge> N[];
	public Network(int n) {
		N = new LinkedList[n];
		for(int i=0;i <N.length;i++) {
			N[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(int nr, ATM atm, int distance ) {
		N[nr].add(0, new Edge(atm, distance));
    }
	
	
	
	@Override
	public String toString() {
		String result="";
		for(int i= 0 ;i< N.length; i++) {
			result += i + "=>" + N[i] + "\n";
		}
		return result;
	}
	
}
