package 재귀;

import java.util.Scanner;

public class Mun_곱셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.println(pow(a,b,c));
	}
	public static long pow(long a, long b, long c) {
		
		if(b == 1) return a % c;
		
		long val = pow(a, b/2, c);
		val = val * val % c;
		if(b%2 == 0) return val;
		else return val * a % c;
	}
}
