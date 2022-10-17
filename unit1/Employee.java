public class Employee{
	private String name;
	private double hours;

	public Employee(String name, double hours){
		this.name = name;
		this.hours = hours;
	}

	public void changeName(String name){
		this.name = name;
	}

	public void addHours(double hours){
		this.hours += hours;
	}

	public String toString(){
		return "Name: " + this.name + "\nHours: " + this.hours;
	}
}