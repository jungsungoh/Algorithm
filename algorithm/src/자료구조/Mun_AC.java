package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;


public class Mun_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		for(int j = 0; j<tc; j++) {
			String com = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String arr= br.readLine();
			String res = arr.substring(1,arr.length()-1);
			Deque<Integer> dq = new ArrayDeque<>();
			if(n != 0) {
				String[] val = res.split(",");
				for(int i=0; i<val.length; i++) {
					dq.add(Integer.parseInt(val[i]));
				}
			}else {
				if(com.contains("D")) {
					bw.append("error");
					bw.newLine();
				}
				else {
					bw.append("[]");
					bw.newLine();
				}
				continue;
			}

			int dir = 0;
			int flag = 0;
			for(int i=0; i<com.length(); i++) {
				if(com.charAt(i) == 'R') {
					dir = dir==0? 1 : 0;
				}else {
					if(dq.isEmpty()) {
						flag = 1;
						break;
					}else {
						if(dir == 0) {
							dq.removeFirst();
						}else {
							dq.removeLast();
						}
					}
				}
			}
			int size = dq.size();

			if(flag == 1) {
				bw.append("error");
				bw.newLine();
			}else {
				bw.append("[");
				for(int i=0; i<size-1; i++) {
					if(dir == 0) {
						bw.append(dq.pollFirst()+",");
					}else {
						bw.append(dq.pollLast()+",");
					}
				}
				if(dq.size()==1) {
					bw.append(String.valueOf(dq.poll()));
				}
				bw.append("]");
				bw.newLine();
			}
		}
		bw.flush();
	}
}
