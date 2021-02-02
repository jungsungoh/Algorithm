package str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Mun_back1786 {
	static ArrayList<Integer> al;
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}

		return pi;
	}
	static void KMP(String parent, String pattern) {
		int[] table = getPi(pattern);
		int j = 0; 
		for(int i = 0 ; i< parent.length(); i++) {
			while(j >0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if(parent.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					al.add(i-pattern.length()+1);
					j = table[j];
				}else {
					j++;
				}
			}
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		al = new ArrayList<>();
		String parent = br.readLine();
		String pattern = br.readLine();
		KMP(parent, pattern);
		System.out.println(al.size());
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i)+1);
		}

	}
}
