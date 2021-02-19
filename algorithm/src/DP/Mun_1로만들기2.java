package DP;

import java.util.Scanner;

public class Mun_1로만들기2 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[1000001];
		int[] pre = new int[1000001];
		d[1] = 0;
		
		for(int i=2; i<=n; i++) {
			d[i] = d[i-1] +1;
			pre[i] = i-1;
			
			if(i%2 ==0 && d[i] > d[i/2] +1) {
				d[i] = d[i/2] +1;
				pre[i] = i/2;
			}
			
			if(i%3 == 0 && d[i] > d[i/3] +1) {
				d[i] = d[i/3] +1;
				pre[i] = i/3;
			}
		}
		
		System.out.println(d[n]);
		
		int cur = n;
		while(true) {
			System.out.print(cur +" ");
			if(cur == 1) break;
			cur = pre[cur];
		}
	}
}
