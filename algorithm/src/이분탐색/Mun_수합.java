package 이분탐색;

import java.util.Scanner;

public class Mun_수합 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		
		long sum = 0;
		
		
		int i = 1, count = 0;
		while(sum <= num) {
			sum+= i;
			i++;
			count++;
		}
		if(sum == num) {
			System.out.println(count);
		}else {
			System.out.println(count-1);
		}
	}
}
