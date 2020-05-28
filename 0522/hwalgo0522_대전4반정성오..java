package online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mun_준환이의양팔저울 {
	static int[] arr, result, left, right;
	static boolean[] visited;
	static int n, cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			String l1 = br.readLine();
			for(int i=0; i<n; i++) {
				arr[i] = Integer.parseInt(l1.split(" ")[i]);
			}
			result = new int[n];
			visited=  new boolean[n];
			cnt= 0;
			permu(0, 0 ,0 );
			System.out.println("#" + tc + " " + cnt);
		}
	}
	static void permu(int idx, int left, int right) {
		if(left < right) return;
		if(result.length == idx) {
			//System.out.println(Arrays.toString(result));
			cnt++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				if(right+result[idx]  <= left) {
					permu(idx+1, left, right + result[idx]);
				}
				permu(idx+1, left+result[idx], right);
				visited[i] = false;
			}
		}
	}
}
