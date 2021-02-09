package 자료구조;

import java.util.Scanner;

public class Mun_애너그램 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		int[] arr = new int[26];
		int[] arr2 = new int[26];
		
		for(int i=0; i<s1.length(); i++) {
			arr[(int)(s1.charAt(i)-'a')]++ ;
		}
		for(int i=0; i<s2.length(); i++) {
			arr2[(int)(s2.charAt(i)-'a')]++ ;
		}
		int cnt = 0;
		for(int i=0; i<26;i++) {
			cnt += Math.abs(arr[i] - arr2[i]);
		}
		System.out.println(cnt);
	}
}
