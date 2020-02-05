package hw;

public class TV {
	private int sicbyul;
	private String name;
	private int price;
	private int num;
	private int inch;
	private String display;
	
	public TV(int sicbyul, String name, int price, int num, int inch, String display) {
		this.sicbyul = sicbyul;
		this.name = name;
		this.price = price;
		this.num = num;
		this.inch = inch;
		this.display = display;
	}
	public String toString() {
		String s = sicbyul + "     |  " + name + "     |  "  + price +"     |  "  + num + "     |  "  + inch + "     |  "  + display;
		return s;
	}
}
