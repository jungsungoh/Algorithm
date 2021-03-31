package Dp초심;

import java.util.Scanner;

public class Mun_2xn타일링 {
	public static void main(String[] args) {
		// 테이블 설정하기
		// D[i] =  2×i 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지
		
		// D[i] = D[i-1] + D[i-2];
		
		// D[1] = 1, D[2] = 2;
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] D = new int[1001];
		D[1] = 1; D[2] = 2;
		for(int i=3; i<=n; i++) {
			D[i] = D[i-1]%10007 + D[i-2]%10007;
		}
		System.out.println(D[n]%10007);
	}
}
