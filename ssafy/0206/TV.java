package hw;

public class TV extends Product{
	
	private int inch;
	private String display;
	private int check;
	
	public TV(int num, String name, int price, int su, int inch, String display) {
		super(num, name, price, su);
		this.inch = inch;
		this.display = display;
		this.check = 0;
	}
	@Override
	public String toString() {
		String s = super.toString()+ "inch=" + inch +" display=" + display;
		return s;
	}

	

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
	
	
}
