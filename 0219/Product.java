package hw;

public class Product {
	private int bunho, price, num;
	private String name;
	public Product(int bunho, int price, int num, String name) {
		super();
		this.bunho = bunho;
		this.price = price;
		this.num = num;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Product bunho=" + bunho + ", price=" + price + ", num=" + num + ", name=" + name;
	}
	public int getBunho() {
		return bunho;
	}
	public void setBunho(int bunho) {
		this.bunho = bunho;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	
}
