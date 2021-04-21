package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_경사로 {
	public static int n,L;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		L = Integer.parseInt(l1.split(" ")[1]);
		arr =new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(check(i, 0, 1)) {
				cnt++;
			}
			if(check(0, i, 2)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	public static boolean check(int si, int sj, int dir) {
		
		int[] temp = new int[n];
		boolean[] visited = new boolean[n];
		for(int i=0; i<n; i++) {
			temp[i] = (dir==1)? arr[si][sj+i]:arr[si+i][sj];
		}
		
		for(int i=0; i<n-1; i++) {
			if(temp[i] == temp[i+1]) continue;
			if(Math.abs(temp[i]-temp[i+1])>1) return false;
			
			if(temp[i]-1 == temp[i+1]) {
				for(int j= i+1; j<=i+L; j++) {
					if( 0<=j && j<n && temp[i+1] == temp[j] && !visited[j]) {
						visited[j] = true;
					}else {
						return false;
					}
				}
			}else if(temp[i]+1 == temp[i+1]) {
				for(int j=i; j>i-L; j--) {
					if(0<=j && j<n && temp[i] == temp[j] &&!visited[j]) {
						visited[j] = true;
					}else {
						return false;
					}
				}
			}
			
		}
		return true;
	}
}


// 크기가 N×N인 지도가 있다. 지도의 각 칸에는 그 곳의 높이가 적혀져 있다. 
// 오늘은 이 지도에서 지나갈 수 있는 길이 몇 개 있는지 알아보려고 한다. 
// 길이란 한 행 또는 한 열 전부를 나타내며, 한쪽 끝에서 다른쪽 끝까지 지나가는 것이다. 
// 길은 총 2N개가 있으며, 아래와 같다.


// 길을 지나갈 수 있으려면 길에 속한 모든 칸의 높이가 모두 같아야 한다. 
// 또는, 경사로를 놓아서 지나갈 수 있는 길을 만들 수 있다. 
// 경사로는 높이가 항상 1이며, 길이는 L이다. 또, 개수는 매우 많아 부족할 일이 없다. 


// 경사로는 낮은 칸과 높은 칸을 연결
// 경사로는 낮은 칸에 놓으며, L개의 연속된 칸에 경사로의 바닥이 모두 접해야 한다.
// 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다.
// 경사로를 놓을 낮은 칸의 높이는 모두 같아야 하고, L개의 칸이 연속되어 있어야 한다.


// 아래와 같은 경우에는 경사로를 놓을 수 없다.

// 경사로를 놓은 곳에 또 경사로를 놓는 경우
// 낮은 칸과 높은 칸의 높이 차이가 1이 아닌 경우
// 낮은 지점의 칸의 높이가 모두 같지 않거나, L개가 연속되지 않은 경우
// 경사로를 놓다가 범위를 벗어나는 경우