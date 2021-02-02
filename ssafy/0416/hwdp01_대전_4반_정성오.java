package dp;

import java.util.Arrays;
import java.util.Scanner;

public class Mun_계단오르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		int[] val = new int[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = sc.nextInt();
		}
		if(n == 1) {
			System.out.println(arr[n]);
			return;
		}else if(n==2){
			System.out.println(arr[2]+arr[1]);
			return;
		}
		val[1] = arr[1];
		val[2] = arr[2] + arr[1];
		val[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		for(int i=4; i<=n; i++) {
			val[i] = Math.max(val[i-2]+arr[i], val[i-3]+arr[i-1]+arr[i]);
		}
		
		System.out.println(val[n]);
	}
}
