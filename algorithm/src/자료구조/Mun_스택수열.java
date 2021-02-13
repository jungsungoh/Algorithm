package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Mun_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int pr = 1;
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(br.readLine());
			while(pr> num && !st.isEmpty() && st.peek() != num) {
				st.pop();
				sb.append("-");
				sb.append("-");
			}
			while(pr<=num) {
					st.push(pr++);
					sb.append("+");
					sb.append("\n");
			}
			if(!st.isEmpty() && st.peek() == num) {
				st.pop();
				sb.append("-");
				sb.append("\n");
			}else{
				System.out.println("NO");
				return;
			}
		}
		System.out.println(sb.toString());
	}
}
