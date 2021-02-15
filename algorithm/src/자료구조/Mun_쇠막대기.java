package 자료구조;

import java.util.Scanner;
import java.util.Stack;

public class Mun_쇠막대기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		s= s.replace("()", "1");
		//System.out.println(s);
		Stack<Character> st = new Stack<>();
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch == '(') {
				st.push(ch);
			}else if(ch =='1') {
				cnt+= st.size();
			}else if(ch ==')' && !st.isEmpty()) {
				st.pop();
				cnt+=1;
			}
		}
		System.out.println(cnt);
	}
}
