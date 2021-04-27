package Dp초심;

import java.util.Scanner;

public class Mun_암호코드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String l1 = String.valueOf(n);
		
		
		int[] d = new int[l1.length()+1];
		
		
		for(int i=1; i<=l1.length(); i++) {
			
			int val = l1.charAt(i)-'0';
			if(val != 0) {
				d[i] = (d[i-1]+d[i])%1000000;
			}
			
			
		}
		
		
	}
}
