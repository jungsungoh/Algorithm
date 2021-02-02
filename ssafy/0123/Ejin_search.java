package first;

import java.util.Scanner;

public class Ejin_search {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int[] arr1 = {2,4,7,9,11,19,23};
		int num = sc.nextInt();
		System.out.println(Ejin(arr1, num));

	}
	public static boolean Ejin(int[] arr1, int num)
	{
		int start = 0, end = arr1.length -1;
		while(start <=end) {
			int middle = (start+end)/2;
			if(arr1[middle] == num) {
				return true;
			}
			else if(arr1[middle] >num) {
				end = middle -1;
			}
			else 
				start = middle +1;
		}
		return false;
	}
}
