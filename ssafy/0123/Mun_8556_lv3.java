package first;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_8556_lv3 {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			String input = sc.next();
			int gak = 0;
			int length = input.length()-5;
			int[] arr1 = new int[20];
			int index = 1;
			arr1[0] = 1;
			if(input.substring(input.length()-4,input.length()).equals("west"))
			{
				gak = 90;
				length = input.length()-4;
				arr1[0] = 2;
			}
			int minus = 0;
			while(length > 0)
			{
				minus =find(arr1,input,length, index);
				length-=minus;
				index++;
			}
			int cnt_n = 1, cnt_w = 1;
			int[] mo = new int[index], ja = new int[index];
			if(arr1[0] == 2) {
				mo[0] = 1;
				ja[0] = 90;
			}
			else if(arr1[0] ==1)
			{
			}
			for(int i=1; i<index; i++)
			{
				if(arr1[i] == 1) {
					mo[i] = (int)Math.pow(2, cnt_n);
					ja[i] = -90;
					cnt_n++;
				}
				else if(arr1[i] == 2)
				{
					ja[i] = 90;
					mo[i] = (int)Math.pow(2, cnt_n);
					cnt_n++;
				}
			}
			int max = 0;
			for(int k : mo)
			{
				if(k > max)
				{
					max = k;
				}
			}
//			System.out.println(max);
//			System.out.println(Arrays.toString(ja));
//			System.out.println(Arrays.toString(mo));
			for(int i=0; i<index; i++)
			{
				if(mo[i] == 0){}
				else if(mo[i] != max) {
					int cnt = 0;
					while(mo[i] !=max)
					{
						cnt++;
						mo[i] *= 2;
					}
					ja[i] = ja[i]*(int)Math.pow(2, cnt);
				}
			}
//			System.out.println(Arrays.toString(ja));
//			System.out.println(Arrays.toString(mo));
			int i_mo = max, i_ja = 0;
			for(int i=0; i<index; i++)
			{
				i_ja += ja[i];
			}
			while(i_mo%2 ==0 && i_ja%2 ==0 && i_mo >1)
			{
				i_mo = i_mo /2;
				i_ja = i_ja/2;
			}
			if(i_mo ==1 || i_mo ==0)
			{
				System.out.println("#" + tc + " " +i_ja);
			}
			else {
				System.out.print("#" + tc + " " +i_ja +"/");
				System.out.println(i_mo);
			}
		}
			
		
	}
	public static int find(int[] arr1,String s, int length, int index)
	{
		int minus = 0;
		if(s.substring(length-4,length).equals("west")) {
			arr1[index] = 2;
			minus = 4;
		}
		else if(s.substring(length-5,length).equals("north")) {
			arr1[index] = 1;
			minus = 5;
		}
		return minus;
	}

}
