package 자료구조;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_두수의합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max= 0;
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		int num = sc.nextInt();
		
		int[] check = new int[max+1];
		int cnt = 0;
		for(int i=0; i<n; i++) {
			if(num-arr[i] <= max && num-arr[i] >=0 && check[num-arr[i]] == 1) {
				cnt++;
			}
			check[arr[i]] = 1;
		}
		
		System.out.println(cnt);
	}
}
 