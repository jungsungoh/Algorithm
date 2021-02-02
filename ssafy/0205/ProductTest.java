package hw;

public class ProductTest {

	public static void main(String[] args) {
		TV tv1 = new TV(15665, "HDTV", 2300000, 30, 70, "HD");
		TV tv2 = new TV(30215, "UHDTV", 3500000, 10, 100, "UHD");
		
		Refrigerator r1 = new Refrigerator(1245, "Mini", 10000000, 10, 120);
		Refrigerator r2 = new Refrigerator(1874, "Large", 15000000, 8, 200);	
		
		System.out.println("=============== TV==========");
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println("=============== 냉장고==========");
		System.out.println(r1);
		System.out.println(r2);
	}

}
