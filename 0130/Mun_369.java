package day0130;

import java.util.Scanner;

public class Mun_369 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String s = "";
		int flag = 0;
		for(int i=1; i<=num; i++)
		{
			String p = Integer.toString(i);
			for(int j =0; j<p.length(); j++)
			{
				char ch = p.charAt(j);
				if(ch == '3' || ch == '6' || ch == '9') {
					s += '-';
					flag = 1;
				}
				else {
				}
			}
			if(flag == 1)
			{
				s += " ";
				flag = 0;
			}
			else {
				s += Integer.toString(i)+ " "; 
			}
		}
		System.out.println(s.substring(0,s.length()));
	}
}
