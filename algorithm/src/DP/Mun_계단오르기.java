package DP;

public class Mun_계단오르기 {
	public static void main(String[] args) {
		
		// 1. 테이블 정의하기
		// D[i][j] = 현재까지 j개의 계단을 연속해서 밟고, i번째 계단에 도착했을때 점수의 최대값 구하기. 단, i번째 계단은 반드시 밟아야함.
		
		
		
		// 2. 점화식 구하기
		// D[k][1] = max(D[k-2][1], D[k-2][2]) + S[k];
		// D[k][2] = D[k-1][1] + S[k];
		// 3. 초기값 설정
	}
}
