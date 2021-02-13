package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			}else if(s.equals("pop") ){
				if(!q.isEmpty()) {
					bw.append(String.valueOf(q.poll()));
					bw.newLine();
				}else {
					bw.append("-1");
					bw.newLine();
				}
			}else if(s.equals("size")) {
				bw.append(String.valueOf(q.size()));
				bw.newLine();
			}else if(s.equals("empty")) {
				if(!q.isEmpty()) {
					bw.append("0");
					bw.newLine();
				}else {
					bw.append("1");
					bw.newLine();
				}
			}else if(s.equals("front")) {
				if(!q.isEmpty()) {
					bw.append(String.valueOf(q.peek()));
					bw.newLine();
				}else {
					bw.append("-1");
					bw.newLine();
				}
			}else if(s.equals("back")) {
				if(!q.isEmpty()) {
					bw.append(String.valueOf(q.peekLast()));
					bw.newLine();
				}else {
					bw.append("-1");
					bw.newLine();
				}
			}
		}
		bw.flush();
	}
}
