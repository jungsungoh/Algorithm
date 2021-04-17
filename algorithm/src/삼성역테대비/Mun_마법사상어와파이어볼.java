package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Mun_마법사상어와파이어볼 {
	public static int n, m , k;
	public static ArrayList<point>[] al;
	public static int[] di = {-1,-1,0,1,1,1,0,-1};
	public static int[] dj = {0,1,1,1,0,-1,-1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" " )[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		k = Integer.parseInt(l1.split(" ")[2]);
		al = new ArrayList[n*n];
		for(int i=0; i<n*n ; i++) {
			al[i] = new ArrayList<>();
		}

		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken())-1;
			int sj = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int num = si*n+sj;
			al[num].add(new point(weight,speed,dir));
		}
		for(int i=0; i<k; i++) {
			movingfire();
			sumfire();
		}
		int sum = 0;
		for(int i=0; i<n*n; i++) {
			for(point x : al[i]) {
				sum += x.weight;
			}
		}
		System.out.println(sum);
	}
	public static void movingfire() {
		Map<Integer, move> m = new HashMap<>();
		int p = 0;
		for(int i=0; i<n*n; i++) {
			int size = al[i].size();
			for(int s = 0; s<size ;s++) {
				point x = al[i].get(0);
				int si = i/n, sj = i%n;
				int speed = x.speed%(n);
				int ni = si, nj = sj;
				for(int k=0; k<speed; k++) {
					ni = ni + di[x.dir];
					nj = nj + dj[x.dir];
					if(ni >=n ) {
						ni = 0;
					}
					else if(ni <= -1) {
						ni = n-1;
					}
					if(nj >=n) {
						nj= 0;
					}else if(nj <= -1) {
						nj = n-1;
					}
				}
				m.put(p++, new move(ni*n+nj, x));
				al[i].remove(0);
			}
		}
		for(Integer t : m.keySet()) {
			move q = m.get(t);
			al[q.idx].add(q.p);
		}
		
		
	}
	public static void sumfire() {
		for(int i=0; i<n*n; i++) {
			if(al[i].size() >= 2) {
				int msum = 0,speedsum =0;
				int predirs = al[i].get(0).dir%2;
				boolean check = false;
				for(point x : al[i]) {
					int dirs = x.dir%2;
					msum += x.weight;
					speedsum += x.speed;
					if(dirs != predirs) {
						check = true;
					}
					predirs = dirs;
				}
				int eachsum = msum/5;
				int eachspeedsum = speedsum/al[i].size();
				al[i] = new ArrayList<>();
				if(eachsum != 0) {
					int val = 0;
					if(check) {
						val = 1;
					}
					for(int k=0; k<4; k++) {
						al[i].add(new point(eachsum, eachspeedsum,val +2*k));
					}
				}
			}
		}
	}
	public static class point{
		int weight, speed, dir;

		public point(int weight, int speed, int dir) {
			super();	
			this.weight = weight;
			this.dir = dir;
			this.speed = speed;
		}

	}
	public static class move{
		int idx;
		point p;
		public move(int idx, point p) {
			super();
			this.idx = idx;
			this.p = p;
		}
	}
}

// 마법사 상어가 크기가 N×N인 격자에 파이어볼 M개를 발사했다. 
// 가장 처음에 파이어볼은 각자 위치에서 이동을 대기하고 있다. 
// i번 파이어볼의 위치는 (ri, ci), 질량은 mi이고, 방향은 di, 속력은 si이다. 위치 (r, c)는 r행 c열을 의미한다.



// 마법사 상어가 모든 파이어볼에게 이동을 명령

// 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다
// => 이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.

// 2. 이동이 모두 끝난 뒤, 2개 이상의 파이어볼이 있는 칸에서는 다음과 같은 일이 일어난다.
// 1. 같은 칸에 있는 파이어볼은 모두 하나로 합쳐진다.
// 2. 파이어볼은 4개의 파이어볼로 나누어진다.
// 3. 나누어진 파이어볼의 질량, 속력, 방향은 다음과 같다.
// 3-1. 질량은 ⌊(합쳐진 파이어볼 질량의 합)/5⌋이다.
// 3-2. 속력은 ⌊(합쳐진 파이어볼 속력의 합)/(합쳐진 파이어볼의 개수)⌋이다.
// 3-3. 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수이면, 방향은 0, 2, 4, 6이 되고, 그렇지 않으면 1, 3, 5, 7이 된다.

// 4.질량이 0인 파이어볼은 소멸되어 없어진다.
