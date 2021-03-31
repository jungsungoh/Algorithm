package 투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mun_배열합치기 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		
		int[] arr = new int[n];
		int[] arr2 = new int[m];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int j=0; j<m; j++) {
			arr2[j] =Integer.parseInt(st.nextToken());
		}
		int idxA =0, idxB = 0;
		int[] result = new int[n+m];
		
		int idx = 0;
		while(idxA<n && idxB < m) {
			if(arr[idxA] <= arr2[idxB]) {
				result[idx++] = arr[idxA++];
			}else if(arr[idxA] > arr2[idxB]) {
				result[idx++] = arr2[idxB++];
			}
		}
		while(idxA <n) {
			result[idx++] = arr[idxA++];
		}
		while(idxB <m) {
			result[idx++] = arr2[idxB++];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n+m; i++) {
			bw.append(result[i] +" ");
		}
		bw.flush();
	}
}
