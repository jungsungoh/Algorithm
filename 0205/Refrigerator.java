package hw;

public class Refrigerator {
	private int sicbyul;
	private String name;
	private int price;
	private int num;
	private int size;
	
	public Refrigerator(int sicbyul, String name, int price, int num, int size) {
		this.sicbyul = sicbyul;
		this.name = name;
		this.price = price;
		this.num = num;
		this.size = size;
	}
	public String toString() {
		String s = sicbyul + "     |  " + name + "     |  "  + price +"     |  "  + num + "     |  "  + size;
		return s;
	}
}
