package Dp초심;

import java.util.Scanner;

public class Mun_1로만들기 {
	public static void main(String[] args) {
		
		
		// 테이블 만들기
		// D[i] = i를 1로 만드는 연산을 하는 횟수의 최솟값을 출력한다.
		
		// D[i] = min(D[i/3] +1, D[i/2] +1, D[i-1]+1);
		
		// 초기값 설정
		// D[0] =0, D[1] = 0;
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] d = new int[n+1];
		d[1] = 0;
		for(int i=2; i<=n; i++) {
			
			d[i] = d[i-1] +1;
			if(i%3 == 0) {
				d[i] = Math.min(d[i], d[i/3] +1);
			}
			if(i%2 == 0) {
				d[i] = Math.min(d[i],  d[i/2] +1);
			}
		}
		System.out.println(d[n]);
	}
}
