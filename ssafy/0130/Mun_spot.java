package day0130;

import java.util.Scanner;

public class Mun_spot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc= 1; tc<= TC; tc++) {
			int n = sc.nextInt(); // 과자봉지수
			int m = sc.nextInt(); // 최대무게
			int[] arr1 = new int[n];
			for(int i=0; i<n; i++)
			{
				arr1[i] = sc.nextInt();
			}
			int max =0;
			int sum = 0;
			for(int i=0; i<n; i++)
			{
				for(int j= i+1; j<n; j++)
				{
					sum = arr1[i] + arr1[j];
					if((max <sum) && sum <= m)
					{
						max = sum;
					}
				}
			}
			if(max == 0)
			{
				max = -1;
			}
			System.out.println("#" + tc + " " + max);

		}
	}

}
