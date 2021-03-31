package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_게리맨더링 {
	public static int n, result = Integer.MAX_VALUE;
	public static int[] arr;
	public static ArrayList<Integer> section1, section2;
	public static boolean[] check, visited, issection1, issection2;
	public static ArrayList<Integer>[] al;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		check = new boolean[n+1];
		visited = new boolean[n+1];
		al = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			al[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				al[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		subset(0);
		System.out.println(result == Integer.MAX_VALUE?"-1":result);
	}
	
	public static void subset(int idx) {
		if(check.length == idx) {
			int sum1 = 0, sum2 = 0;
			section1 = new ArrayList<>();
			section2 = new ArrayList<>();
			issection1 = new boolean[n+1];
			issection2 = new boolean[n+1];
			for(int i=1; i<check.length; i++) {
				if(check[i]) {
					section1.add(i);
					issection1[i] = true;
					sum1 += arr[i];
				}else {
					section2.add(i);
					issection2[i] = true;
					sum2 += arr[i];
				}
			}
			if(section1.size() ==0 || section2.size() == 0) return;
			visited =new boolean[n+1];
			bfs(section1,1);
			for(int i=0; i<section1.size(); i++) {
				if(!visited[section1.get(i)]) {
					return;
				}
			}
			visited =new boolean[n+1];
			bfs(section2,2);
			for(int i=0; i<section2.size(); i++) {
				if(!visited[section2.get(i)]) {
					return;
				}
			}
			result = Math.min(result, Math.abs(sum1-sum2));
			return;
		}
		
		check[idx] = true;
		subset(idx+1);
		check[idx] = false;
		subset(idx+1);
	}
	public static void bfs(ArrayList<Integer> section, int flag) {
		Queue<Integer> q = new LinkedList<>();
		q.add(section.get(0));
		visited[section.get(0)] = true;
		
		while(!q.isEmpty()) {
			int p = q.poll();
			for(Integer next : al[p]) {
				if(!visited[next] ) {
					if(flag ==1 && issection1[next]) {
						q.add(next);
						visited[next] = true;
					}else if(flag ==2 && issection2[next]) {
						q.add(next);
						visited[next ] = true;
					}
				}
			}
		}
	}
}
