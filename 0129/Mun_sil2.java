package day0129;

import java.util.Scanner;

public class Mun_sil2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1; tc<=TC; tc++)
		{
			int size = sc.nextInt();
			int num = sc.nextInt();
			int[][] arr1 = new int[size][size];
			int flag = 0, pic = 1;

			for(int i=1; i<= num; i++)
			{
				int i_start = sc.nextInt();
				int j_start = sc.nextInt();
				int dir = sc.nextInt();
				if(pic == 1) {
					flag = marking(arr1, i, i_start, j_start, dir);
				}
				if(flag != 0)
				{
					pic = 0;
					continue;
				}
			}
			System.out.println("#" + tc + " " + flag);
		}
	}
	public static int marking(int[][] arr1,int index, int i_start, int j_start, int dir)
	{
		int ni =i_start;
		int nj = j_start;
		int flag =0;
		arr1[ni][nj] = index;
		if(dir == 2) {
			if(nj +3 <arr1.length) {
				nj+= 3;
				if(arr1[ni][nj] !=0)
				{
					flag = index;
					return flag;
				}
				arr1[ni][nj] =index;
				if(nj+2 <arr1.length) {
					nj+=2;
					if(arr1[ni][nj] !=0)
					{
						flag = index;
						return flag;
					}
					arr1[ni][nj] = index;
					if(nj+1 < arr1.length) {
						nj+= 1;
						if(arr1[ni][nj] !=0)
						{
							flag = index;
							return flag;
						}
						arr1[ni][nj] = index;
					}
				}
			}
		}
		else if(dir == 1) {
			if(ni +3 <arr1.length) {
				ni+= 3;
				if(arr1[ni][nj] !=0)
				{
					flag = index;
					return flag;
				}
				arr1[ni][nj] =index;
				if(ni+2 <arr1.length) {
					ni+=2;
					if(arr1[ni][nj] !=0)
					{
						flag = index;
						return flag;
					}
					arr1[ni][nj] = index;
					if(ni+1 < arr1.length) {
						ni+= 1;
						if(arr1[ni][nj] !=0)
						{
							flag = index;
							return flag;
						}
						arr1[ni][nj] = index;
					}
				}
			}
		}
		return flag;
	}

}
