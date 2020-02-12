
import java.util.Arrays;
import java.util.Scanner;

public class Mun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(i == 0)
			{
				sum += arr[i];
			}
			else {
				arr[i] = arr[i]+arr[i-1];
				sum += arr[i];				
			}
		}
		System.out.println(sum);
	}
}

