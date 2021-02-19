package 재귀;

import java.util.Scanner;

public class Mun_하노이탑이동순서 {
	public static StringBuffer sb;
	public static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb = new StringBuffer();
		hanoi(n, 1, 2, 3);
		System.out.println(count);
		System.out.println(sb.toString());
	}
	
	public static void hanoi(int cnt, int from, int temp, int to) {
		
		if(cnt ==0) return;
		count++;
		hanoi(cnt-1, from, to, temp);
		sb.append(from + " " + to + "\n");
		hanoi(cnt-1, temp, from, to);
	}
}
