package first;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_8658_lv3 {
	public static void main(String[] args)
	{
		Scanner sc =new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc =1; tc<=TC ;tc++)
		{

			int[] arr1 = new int[10];
			int num;
			for(int i=0; i< 10; i++)
			{
				num = sc.nextInt();
				String s = Integer.toString(num);
				int sum =0;
				for(int j =0; j<s.length(); j++)
				{
					sum += s.charAt(j)-48;
				}
				arr1[i] = sum;
			}
			Arrays.sort(arr1);
			System.out.println("#" + tc+ " "  + arr1[arr1.length-1] + " " + arr1[0]);
		}
	}
}
