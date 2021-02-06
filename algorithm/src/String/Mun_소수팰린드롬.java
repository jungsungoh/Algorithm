package String;

import java.util.Scanner;

public class Mun_소수팰린드롬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		if(num <=1) num =2;
		
		boolean[] arr = new boolean[2000000];
		for(int i=2; i< arr.length; i++) {
			arr[i] = true;
		}
		
		for(int i=2; i*i<arr.length; i++) {
			for(int j=i*i; j<arr.length; j+=i) {
				arr[j] = false;
			}
		}
		int result = -1;
		for(int i=num; i<arr.length; i++) {
			if(arr[i]) {
				int flag = 0;
				String s = String.valueOf(i);
				for(int j=0; j<s.length()/2; j++) {
					if(s.charAt(j) != s.charAt(s.length()-1-j)) { 
						flag = 1;
						break;
					}
				}
				if(flag ==0) {
					result = i;
					break;
				}
			}
		}
		System.out.println(result);
	}
}
