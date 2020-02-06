package hw;

public class Product {
	private int num;
	private String name;
	private int price;
	private int su;
	private int check;
	public Product(int num, String name, int price, int su) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.su = su;
		this.check = 0;
	}
	@Override
	public String toString() {
		return "num=" + num + ", name=" + name + ", price=" + price + ", su=" + su;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int check() {
		return check;
	}
	
}
