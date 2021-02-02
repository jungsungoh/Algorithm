package day0129;

import java.util.Scanner;

public class Mun_sil1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC =sc.nextInt();
		for(int tc =1; tc<= TC; tc++) {
			int num = sc.nextInt();
			int[][] arr1 = new int[num][num]; // A는 -1, B는 -2, C는 -3
			int[] di = {0, 0 , 1, -1}; // 2 = 아래, 3은 위 
			int[] dj = {1,-1, 0, 0}; // 0 = 오른쪽, 1은 왼쪽
			for(int i=0; i< num; i++)
			{
				String s = sc.next();
				for(int j=0; j< num; j++)
				{
					int ch = s.charAt(j);
					if(ch =='S')	{arr1[i][j] = 1;}
					else if(ch== 'W'){arr1[i][j] = 0;}
					else if(ch == 'A') {arr1[i][j] = -1;}
					else if(ch == 'B') {arr1[i][j] = -2;}
					else if(ch == 'C') {arr1[i][j] = -3;}
				}
			}
			int result = A_move(arr1,dj) + B_move(arr1, dj) + C_move(arr1,di,dj); 
			System.out.println("#" + tc + " " + result);
		}
	}
	public static int A_move(int arr1[][], int[] dj)
	{
		int nj = 0;
		int count = 0;
		int index[];
		for(int i=0; i<arr1.length; i++)
		{
			index =find(arr1[i], -1); 
			for(int p =0; p<index.length; p++) {
				nj = index[p];
						if(nj != -1) {
							do {
								if(((nj+dj[0]) < arr1.length) &&arr1[i][nj+dj[0]] == 1) {
									nj += dj[0];
									count++;
								}

							}while(((nj+dj[0])< arr1.length) && (arr1[i][nj+dj[0]] == 1));
						}
			}
		}
		return count;
	}
	public static int B_move(int arr1[][], int[] dj)
	{
		int nj = 0;
		int count = 0;
		int index[];
		for(int i=0; i<arr1.length; i++)
		{
			for(int k =0; k<=1; k++)
			{
				index =find(arr1[i], -2); 
				for(int p =0; p<index.length; p++) {
					nj = index[p];
					if(nj != -1) {
						do {
							if(((nj+dj[k]) >=0) && ((nj+dj[k])< arr1.length) && (arr1[i][nj+dj[k]] == 1)) {
								nj += dj[k];
								count++;
							}
						}while(((nj+dj[k]) >=0) && ((nj+dj[k])< arr1.length)&& (arr1[i][nj+dj[k]] == 1));
					}
				}
			}
		}
		return count;
	}
	public static int C_move(int arr1[][], int[] di, int[] dj) // 상하좌우
	{
		int count =0;
		int nj =0;
		int ni = 0;
		int index[];
		for(int i=0; i<arr1.length; i++)
		{
			for(int k =0; k<=3; k++)
			{
				index =find(arr1[i], -3); 
				for(int p =0; p<index.length; p++) {
					nj = index[p];
					ni = i;
					if(nj != -1) {
						do {
							if(((ni+di[k]) >=0) && ((ni+di[k])< arr1.length) && ((nj+dj[k]) >=0) && ((nj+dj[k])< arr1.length)&& (arr1[ni+di[k]][nj+dj[k]] == 1)) {
								nj += dj[k];
								ni += di[k];
								count++;
							}

						}while(((ni+di[k]) >=0) && ((ni+di[k])< arr1.length) && ((nj+dj[k]) >=0) && ((nj+dj[k])< arr1.length)&& (arr1[ni+di[k]][nj+dj[k]] == 1));
					}
				}
			}
		}
		return count;
	}
	public static int[] find(int arr1[], int who)
	{
		int index[];
		int count = 0;
		for(int i=0; i<arr1.length; i++)
		{
			if(arr1[i] == who)
			{
				count++;
			}
		}
		index = new int[count];
		for(int k=0; k<count ; k++)
		{
			index[k] = -1;
		}
		count = 0;
		for(int i=0; i<arr1.length; i++)
		{
			if(arr1[i] == who)
			{
				index[count++] = i;
			}
		}
		return index;
	}

}
