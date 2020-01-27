package first;

import java.util.Arrays;

public class select_sort {

	public static void main(String[] args) {
		int[] arr1 = {64, 25, 10, 22, 11, 35, 80, 95};
		selection(arr1);
		System.out.println(Arrays.toString(arr1));
	}
	public static void selection(int[] arr1)
	{
		for(int i=0; i<arr1.length-1; i++) {
			int min = i;
			for(int j = i+1; j<arr1.length; j++) {
				if(arr1[min] >arr1[j])
					min = j;
			}
			int temp = arr1[i];
			arr1[i] = arr1[min];
			arr1[min] = temp;
			

		}
	}

}
