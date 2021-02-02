package day0204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mun_card {

	static int r1 = 0;
	static int r2 = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC =sc.nextInt();
		for(int tc = 1; tc<=TC; tc++) {
			r1 = 0; r2 = 0;
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.clear();
			boolean[] used = new boolean[9];
			int[] result = new int[9];
			int[] arr1 = new int[9];
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<9; i++)
			{
				arr1[i] = sc.nextInt();
			}
			
			for(int i=1; i<19; i++)
			{
				int flag = 1;
				for(int j = 0; j<9; j++)
				{
					if(i == arr1[j])
					{
						flag = 0;
						continue;
					}
				}
				if(flag == 1)
				{
					al.add(i);
				}	
			}
			
			per(0, al, result, used, arr1);
			System.out.print("#" + tc+ " " + r1);
			System.out.println(" " + r2);
		}
	}
	public static void per(int idx, ArrayList<Integer> al, int[] result, boolean[] used, int[] arr1) {
		
		if(idx == al.size()) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<9; i++)
			{
				if(arr1[i] > result[i])
				{
					sum1 += arr1[i] + result[i];
				}
				else if(arr1[i] < result[i])
				{
					sum2 += arr1[i] + result[i];
				}
			}
			if(sum1 > sum2)
			{
				r1++;
			}
			else if(sum1 < sum2)
			{
				r2++;
			}
			return;
		}
		for(int i=0; i<al.size(); i++) {
			if(!used[i]) {
				result[idx] = al.get(i);
				used[i] = true;
				per(idx+1,al,result,used, arr1);
				used[i] = false;
			}
		}
	}

}
