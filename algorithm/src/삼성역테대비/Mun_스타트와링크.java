package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_스타트와링크 {
	public static int n, sol;
	public static int[] ar;
	public static int[][] arr;
	public static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][n];
		result = new int[n/2];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ar = new int[n];
		for(int i=0; i<n; i++) {
			ar[i] = i;
		}
		sol = Integer.MAX_VALUE;
		combi(0,0);
		
		System.out.println(sol);
	}
	public static void combi(int idx, int target) {
		if(result.length == idx) {
			boolean[] check = new boolean[n];
			for(int i=0; i<result.length; i++) {
				check[result[i]] = true;
			}
			int sum1 = 0, sum2 = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i!=j && check[i] && check[j]) {
						sum1 += arr[i][j];
					}
				}
			}
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(i!=j && !check[i] && !check[j]) {
						sum2 += arr[i][j];
					}
				}
			}
			sol =Math.min(sol, Math.abs(sum1-sum2));
			return;
		}
		
		if(ar.length == target) {
			return;
		}
		
		result[idx] = ar[target];
		combi(idx+1, target+1);
		combi(idx, target+1);
	}
}
// N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
// 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. \
// 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 

// 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를 수도 있으며, 
//i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.


// =>스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다


// 1. 팀나누기 반반 => 조합
// 2. 조합 결과에서 최소값 구하기.
