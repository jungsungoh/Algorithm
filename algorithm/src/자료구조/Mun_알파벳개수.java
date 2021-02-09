package 자료구조;

import java.util.Scanner;

public class Mun_알파벳개수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int[] arr = new int[26];
		for(int i=0; i< s.length(); i++) {
			arr[(int)(s.charAt(i)-'a')]++;
		}
		
		for(int i =0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
