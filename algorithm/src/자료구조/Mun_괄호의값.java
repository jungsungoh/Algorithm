package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class Mun_괄호의값 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		Stack<Character> st = new Stack<>();
		int val = 1;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch =='(' || ch=='[') {
				st.push(ch);
			}else if(ch ==']' && !st.isEmpty()) {
				char p = st.pop();
				if(p == '[') {
					val *=2;
				}else {
					System.out.println(0);
					return;
				}
			}else if(ch ==')' && !st.isEmpty()) {
				char p = st.pop();
				if(p == '(') {
					val *=3;
				}else {
					System.out.println(0);
					return;
				}
			}
		}

	}
}
