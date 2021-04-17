package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Mun_이차원배열과연산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int r = Integer.parseInt(l1.split(" ")[0]);
		int c =Integer.parseInt(l1.split(" ")[1]);
		int k = Integer.parseInt(l1.split(" ")[2]);
		
		int[][] arr = new int[3][3];
		int n = 3;
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] tmp = new int[n][n];
		int time = 0;
		while(true) {
			if(arr.length >= r && arr[0].length >= c &&  arr[r-1][c-1] == k) {
				break;
			}
			if(time == 100) {
				time = -1;
				break;
			}
			time++;
			if(arr.length >= arr[0].length) {
				tmp = rowCal(arr);
			}else if(arr.length < arr[0].length) {
				tmp = colCal(arr);
			}
			arr = tmp;
//			for(int i=0; i<arr.length; i++) {
//				for(int j=0; j<arr[0].length; j++) {
//					System.out.print(arr[i][j] + " ");
//				}System.out.println();
//			}
		}
		System.out.println(time);
		
	}
	public static int[][] rowCal(int[][] arr) { // 행연산
		
		int[][] temp = null;
		if(arr[0].length >= 100) {
			return arr;
		}
		PriorityQueue<point>[] pq = new PriorityQueue[arr.length];
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			
			pq[i] = new PriorityQueue<>();
			Map<Integer,Integer> m = new HashMap<>();
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j] == 0) continue;
				if(m.containsKey(arr[i][j])) {
					m.put(arr[i][j], m.get(arr[i][j])+1);
				}else {
					m.put(arr[i][j],1);
				}
			}
			for(Integer key : m.keySet()) {
				pq[i].add(new point(key, m.get(key)));
			}
			max = Math.max(pq[i].size(), max);
		}
		temp = new int[arr.length][max*2];
		
		
		for(int i=0; i<arr.length; i++) {
			int idx = 0;
			while(!pq[i].isEmpty()) {
				point p = pq[i].poll();
				temp[i][idx++] = p.num;
				temp[i][idx++] = p.cnt;
			}
		}
		return temp;
	}
	public static int[][] colCal(int[][] arr) {
		int[][] temp = null;
		if(arr.length >= 100) {
			return arr;
		}
		PriorityQueue<point>[] pq = new PriorityQueue[arr[0].length];
		int max = 0;
		for(int j=0; j<arr[0].length; j++) {
			pq[j] = new PriorityQueue<>();
			Map<Integer,Integer> m = new HashMap<>();
			for(int i=0; i<arr.length; i++) {
				if(arr[i][j] == 0) continue;
				if(m.containsKey(arr[i][j])) {
					m.put(arr[i][j], m.get(arr[i][j])+1);
				}else {
					m.put(arr[i][j],1);
				}
			}
			for(Integer key : m.keySet()) {
				pq[j].add(new point(key, m.get(key)));
			}
			max = Math.max(pq[j].size(), max);
		}
		temp = new int[max*2][arr[0].length];
		
		
		for(int i=0; i<arr[0].length; i++) {
			int idx = 0;
			while(!pq[i].isEmpty()) {
				point p = pq[i].poll();
				temp[idx++][i] = p.num;
				temp[idx++][i] = p.cnt;
			}
		}
		return temp;
	}
	
	public static class point implements Comparable<point>{
		int num, cnt;
		
		public point(int num, int cnt) {
			super();
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(point o) {
			// TODO Auto-generated method stub
			if(this.cnt == o.cnt) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.cnt, o.cnt);
		}
		
	}
}
