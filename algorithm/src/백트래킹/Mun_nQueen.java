package 백트래킹;

import java.util.Scanner;

public class Mun_nQueen {
	public static int cnt = 0, n;
	public static int[] board;
	public static boolean[] col, leftD, rightD;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		board  = new int[n];
		col = new boolean[n];
		leftD = new boolean[40];
		rightD = new boolean[40];
		Queen(0);
		System.out.println(cnt);
	}
	public static void Queen(int idx) {
		
		if(idx == n) {
			cnt ++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!col[i] && !leftD[idx+i] && !rightD[idx-i + n-1]) {
				board[idx] = i;
				col[i] = true;
				leftD[idx+i] = true;
				rightD[idx-i + n-1] = true;
				Queen(idx+1);
				col[i] = false;
				leftD[idx+i] = false;
				rightD[idx-i + n-1] = false;
			}
			
		}
	}
}
