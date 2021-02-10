package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Mun_균형잡힌세상 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			Stack<Character> st = new Stack<>();
			String l1 = br.readLine();
			int flag = 0;
			if(l1.equals(".")) {
				return;
			}
			for(int i=0; i<l1.length(); i++) {
				char ch = l1.charAt(i);
				if(ch == '(' || ch =='[') {
					st.push(ch);
				}
				if(ch == ')') {
					if(!st.isEmpty() && st.peek() == '(') {
						st.pop();
					}else {
						flag =1;
						break;
					}
				}
				if(ch == ']') {
					if(!st.isEmpty() && st.peek() == '[') {
						st.pop();
					}else {
						flag =1;
						break;
					}
				}
			}
			
			if(flag ==0 && st.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}
		}
	}
}
