package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Mun_안정적인문자열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = 1;
		while(true) {
			String l1 = br.readLine();
			if(l1.contains("-")) {
				return;
			}
			Stack<Character> st = new Stack<>();
			int cnt = 0;
			for(int i=0; i<l1.length(); i++) {
				char ch = l1.charAt(i);
				if(ch == '{') {
					st.push(ch);
				}else if(ch=='}'){
					if(st.isEmpty()) {
						st.push('{');
						cnt++;
					}else if(!st.isEmpty() && st.peek()=='{') {
						st.pop();
					}
				}
			}
			System.out.println(num+". " + (cnt+ (st.size()/2)));
			num++;
		}
	}
}
