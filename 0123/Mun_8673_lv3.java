package first;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_8673_lv3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 1; tc<= TC; tc++) {
			int num = sc.nextInt();
			int su = (int)Math.pow(2, num);
			int[] arr1 = new int[su];
			for(int i=0; i<su; i++)
			{
				arr1[i] = sc.nextInt();
			}
			int result = 0;
			int length = arr1.length/2;
			while(length >0.5)
			{
				result +=make(arr1,length);
				length = length/2;
			}
			System.out.println("#" + tc + " " +result);
		}
	}
	public static int make(int[] arr, int length)
	{
		int[] arr1 = new int[length];
		int result = 0;
		int j=0;
		for(int i=0; i< length*2; )
		{
			int max = Math.max(arr[i], arr[i+1]);
			int min = Math.min(arr[i], arr[i+1]);
			result += (max-min);
			arr1[j++] = max;
			i+= 2;
		}
		for(int i=0; i<length*2; i++)
		{
			if(i>= length)
			{
				arr[i] = 0;
			}
			else {
				arr[i] = arr1[i];
			}
		}
		return result;
	}

}
