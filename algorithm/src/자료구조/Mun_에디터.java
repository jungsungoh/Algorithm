package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Mun_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		StringBuffer sb = new StringBuffer(l1);
		int idx = sb.length();
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("P")) {
				String ch = st.nextToken();
				sb.insert(idx, ch);
			}else if(s.equals("L")) {
				if(idx >=1) {
					idx--;
				}
			}else if(s.equals("D")) {
				if(idx <sb.length()) {
					idx++;
				}
			}else if(s.equals("B")) {
				if(idx>0) {
					sb.deleteCharAt(idx);
					idx--;
				}
			}
			System.out.println(sb.toString());
		}
	}
}
