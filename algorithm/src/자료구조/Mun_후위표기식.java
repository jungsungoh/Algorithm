package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Mun_후위표기식 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		StringBuffer sb = new StringBuffer();
		Stack<Character> st = new Stack<>();
		for(int i=0; i<l1.length(); i++) {
			char ch = l1.charAt(i);
			// 스택안에 들어있는게 우선순위가 같거나 크면 꺼냄.
			// 들어오는게 더크면 걍 집어넣는다.
			if(Character.isAlphabetic(ch)){
				sb.append(ch);
			}else if(ch == '(') {
				st.push(ch);
			}else if(ch ==')') {
				while(true) {
					char ch2 = st.pop();
					if(ch2 == '(') {
						break;
					}else {
						sb.append(ch2);
					}
				}
			}else if(ch=='*' || ch =='/') {
				while(!st.isEmpty() && (st.peek() =='*' || st.peek() == '/')) {
					sb.append(st.pop());
				}
				st.push(ch);
			}else if(ch=='+' || ch =='-') {
				while(!st.isEmpty() && st.peek() !='(') {
					sb.append(st.pop());
				}
				st.push(ch);
			}
		}
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb.toString());
	}
}
