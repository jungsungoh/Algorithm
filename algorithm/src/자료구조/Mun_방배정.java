package 자료구조;

import java.util.Scanner;

public class Mun_방배정 {
	public static void main(String[] args) {
		
		int[][] arr = new int[2][6];
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			arr[sc.nextInt()][sc.nextInt()-1]++;
		}
		
		int cnt = 0;
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<6; j++) {
				cnt += (arr[i][j]/max );
				if(arr[i][j] %max != 0) {
					cnt +=1;
				}
			}
		}
		System.out.println(cnt);
	}
}
