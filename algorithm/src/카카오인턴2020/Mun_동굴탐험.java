package 카카오인턴2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Mun_동굴탐험 {
	public static ArrayList<Integer>[] al, pre;
	public static boolean[] visited;
	public static int[] pre_cnt, result;
	public static void main(String[] args) {
		int n = 9;
		int[][] path ={{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
		int[][] order = {{8,5},{6,7},{4,1}};
		System.out.println(solution(n, path, order));
	}
	public static boolean solution(int n, int[][] path, int[][] order) {
        boolean answer = true;
        al = new ArrayList[n];
        pre = new ArrayList[n];
        visited = new boolean[n];
        pre_cnt = new int[n];
        result = new int[n];
        for(int i= 0; i<n; i++) {
        	al[i] = new ArrayList<>();
        	pre[i] = new ArrayList<>();
        }
        for(int i=0; i<path.length; i++) {
        	int v1 = path[i][0];
        	int v2 = path[i][1];
        	al[v1].add(v2);
        	al[v2].add(v1);
        }
        
        for(int i=0; i<order.length; i++) {
        	int v1 = order[i][0];
        	int v2 = order[i][1];
        	pre[v1].add(v2);
        	pre_cnt[v2]++;
        }
        
        return answer;
    }
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;
		
		
		while(!q.isEmpty()) {
			int i = q.poll();
			
			for(Integer next : al[i]) {
				if(!visited[next] && pre_cnt[next] != 0) {
					
				}
			}
			
			
		}
	}
}

//  탐험 도중 n개의 방으로 이루어진 지하 동굴을 탐험하게 되었습니다. 
// 모든 방에는 0부터 n - 1 까지 번호가 붙어있고, 이 동굴에 들어갈 수 있는 유일한 입구는 0번 방과 연결되어 있습니다. 
//  방들은 양방향으로 통행이 가능한 통로로 서로 연결되어 있는데, 서로 다른 두 방을 직접 연결하는 통로는 오직 하나입니다. 

// 임의의 서로 다른 두 방 사이의 최단경로는 딱 한 가지만 있으며, 
// 또한 임의의 두 방 사이에 이동이 불가능한 경우는 없습니다.


// 모든 방을 적어도 한 번은 방문해야 합니다.
// 특정 방은 방문하기 전에 반드시 먼저 방문할 방이 정해져 있습니다.
// 2-1. 이는 A번 방은 방문하기 전에 반드시 B번 방을 먼저 방문해야 한다는 의미입니다.
// 2-2. 어떤 방을 방문하기 위해 반드시 먼저 방문해야 하는 방은 없거나 또는 1개 입니다.
// 2-3. 서로 다른 두 개 이상의 방에 대해 먼저 방문해야 하는 방이 같은 경우는 없습니다.
// 2-4. 어떤 방이 먼저 방문해야 하는 방이면서 동시에 나중에 방문해야 되는 방인 경우는 없습니다.