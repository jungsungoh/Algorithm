package 재귀;

import java.util.Scanner;

public class Mun_Z {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(calc(n, r, c));
		
	}
	public static int calc(int n, int r, int c) {
		if(n ==0) return 0;
		int half = 1<<(n-1);
		
		if(r < half && c< half) return calc(n-1, r, c);
		if(r < half && c>= half) return half*half + calc(n-1, r, c-half);
		if(r >= half && c< half) return 2*half*half + calc(n-1, r-half, c);
		else return 3*half*half + calc(n-1, r-half, c-half);
	}
}
