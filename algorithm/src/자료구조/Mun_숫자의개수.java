package 자료구조;

import java.util.Scanner;

public class Mun_숫자의개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		String val = String.valueOf(a*b*c);
		
		int[] arr = new int[10];
		for(int i=0; i<val.length(); i++) {
			arr[(int)(val.charAt(i)-'0')]++;
		}
		for(int i=0; i<10; i++) {
			System.out.println(arr[i]);
		}
	}
}
