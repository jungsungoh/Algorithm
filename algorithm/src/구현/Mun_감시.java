package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Mun_감시 {
	public static ArrayList<Integer> al;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		int[][] arr= new int[n][m];
		al = new ArrayList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1 || arr[i][j] == 2 || arr[i][j] == 3 || arr[i][j] == 4 || arr[i][j] == 5) {
					al.add(arr[i][j]);
				}
			}
		}
		
	}
	public static void view(int idx) {
		if(al.size() == idx) {
			
		}
		
		for(int k=0; k<4; k++) {
			al.get(idx);
		}
	}
	
	public static void cctv(int idx, int k) {
		switch(idx) {
		case 1:
			if(k == 1) {
				
			}
		}
	}
}
