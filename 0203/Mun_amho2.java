package day0203;

import java.util.ArrayList;
import java.util.Scanner;

public class Mun_amho2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		for(int tc=1; tc<=10; tc++) {
			int basic_length = sc.nextInt();
			ArrayList<Integer> al = new ArrayList<Integer>();
			for(int i=0; i<basic_length; i++) {
				al.add(sc.nextInt());
			}
			int inst_length = sc.nextInt();
			int count = 0;
			while(count < inst_length) {
				char ch = sc.next().charAt(0);
				if(ch == 'I') {
					insert(al);
					count++;
				}
				else if(ch == 'D') {
					delete(al);
					count++;
				}
			}
			System.out.print("#" + tc + " ");
			for(int n= 0; n<10; n++)
			{
				System.out.print(al.get(n) + " ");
			}
			System.out.println();
		}
	}
	public static void insert(ArrayList<Integer> al) {
		int wich = sc.nextInt();
		int num = sc.nextInt();
		for(int i=0; i<num; i++)
		{
			al.add(wich+i, sc.nextInt());
		}
	}
	public static void delete(ArrayList<Integer> al) {
		int wich = sc.nextInt();
		int num = sc.nextInt();
		for(int i=0; i<num; i++)
		{
			al.remove(wich);
		}
	}
	
	
}
