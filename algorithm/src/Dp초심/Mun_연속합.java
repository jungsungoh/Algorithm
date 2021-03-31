package Dp초심;

import java.util.Scanner;

public class Mun_연속합 {
	public static void main(String[] args) {
		// 테이블 정의하기
		// D[i] = i번째 수를 선택해서 구할 수 있는 합 중 
		// 점화식
		// D[i] = max(d[i-1]+arr[i], arr[i])
		// 초기값 설정
		// D[0] = arr[0];
		// int max = arr[0];
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] d = new int[n+1];
		d[1] = arr[1];
		int max = arr[1];
		for(int i=2; i<=n; i++) {
			d[i] = Math.max(d[i-1]+arr[i], arr[i]);
			max = Math.max(max, d[i]);
		}
		System.out.println(max);
	}
}
