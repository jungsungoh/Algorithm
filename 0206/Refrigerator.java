package hw;

public class Refrigerator extends Product{
	private int size;
	private int check;
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Refrigerator(int num, String name, int price, int su, int size) {
		super(num, name, price, su);
		this.size = size;
		this.check = 1;
		
	}

	@Override
	public String toString() {
		String s = super.toString() + "size = " + size;
		return s;
	}
	
}
