package day0129;

import java.util.Scanner;

public class Mun_sil3 {
	static int[] di = {0,-1, 0, 1, 0}; //2 아래, 3위
	static int[] dj = {0, 0, 1, 0, -1}; // 0 오른, 1 왼
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc =1; tc <= TC; tc++) {
			int num = sc.nextInt();
			int[][] arr1 = new int[num+1][num+1];
			int[] cur = new int[2];
			int si = sc.nextInt();
			int sj = sc.nextInt();
			int jumper_su = sc.nextInt();
			for(int k = 0; k<jumper_su; k++) {
				int ji = sc.nextInt();
				int jj = sc.nextInt();
				for(int i=0; i<num+1; i++)
				{
					for(int j=0; j<num+1; j++)
					{
						arr1[ji][jj] = -1;
					}
				}
			}
			int edong_su = sc.nextInt();
			for(int i=0; i<edong_su; i++)
			{
				int dir = sc.nextInt();
				int go = sc.nextInt();
				cur = edong(arr1,si,sj,dir, go, cur);
				if(cur[0] == 0 && cur[1] ==0)
				{
					si = 0;
					sj = 0;
					break;
				}
				else {
					si = cur[0];
					sj = cur[1];
				}

			}
			System.out.println("#" + tc + " " +si + " " + sj);
		}
		

	}
	public static int[] edong(int[][] arr1, int si, int sj, int dir, int go, int[] cur)
	{
		int count = 0;
		int ni = si;
		int nj = sj;
		while(count != go) {
			ni = ni + di[dir];
			nj = nj + dj[dir];
			if((ni >= arr1[0].length) || (ni < 0) || (nj >= arr1[0].length) || (nj<0))
			{
				cur[0] = 0;
				cur[1] = 0;
				return cur;
			}
			if(arr1[ni][nj] == -1)
			{
				cur[0] = 0;
				cur[1] = 0;
				return cur;
			}
			count++;
		}
			cur[0] = ni;
			cur[1] = nj;
			return cur;
	}
}
