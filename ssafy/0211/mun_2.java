import java.util.Scanner;

public class Mun {
	static int[] di = {0,0,1,-1};
	static int[] dj = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[][] arr =new int[101][101];
		int x =0;
		int y =0;
		for(int i=1; i<=n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			for(int k=x; k<x+10; k++) {
				for(int p=y; p<y+10; p++) {
					arr[k][p] = 1;
				}
			}
		}
		int cnt =0;
		for(int i=0; i < 100; i++) {
			for(int j=1; j<100; j++) {
				if(arr[i][j] == 1) {
					for(int k = 0;k<4; k++) {
						int ni = i +di[k];
						int nj = j +dj[k];
						if(ni>=0 && ni <101 && nj>=0 && nj<101) {
							if(arr[ni][nj] == 0)
							{
								cnt++;
							}
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}

