package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_비숍 {
	public static int cnt = 0, n, max = 0;
	public static int[][] arr, color;
	public static boolean[] leftD, rightD;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		color = new int[n][n];
		leftD = new boolean[2*n + 1];
		rightD = new boolean[2*n + 1];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i % 2 == 0) {
	                if (j % 2 == 0) {
	                    color[i][j] = 1;
	                }
	            } else {
	                if (j % 2 != 0) {
	                    color[i][j] = 1;
	                }
	            }
			}
		}
		int result = 0;
		vishop(0, 0, 0);
		result += max;
		max = 0;
		vishop(0, 0, 1);
		result += max;
		System.out.println(result);

	}

	public static void vishop(int idx, int cnt, int colNum) {
		max = Math.max(cnt, max);
		for(int i=idx; i<n*n; i++) {
			int si = i/n;
			int sj = i%n;
			if(arr[si][sj] == 1 && !leftD[si+sj] && !rightD[si-sj + n-1] && color[si][sj] == colNum) {
				leftD[si+sj] = true;
				rightD[si-sj+ n-1] = true;
				vishop(i+1,cnt+1, colNum);
				leftD[si+sj] = false;
				rightD[si-sj +n-1] = false;
			}
		}
	}
}
