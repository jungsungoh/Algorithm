package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_강의실배정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<study> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			pq.add(new study(start,end));
		}
		int cnt = 0;
		int start = 0;
		int end = 0;
		while(!pq.isEmpty()) {
			study s = pq.poll();
			start = s.start;
			end = s.end;
		}
	}
	public static class study implements Comparable<study>{
		int start, end;

		public study(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(study o) {
			// TODO Auto-generated method stub
			if(this.start == o.start) {
				return Integer.compare(this.end, o.end);
			}else {
				return Integer.compare(this.start, o.start);
			}
		}
		
		
	}
}
