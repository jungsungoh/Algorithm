package day0130;

import java.util.Scanner;

public class Mun_Bumuk {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc =1; tc<= TC; tc++) {
			int num = sc.nextInt();
			int limit = sc.nextInt();
			int[] arr = new int[num];
			for(int i=0; i<num; i++)
			{
				arr[i] = sc.nextInt();
			}
			int sum = 0;
			int count = 0;
			for(int i=0; i<num; i++)
			{
				if(arr[i] ==0)
				{
					count++;
				}
				else if(arr[i] ==1)
				{
					sum += count/limit;
					count =0;
				}
			}
			if(sum == 0)
			{
				sum = count/limit;
			}
			System.out.println("#"+tc +" " + sum);
		}
	}

}
