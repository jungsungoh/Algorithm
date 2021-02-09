package 자료구조;

import java.util.Scanner;

public class Mun_방번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int[] arr = new int[9];
		for(int i=0; i<s.length(); i++) {
			int num = (int)(s.charAt(i)-'0');
			if(num == 9) num = 6;
			arr[num]++;
		}
		arr[6] = (arr[6]/2 + arr[6]%2);
		int max =0;
		for(int i=0; i<9; i++) {
			if(max <= arr[i]) {
				max= arr[i];
			}
		}
		System.out.println(max);
	}
}
