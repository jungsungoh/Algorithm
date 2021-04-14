package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_좋은수열 {
	public static int n = 11, resultVal;
	public static int[][] arr;
	public static int[] result;
	public static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1 ;tc<=TC;tc++) {
			resultVal = 0;
			arr = new int[n][n];
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			result = new int[11];
			used = new boolean[11];
			backtrack(0,0);
			System.out.println(resultVal);
		}
	}
	public static void backtrack(int idx, int sum) {
		if(result.length == idx) {
			resultVal= Math.max(sum, resultVal);
		}

		for(int i=0; i<n; i++) {
			if(!used[i]) {
				result[idx] = arr[i][idx];
				if(result[idx]== 0) continue;
				used[i] = true;
				backtrack(idx+1,sum+result[idx]);
				used[i] = false;
			}
		}
	}
}
