package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_스티커붙이기 {
	public static int[][] main;
	public static int n,m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		int k = Integer.parseInt(l1.split(" ")[2]);
		ArrayList<int[][]> al = new ArrayList<>();
		main = new int[n][m];
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[][] arr = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
			for(int t=0; t<arr.length; t++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0; j<arr[0].length; j++) {
					arr[t][j] = Integer.parseInt(st2.nextToken());
				}
			}
			al.add(arr);
		}
		for(int t=0; t<k; t++) {
			int flag2 = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					int[][] tmp1 = al.get(t);
					for(int p = 0; p<3; p++) {
						int[][] tmp = stic(i,j,tmp1);
						if(tmp == null) {
							tmp1 = rotate(tmp1,90);
							print(tmp1);
							System.out.println("?????????????????");
						}else {
							System.out.println("k = " +t );
							main = tmp;
							print(main);
							System.out.println("===========");
							flag2 = 1;
							break;
						}
					}
					if(flag2 == 1) {break;}
				}
				if(flag2 == 1) {break;}
			}
		}
		
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(main[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	// 배열 회전 90, 180, 270, 360
	public static int[][] rotate(int[][] arr, int degree) {
		int[][] rotate = null;
		int n = arr.length;
		int m = arr[0].length;

		switch(degree) {
		case 90:
		case 270:
			rotate = new int[m][n];
			break;
		case 180:
			rotate = new int[n][m];
			break;
		}
		for(int i=0; i<rotate.length; i++) {
			for(int j=0; j<rotate[i].length; j++) {
				switch(degree) {
				case 90:
						rotate[i][j] = arr[n-1-j][i];
						break;
				case 180:
						rotate[i][j] = arr[n-1-i][m-1-j];
						break;
				case 270:
						rotate[i][j] = arr[j][m-1-i];
						break;
				}
			}
		}
		return rotate;
	}
	// 겹치는 부분이 1이면 x
	// 
	public static int[][] stic(int si, int sj, int[][] arr) {
		int[][] val = new int[main.length][];
		for(int i=0; i<main.length; i++) {
			val[i] = Arrays.copyOf(main[i], main[i].length);
		}
		for(int i=si; i<si+arr.length; i++) {
			for(int j= sj; j<sj+arr[0].length; j++) {
				if(i>=0 && i<n && j>=0 && j<m) {
					if(arr[i-si][j-sj] == 1 && val[i][j] == 1) {
						return null;
					}else if(arr[i-si][j-sj] == 1 && val[i][j] == 0){
						val[i][j] = arr[i-si][j-sj];
					}
				}else {
					return null;
				}
			}
		}
		return val;
	}
	public static void print(int[][] arr) {
	        for (int i=0; i<arr.length; i++) {
	            for (int j=0; j<arr[i].length; j++) {
	                System.out.print(arr[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }
}


// 스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
// 다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다. 혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다. 가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
//선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
//위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.