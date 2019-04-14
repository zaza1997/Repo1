package Coera.INT01;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App 
{   
	private static ATM atm1 = new ATM(12, 18, 1);
    private static ATM atm2 = new ATM(10, 17, 2);
	private static ATM atm3 = new ATM(22, 12, 3);
	private static ATM atm4 = new ATM(17, 1,  4);
	
	MyDate data1 = new MyDate(23, 5, 2020, 0, 0);
	MyDate data2 = new MyDate(15, 8, 2018, 0, 0);
	MyDate data3 = new MyDate(20, 3, 2019, 0, 0);
	
    Card silver = new Card("SILVER", 0.2, 4500, data1, 20000);
    Card gold = new Card("GOLD", 0.1, 3000, data2, 25000);
    Card platinum = new Card("PLATINUM", 0, 4000, data3, 3000);
    
    public static void main( String[] args ){
    	
    	
        Network list1 = new Network(5);
    	list1.addEdge(0, atm1, 5);
    	list1.addEdge(0, atm2, 60);
    	list1.addEdge(0, atm3, 30);
    	list1.addEdge(0, atm4, 45);
    	list1.addEdge(1, atm2, 40);
    	list1.addEdge(1, atm4, 45);
    	list1.addEdge(2, atm3, 15);
    	list1.addEdge(3, atm1, 40);
    	list1.addEdge(3, atm4, 15);
    	list1.addEdge(4, atm2, 30);
    	
    	 System.out.println(list1);
         System.out.println(45%60);
    	
            	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Introduceti data actuala:");
    	System.out.println("Zi:");
    	int day = sc.nextInt();
    	System.out.println("Luna:");
    	int mount = sc.nextInt();
    	System.out.println("An:");
    	int year = sc.nextInt();
    	
    	System.out.println("Ora:");
    	int hour = sc.nextInt();
    	System.out.println("Minute:");
    	int minute = sc.nextInt();
    	
    	MyDate currentDate  = new MyDate(day, mount, year, hour, minute);
    	
    
    	System.out.println("Introduceti data deadline-ului:");
    	System.out.println("Zi:");
    	day = sc.nextInt();
    	System.out.println("Luna:");
        mount = sc.nextInt();
    	System.out.println("An:");
    	year = sc.nextInt();
    	
    	System.out.println("Ora:");
        hour = sc.nextInt();
    	System.out.println("Minute:");
    	minute = sc.nextInt();
    	
    	MyDate deadlineDate  = new MyDate(day, mount, year, hour, minute);
    	System.out.println("Suma ce trebuie scoasa:");
    	int  sum = sc.nextInt();
    	
    	App app = new App();
    	List<ATM> result = app.getAtmsRoute(list1, deadlineDate, currentDate, sum);
        for(int i = 0; i< result.size(); i++) {
        	System.out.println(result.get(i).getAtmNumber());
        }
    }
    
   public List<ATM> getAtmsRoute(Network atmList, MyDate deadlineDate, MyDate currentDate, int sum){
    	List<ATM> resultList = new ArrayList<ATM>();
	    int minute;
	    int hour;
	    int number = 0 ;
	    int surplus = 0;
	    int surplusMin= 1000;
	    for(int i=0; i< atmList.N.length; i++) {
	    	
		    for(int j=0; j< atmList.N[i].size(); j++) {
		    	
		    	
		    	Edge e = atmList.N[i].get(j);
		    	ATM atm = atmList.N[i].get(j).getAtm();
		    	minute = currentDate.getMinute() + e.getDistance();
		    	hour = currentDate.getHour() + minute / 60;
		    	minute  = minute % 60;
		    	
		    	if(atm.getOpenTime() < atm.getCloseTime()) {
		    		if(!(hour > atm.getOpenTime() && hour < atm.getCloseTime())) {
		    			surplus =  (atm.getOpenTime() - currentDate.getHour()  -1) * 60 + 60 - currentDate.getMinute();
		    		}
		    		else {
		    			surplus  = e.getDistance();
		    		}
		    	}
		    	else {
		    		if(!((hour > atm.getOpenTime() && hour < 24) ||( hour >= 0 && hour < atm.getCloseTime()))) {
		    			surplus =  (atm.getOpenTime() - currentDate.getHour()  -1) * 60 + 60 - currentDate.getMinute();
		    		}
		    		else {
		    			surplus  = e.getDistance();
		    		}
		    	}
		    	if(surplus < surplusMin && atm.getVisited()!= true) {
		    		
		    		surplusMin =surplus;
		    		number = j;
		    	}
		    }
		    
		    if(platinum.getAmount()!=0) { // && expiration date is good 
		    	if(sum < platinum.getAmount()) {
		    		platinum.setAmount(platinum.getAmount() - sum);
		    		resultList.add(atmList.N[i].get(number).getAtm());
		    		atmList.N[i].get(number).getAtm().setVisited(true);
		    		return resultList; 
		    	}
		    	else {
		    		sum = sum - platinum.getAmount();
		    		platinum.setAmount(0);
		    		resultList.add(atmList.N[i].get(number).getAtm());
		      		atmList.N[i].get(number).getAtm().setVisited(true);
		    	}
		    }
		    else if(gold.getAmount()!= 0) {
		    	if(sum < gold.getLimit()) {
		    		gold.setAmount(gold.getAmount() -sum);
		    		resultList.add(atmList.N[i].get(number).getAtm());
		    		atmList.N[i].get(number).getAtm().setVisited(true);
		    		return resultList; 
		    	}
		    	else {
		    		sum = sum - gold.getLimit();
		    		gold.setAmount(gold.getAmount()- gold.getLimit());
		    		resultList.add(atmList.N[i].get(number).getAtm());
		    		atmList.N[i].get(number).getAtm().setVisited(true);
		    	}   
		    }
		    else if(silver.getAmount()!=0) {
		    	if(sum < silver.getLimit()) {
		    		silver.setAmount(silver.getAmount() -sum);
		    		resultList.add(atmList.N[i].get(number).getAtm());
		    		atmList.N[i].get(number).getAtm().setVisited(true);
		    		return resultList; 
		    	}
		    	else {
		    		sum = sum - silver.getLimit();
		    		silver.setAmount(silver.getAmount()- silver.getLimit());
		    		resultList.add(atmList.N[i].get(number).getAtm());
		    		atmList.N[i].get(number).getAtm().setVisited(true);
		    	}   
		    }
	    }
	    return resultList;
	   
   }
   
}
