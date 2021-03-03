package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_Gaaaaaaaaaarden {
	public static int n, m, green ,red, cnt = 0, max = 0;
	public static int[][] arr;
	public static int[][] visitedRed, visited;
	public static boolean[] used;
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static ArrayList<point> al;
	public static point[] reds, greens;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		green = Integer.parseInt(l1.split(" ")[2]);
		red = Integer.parseInt(l1.split(" ")[3]);

		arr = new int[n][m];
		visited = new int[n][m];
		visitedRed = new int[n][m];
		greens = new point[green];
		reds = new point[red];
		al = new ArrayList<>();
		used = new boolean[10];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 2) {
					//al.add(new point(i,j, 0));
				}
			}
		}
		perm_green(0,0);
		System.out.println(max);
	}
	private static void perm_green(int start, int r){
		if(r == green){
			perm_red(0, 0);
			return;
		}

		for(int i=start; i<al.size(); i++){
			if(!used[i]){
				used[i] = true;
				greens[r] = al.get(i);
				perm_green(i+1, r+1);
				used[i] = false;
			}
		}
	}

	private static void perm_red(int start, int r){
		if(r == red){
			for(int i=0; i<greens.length; i++) {
				//greenBFS(greens[i].x, greens[i].y);
			}
			for(int i=0; i<reds.length; i++) {
				//redBFS(reds[i].x, reds[i].y);
			}
			print();
			System.out.println("------------------------");
			print2();
			System.out.println("cnt=" + cnt);
			System.out.println("==============");
			max = Math.max(cnt,  max);
			cnt = 0;
			visited = new int[n][m];
			visitedRed = new int[n][m];
			return;
		}

		for(int i=start; i<al.size(); i++){
			if(!used[i]){
				used[i] = true;
				reds[r] = al.get(i);
				perm_red(i+1, r+1);
				used[i] = false;
			}
		}
	}
	
	public static void bfs() {
		
		Queue<point> redQ = new LinkedList<>();
		Queue<point> greenQ = new LinkedList<>();
		for(int i=0; i<reds.length; i++) {
			redQ.add(reds[i]);
		}
		for(int i=0; i<greens.length; i++) {
			greenQ.add(greens[i]);
		}
		
		while(true) {
			if(redQ.isEmpty() && greenQ.isEmpty()) {
				max = Math.max(cnt, max);
				break;
			}
			int redSize = redQ.size();
			int greenSize = greenQ.size();
			
			for(int i=0; i<redSize; i++) {
				
			}
		}
	}
	
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void print2() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print(visitedRed[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static class point{
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
// BOJ 마을에서는 직접 사람이 씨앗을 심는 대신 초록색 배양액과 빨간색 배양액을 땅에 적절하게 뿌려서 꽃을 피울 것이다.
// 배양액은 매 초마다 이전에 배양액이 도달한 적이 없는 인접한 땅으로 퍼져간다.
// 하얀색 칸은 배양액을 뿌릴 수 없는 땅을, 황토색 칸은 배양액을 뿌릴 수 있는 땅을, 하늘색 칸은 호수를 의미한다.
// 초록색 배양액과 빨간색 배양액이 동일한 시간에 도달한 땅에서는 두 배양액이 합쳐져서 꽃이 피어난다. 
// 꽃이 피어난 땅에서는 배양액이 사라지기 때문에 더 이상 인접한 땅으로 배양액을 퍼트리지 않는다.
// 모든 배양액은 서로 다른 곳에 뿌려져야 한다.
// 정원과 두 배양액의 개수가 주어져있을 때 피울 수 있는 꽃의 최대 개수를 구해보자.
//  0은 호수, 1은 배양액을 뿌릴 수 없는 땅, 2는 배양액을 뿌릴 수 있는 땅