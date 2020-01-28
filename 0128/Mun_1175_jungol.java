package day0128;

import java.util.Scanner;

public class Mun_1175_jungol {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int[] number = {1,2,3,4,5,6};
		
		int su = sc.nextInt();
		int sum = sc.nextInt();
		int[] result = new int[su];
		mode_1(0, number, result, sum);
		 
	}
	static void mode_1(int idx, int[] arr, int[] result, int sum) 	// M = 1 : 주사위를 N번 던져서 나올 수 있는 모든 경우
	{
		int sum1 = 0;
		if(idx == result.length) {	
			for(int j =0; j<result.length; j++)
			{
				sum1 += result[j];
			}
			if(sum == sum1)
			{
				print(result);
			}

			return;
		}
		for(int i=0; i<arr.length; i++) {
			result[idx] = arr[i];
			mode_1(idx+1, arr, result, sum);
		}
	}
	static void print(int[] arr) {
		for(int i=0; i<arr.length-1; i++)
		{
			System.out.print(arr[i]+ " ");
		}
		System.out.println(arr[arr.length-1]);
	}

}
