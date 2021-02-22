package 재귀;

import java.util.Scanner;

public class Mun_moo게임 {
	public static StringBuffer sb;
	public static String[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuffer();
		d = new String[n];
		d[0] = "moo";
		moo(n);
		System.out.println(sb.toString());
	}
	public static String moo(int n) {
		if(n == 0) {
			return d[0];
		}
		if(d[n] != null) {
			return d[n];
		}else {
			sb.append(moo(n-1));
			String s ="m";
			for(int i=0; i<n+2; i++) {
				s += "o";
			}
			sb.append(moo(n-1));
			return d[n];
		}
	}
}
