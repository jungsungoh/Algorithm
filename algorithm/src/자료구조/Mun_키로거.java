package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Mun_키로거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			Stack<Character> left = new Stack<>();
			Stack<Character> right = new Stack<>();
			String s = br.readLine();
			for(int j=0; j<s.length(); j++) {
				char ch = s.charAt(j);
				if(ch == '<' && !left.isEmpty()) {
					right.push(left.pop());
				}else if(ch=='>' && !right.isEmpty()) {
					left.push(right.pop());
				}else if(ch=='-' && !left.isEmpty()) {
					left.pop();
				}else if(ch!= '<' && ch!= '>' && ch!='-'){
					left.push(ch);
				}
			}
			while(!left.isEmpty()) {
				right.push(left.pop());
			}
			while(!right.isEmpty()) {
				bw.append(right.pop());
			}
			bw.flush();
			bw.newLine();
		}
		
	}
}
