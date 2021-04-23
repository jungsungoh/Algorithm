package 삼성역테대비;

import java.util.Scanner;

public class Mun_사다리게임 {
	public static int n, m, h, result = Integer.MAX_VALUE;
	public static int endpoint;
	public static int[][] arr;
	public static boolean[][] used;
	public static boolean isOk = false;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m =sc.nextInt();
		h = sc.nextInt();
		endpoint = (h+1)*n;

		arr = new int[h+1][n];

		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] =1;
		}
		dfs(0, n);
		if(result == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(result);
		}
	}
	public static boolean run() {
		for(int j=1; j<arr[0].length; j++) {
			int i = 1;
			int temp = j;
			while(i <arr.length) {
				if(temp <=n-1 && arr[i][temp] == 1) {
					temp++;
				}else if(temp>=2 && arr[i][temp-1] ==1) {
					temp--;
				}
				i++;
			}
			if(j != temp) {
				return false;
			}
		}
		return true;
	}


	public static void dfs(int cnt, int idx) {
		if(cnt >= 4) {
			return;
		}
		if(idx == endpoint) {
			if(run()) {
				result = Math.min(cnt,  result);
			}
			return;
		}


		int si = idx/(n);
		int sj = idx%(n);
		if(si >=1 && si <= h && sj >=1 && sj<n) {
			if(arr[si][sj] != 1 ) {
				if(!(sj >=2 && arr[si][sj-1] == 1) && !((sj < n-1 && arr[si][sj+1] ==1))){
					arr[si][sj] = 1;
					dfs(cnt+1, idx+1);
					arr[si][sj] = 0;
				}
			}
		}
		dfs(cnt, idx+1);
	}
}
