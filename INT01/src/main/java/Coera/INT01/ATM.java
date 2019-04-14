package Coera.INT01;

public class ATM {
      private int openTime;
      private int closeTime;
      private int atmNumber;
      private boolean visited = false;
   
      public ATM(int openTime, int closeTime, int atmNumber) {
    	  
    	  this.openTime = openTime;
    	  this.closeTime = closeTime;
    	  this.atmNumber = atmNumber;
    	 
    	  
      }
      
      //set
      public void setOpenTime(int s) {
    	  this.openTime= s;
      }
      
      public void setCloseTime(int s) {
    	  this.closeTime = s;
      }
      
      public void setAtmNumber(int s) {
    	  this.atmNumber = s;
      }
      
      public void setVisited(boolean s) {
    	  this.visited = s;
      }
      
      //get
      
      public int getOpenTime() {
    	  return openTime;
      }
      
      public int getCloseTime() {
    	  return closeTime;
      }
      
      public int getAtmNumber() {
    	  return atmNumber;
      }
      
      public boolean getVisited() {
    	  return visited;
      }
      
      
      
}
