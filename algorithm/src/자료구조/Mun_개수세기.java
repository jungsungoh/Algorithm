package 자료구조;

import java.util.Scanner;

public class Mun_개수세기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int find = sc.nextInt();
		
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(arr[i] == find) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
