package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_트리의높이와너비 {
	public static int[] lc, rc, parents;
	public static int[] leftmax, rightmax;
	public static int cnt = 1, maxlevel = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		lc = new int[n+1];
		rc = new int[n+1];
		parents = new int[n+1];
		leftmax = new int[n+1];
		rightmax = new int[n+1];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			lc[node] = (v1==-1)?0:v1;
			rc[node] = (v2==-1)?0:v2;
			if(v1 != -1) {
				parents[v1] = node;
			}
			if(v2 != -1) {
				parents[v2] = node;
			}
		}
		for(int i=0; i<=n; i++) {
			leftmax[i] = n;
			rightmax[i] = 0;
		}
		int root = -1;
		for(int i=1; i<=n ;i++) {
			if(parents[i] == 0) {
				root = i;
				break;
			}
		}
		dfs(root,1);
		int result = 0, idx = -1;
		for(int i=1; i<=maxlevel ;i++) {
			int val = (rightmax[i] - leftmax[i])+1;
			if(result < val) {
				idx = i;
				result = val;
			}
		}
		System.out.println(idx + " " + result);
	}
	public static void dfs(int idx,int level) {
		if(maxlevel < level) {
			maxlevel = level;
		}
		if(lc[idx] != 0) {
			dfs(lc[idx], level+1);
		}
		leftmax[level] = Math.min(leftmax[level], cnt);
		rightmax[level] = cnt;
		cnt++;
		if(rc[idx] != 0) {
			dfs(rc[idx], level+1);
		}
	}
}
