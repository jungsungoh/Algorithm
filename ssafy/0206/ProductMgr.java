package hw;

import ws.Book;
import ws.Magazine;

public class ProductMgr {
	static Product[] arr;
	static int count;
	public ProductMgr() {
		arr = new Product[10];
		count = 0;
	}
	private int num;
	private String name;
	private int price;
	private int su;
	private int check;
	public static void input(int num, String name, int price, int su, int inch, String display) {
		TV t1 = new TV(num, name, price, su, inch,  display);
		arr[count++] = t1;
	}
	public static void input(int num, String name, int price, int su,int size) {
		Refrigerator r1 = new Refrigerator(num,name,price,su,size);
		arr[count++] = r1;
	}
	public void search() {
		for(int i=0; i<count ;i++)
		{
			System.out.println(arr);
		}
	}
	public void search_name(String name) {
		for(int i=0; i<count ; i++)
		{
			if(arr[i].getName().equals(name)) {
				System.out.println(arr[i]);
			}
		}
	}
	public void search_bun(int bun) {
		for(int i=0; i<count ; i++)
		{
			if(arr[i].getNum() == bun) {
				System.out.println(arr[i]);
			}
		}
	}
	public void search_tv() {
		for(int i=0; i<count; i++)
		{
			if(arr[i].check() == 0)
			{
				System.out.println(arr[i]);
			}
		}
	}
	public void search_re() {
		for(int i=0; i<count; i++)
		{
			if(arr[i].check() == 1)
			{
				System.out.println(arr[i]);
			}
		}
	}
	public void delete(int num) {
		int flag = -1;
		for(int i=0; i<count; i++)
		{
			if(arr[i].getNum() == num)
			{
				flag = i;
			}
		}
		for(int i = flag; i<count; i++)
		{
			arr[i] = arr[i+1];
		}
	}
	public int sum() {
		int sum=0;
		for(int i=0; i<count; i++)
		{
			sum += arr[i].getSu() * arr[i].getPrice();
		}
		return sum;
	}
}
