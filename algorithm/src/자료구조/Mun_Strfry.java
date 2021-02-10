package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_Strfry {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			int[] arr = new int[26];
			int[] arr2 = new int[26];
			int flag = 0;
			for(int j=0; j<s1.length(); j++) {
				int ch = (int)(s1.charAt(j)-'a');
				arr[ch]++;
			}
			for(int j=0; j<s2.length(); j++) {
				int ch = (int)(s2.charAt(j)-'a');
				arr2[ch]++;
			}
			for(int j=0; j<26; j++) {
				if(arr[j] != arr2[j]) {
					flag = 1;
					break;
				}
			}
			if(flag == 1) {
				System.out.println("Impossible");
			}else {
				System.out.println("Possible");
			}
		}
	}
}
