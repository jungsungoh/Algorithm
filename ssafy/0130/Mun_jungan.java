package day0130;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_jungan {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int TC= sc.nextInt();
		for(int tc =1 ; tc<=TC; tc++)
		{
			int[] arr1 = new int[10];
			for(int i=0; i<10; i++)
			{
				arr1[i] = sc.nextInt();
			}
			Arrays.sort(arr1);
			int sum = 0;
			for(int i=1; i<9; i++)
			{
				sum += arr1[i];
			}
			double avg = (double)sum/8;
			System.out.println("#" + tc + " " + Math.round(avg));
		}
	}

}
