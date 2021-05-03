package 이분탐색;

import java.util.Scanner;

public class Mun_정수제곱근 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();


		long left = 0, right = n, min = Long.MAX_VALUE;

		while(left <= right) {

			long mid = (left + right) / 2;
			long value = (long) Math.pow(mid,  2);

			if(value >= n) {
				min = Math.min(min, mid);
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(min);
	}
}
