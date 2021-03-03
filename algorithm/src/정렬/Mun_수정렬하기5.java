package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Mun_수정렬하기5 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];
		
		for(int i=0; i<n; i++) {
			arr[Integer.parseInt(br.readLine())+1000000]++;
		}
		for(int i=0; i<arr.length; i++) {
			while(arr[i] >0) {
				bw.append(""+(i-1000000));
				bw.newLine();
				arr[i]--;
			}
		}
		bw.flush();
	}
}
