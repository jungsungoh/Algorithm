package Dp초심;

import java.util.Scanner;

public class Mun_가장긴증가하는부분수열 {
	public static void main(String[] args) {
		
		// 테이블 정의하기
		// D[i] = i번째 항을 마지막으로 사용하는 수열 중 최대 길이
		
		// 점화식
		
		// 초기값
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] d = new int[n];
		d[0] = 1;
		int max = d[0];
		for(int i=1; i<n; i++){
			d[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					d[i] = Math.max(d[i], d[j]+1);
					max= Math.max(max, d[i]);
				}
			}
		}
		System.out.println(max);
	}
}
