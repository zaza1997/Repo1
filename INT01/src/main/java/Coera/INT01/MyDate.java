package Coera.INT01;

public class MyDate {
	private int day;
	private int mount;
	private int year;
	private int hour;
	private int minute;
	public MyDate(int day, int mount, int year, int hour, int minute) {
		this.day =day;
		this.mount = mount;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMount() {
		return mount;
	}
	public void setMount(int mount) {
		this.mount = mount;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
}
