package 투포인터;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_게으른백곰 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n개의 얼음양동이
		int k = sc.nextInt(); // 좌우로 k만큼
		bucket[] b = new bucket[n];
		
		int max = 0;
		for(int i=0; i<n; i++) {
			int g = sc.nextInt();
			int x = sc.nextInt();
			b[i] = new bucket(g,x);
			max = Math.max(max, x);
		}
		Arrays.sort(b);
		long sum = b[0].g;
		int left = 0, right = 0;
		long answer = 0;
		while(right <n) {
			int range = b[right].x - b[left].x;
			
			if(range <= 2*k) {
				answer = Math.max(sum, answer);
				right++;
				if(right < n) {
					sum+= b[right].g;
				}
			}else {
				sum -= b[left].g;
				left++;
			}
		}
		System.out.println(answer);
	}
	
	
	
	public static class bucket implements Comparable<bucket>{ 
		int g, x;
		public bucket(int g, int x) {
			super();
			this.g = g;
			this.x = x;
		}
		@Override
		public int compareTo(bucket o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.x, o.x);
		}
	}
}
