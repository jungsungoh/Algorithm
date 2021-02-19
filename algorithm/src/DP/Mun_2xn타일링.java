package DP;
import java.util.Scanner;

public class Mun_2xn타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// 1. 테이블 정의하기
		// d[i] = 2xi 직사각형을 채우는 방법 수
		int[] d = new int[1001];
		d[1] = 1;
		d[2] = 2;
		
		for(int i=3; i<=n; i++) {
			d[i] = (d[i-1]%10007 + d[i-2]%10007)%10007;
		}
		System.out.println(d[n]);
		// 2. 점화식 찾기
		// d[n] = d[n-1] + d[n-2]
		// 3. 초기값 설정
		// d[1] = 1, d[2] = 2
	}
}
