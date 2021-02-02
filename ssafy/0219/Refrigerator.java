package hw;

public class Refrigerator extends Product{

	private int L;
	public Refrigerator(int bunho, int price, int num, String name, int l) {
		super(bunho, price, num, name);
		L = l;
	}
	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}
	@Override
	public String toString() {
		String s = super.toString() + " L=" + L ;
		return s;
	}
}
