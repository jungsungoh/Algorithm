package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Mun_덱 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s1 = st.nextToken();
			if(s1.equals("push_front")) {
				dq.addFirst(Integer.parseInt(st.nextToken()));
			}else if(s1.equals("push_back")) {
				dq.addLast(Integer.parseInt(st.nextToken()));
			}else if(s1.equals("pop_front")) {
				if(dq.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(dq.pollFirst());
				}
			}else if(s1.equals("pop_back")) {
				if(dq.isEmpty()) {
					System.out.println("-1");
				}else {
					System.out.println(dq.pollLast());
				}
			}else if(s1.equals("size")) {
				System.out.println(dq.size());
			}else if(s1.equals("empty")) {
				if(dq.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(s1.equals("front")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(dq.peekFirst());
				}
			}else if(s1.equals("back")) {
				if(dq.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(dq.peekLast());
				}
			}
			
			
		}
		
		
		
	}
}
