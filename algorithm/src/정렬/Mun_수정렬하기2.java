package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Mun_수정렬하기2 {
	public static int[] tmp = new int[1000000], arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] =  Integer.parseInt(br.readLine());
		}
		merge_sort(0,n);
		for(int i=0; i<arr.length; i++) {
			bw.append(""+arr[i]);
			bw.newLine();
		}
		bw.flush();
	}
	public static void merge(int start, int end) {
		int mid = (start+end) / 2;
		int lidx = start;
		int ridx = mid;
		for(int i=start; i <end; i++) {
			if(ridx == end) tmp[i] = arr[lidx++];
			else if(lidx == mid) tmp[i] = arr[ridx++];
			else if(arr[lidx] <= arr[ridx]) tmp[i] =arr[lidx++];
			else tmp[i] = arr[ridx++];
		}
		for(int i=start; i<end; i++) arr[i] = tmp[i];
	}
	public static void merge_sort(int start, int end) {
		if(end == start+1) return;
		int mid = (start+end) / 2;
		merge_sort(start, mid);
		merge_sort(mid, end);
		merge(start, end);
	}
}
