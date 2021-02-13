package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Mun_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String l1 = br.readLine();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		for(int i=0; i<l1.length(); i++) {
			left.add(l1.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("P")) {
				String ch = st.nextToken();
				left.push(ch.charAt(0));
			}else if(s.equals("L") && !left.isEmpty()) {
				right.push(left.pop());
			}else if(s.equals("D")&& !right.isEmpty()) {
				left.push(right.pop());
			}else if(s.equals("B") && !left.isEmpty()) {
				left.pop();
			}
		}
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		while(!right.isEmpty()) {
			bw.append(right.pop());
		}
		bw.flush();
	}
}
