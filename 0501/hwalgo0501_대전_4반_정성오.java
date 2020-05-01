package online;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Mun_정식이의은행업무 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			String n1 = br.readLine();
			String n2 = br.readLine();
			String val1 = n1;
			String val2 = n2;
			int[] arr = new int[n1.length()];
			ArrayList<Integer> al = new ArrayList<>();
			for(int i=0; i<n1.length();i++) {
				n1 = val1;
				int w = n1.charAt(i)-'0';
				if(w == 1) {
					n1 = n1.substring(0,i) + "0" + n1.substring(i+1, n1.length());
				}
				else if(w ==0) {
					n1 = n1.substring(0,i) + "1" + n1.substring(i+1, n1.length());
				}
				arr[i] = Integer.parseInt(n1,2);
			}
			for(int i=0; i<n2.length();i++) {
				n2 = val2;
				int w = n2.charAt(i)-'0';
				if(w == 2) {
					n2 = n2.substring(0,i) + "1" + n2.substring(i+1, n2.length());
					al.add(Integer.parseInt(n2,3));
					n2 = n2.substring(0,i) + "0" + n2.substring(i+1, n2.length());
					al.add(Integer.parseInt(n2,3));
				}else if(w==1) {
					n2 = n2.substring(0,i) + "2" + n2.substring(i+1, n2.length());
					al.add(Integer.parseInt(n2,3));
					n2 = n2.substring(0,i) + "0" + n2.substring(i+1, n2.length());
					al.add(Integer.parseInt(n2,3));
				}
				else if(w ==0) {
					n2 = n2.substring(0,i) + "1" + n2.substring(i+1, n2.length());
					al.add(Integer.parseInt(n2,3));
					n2 = n2.substring(0,i) + "2" + n2.substring(i+1, n2.length());
					al.add(Integer.parseInt(n2,3));
				}
			}
			int sol = 0;
			for(int i=0; i<al.size(); i++) {
				for(int j=0; j<arr.length; j++) {
					if(al.get(i) == arr[j]) {
						sol = arr[j];
						break;
					}
				}
			}
			System.out.println("#" + tc+ " " + sol);
		}
	}
}
