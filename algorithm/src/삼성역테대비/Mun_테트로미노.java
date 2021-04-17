package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Mun_테트로미노 {
	public static int[][] tet1, tet2, tet3, tet4, tet5;
	public static int n, m;
	public static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		arr = new int[n][m];

		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		makeTet();
		int result = dfs();
		System.out.println(result);
	}

	public static int dfs() {
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<4; k++) {
					int[][] temp = rotate(tet1,k);
					max = Math.max(max, doput(i, j, temp));
					for(int t =0; t<2; t++) {
						temp = miror(temp, t);
						max = Math.max(max, doput(i, j, temp));
					}
					temp = rotate(tet2,k);
					max = Math.max(max, doput(i, j, temp));
					for(int t =0; t<2; t++) {
						temp = miror(temp, t);
						max = Math.max(max, doput(i, j, temp));
					}
					temp = rotate(tet3,k);
					max = Math.max(max, doput(i, j, temp));
					for(int t =0; t<2; t++) {
						temp = miror(temp, t);
						max = Math.max(max, doput(i, j, temp));
					}
					temp = rotate(tet4,k);
					max = Math.max(max, doput(i, j, temp));
					for(int t =0; t<2; t++) {
						temp = miror(temp, t);
						max = Math.max(max, doput(i, j, temp));
					}
					temp = rotate(tet5,k);
					max = Math.max(max, doput(i, j, temp));
					for(int t =0; t<2; t++) {
						temp = miror(temp, t);
						max = Math.max(max, doput(i, j, temp));
					}
				}
			}
		}
		return max;
	}
	public static int doput(int si, int sj, int[][] tet) {
		int sum = 0;
		for(int i=0; i<tet.length; i++) {
			for(int j=0; j<tet[0].length; j++) {
				if(tet[i][j] == 1) {
					int ni = si+i, nj = sj+j;
					if(ni>=0 && ni<n && nj>=0 && nj<m) {
						sum +=arr[ni][nj]; 
					}
				}
			}
		}
		return sum;
	}
	static int[][] rotate(int[][] target, int degree) {
		int[][] rotate = null;
		int r = target.length;
		int c = target[0].length;
		if(degree == 0) {
			return target;
		}else {
			switch (degree) {
			case 1:
			case 3:
				rotate = new int[c][r];
				break;
			case 2:
				rotate = new int[r][c];
				break;
			}

			for (int i = 0; i < rotate.length; i++) {
				for (int j = 0; j < rotate[i].length; j++) {
					switch (degree) {
					case 1:
						rotate[i][j] = target[r-1-j][i];
						break;
					case 2:
						rotate[i][j] = target[r-1-i][c-1-j];
						break;
					case 3:
						rotate[i][j] = target[j][c-1-i];
						break;
					}
				}
			}
			return rotate;
		}
	}
	public static int[][] miror(int[][] target, int idx){
		int[][] rotate = new int[target.length][target[0].length];
		int r = target.length;
		int c = target[0].length;
		for (int i = 0; i < rotate.length; i++) {
			for (int j = 0; j < rotate[i].length; j++) {
				switch (idx) {
				case 0: // x축대칭
					rotate[i][j] = target[i][c-1-j];
					break;
				case 1: // y출대칭
					rotate[i][j] = target[r-1-i][j];
					break;
				}
			}
		}
		return rotate;
	}
	public static void makeTet() {
		// 테트로미노 만들기
		tet1 = new int[1][4];
		for(int i=0; i<tet1.length; i++) {
			for(int j=0; j<tet1[0].length; j++) {
				tet1[i][j] = 1;
			}
		}
		tet2 = new int[2][2];
		for(int i=0; i<tet2.length; i++) {
			for(int j=0; j<tet2[0].length; j++) {
				tet2[i][j] = 1;
			}
		}
		tet3 = new int[3][2];
		for(int i=0; i<tet3.length; i++) {
			for(int j=0; j<tet3[0].length; j++) {
				if((i==0 && j==1) || (i==1 && j==1)) continue;
				tet3[i][j] = 1;
			}
		}
		tet4 = new int[3][2];
		for(int i=0; i<tet4.length; i++) {
			for(int j=0; j<tet4[0].length; j++) {
				if((i==0 && j==1) || (i==2 && j==0)) continue;
				tet4[i][j] = 1;
			}
		}
		tet5 = new int[2][3];
		for(int i=0; i<tet5.length; i++) {
			for(int j=0; j<tet5[0].length; j++) {
				if((i==1 && j==0) || (i==1 && j==2)) continue;
				tet5[i][j] = 1;
			}
		}
	}
}

// 테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.
//  반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.