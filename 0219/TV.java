package hw;

public class TV extends Product{
	private int inch;

	public TV(int bunho, int price, int num, String name, int inch) {
		super(bunho, price, num, name);
		this.inch = inch;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	@Override
	public String toString() {
		String s = super.toString() + " inch=" + inch;
		return s;
	}
}
