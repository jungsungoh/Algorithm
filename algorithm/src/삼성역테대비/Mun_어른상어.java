package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Mun_어른상어 {
	public static int[] di = {0,-1,1,0,0};
	public static int[] dj = {0,0,0,-1,1};
	public static int[][] arr;
	public static int n,m,k;
	public static Map<Integer,point> shark;
	public static smell[][] sm;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n  =Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		k = Integer.parseInt(l1.split(" ")[2]);
		arr = new int[n][n];
		shark = new HashMap<>();
		sm = new smell[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				shark.put(arr[i][j],new point(i,j,arr[i][j]));
			}
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=m; i++) {
			point shark1 = shark.get(i);
			shark1.dir = Integer.parseInt(st.nextToken());
			for(int p=0; p<4; p++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				if(p==0) {
					shark1.up.add(Integer.parseInt(st2.nextToken()));
					shark1.up.add(Integer.parseInt(st2.nextToken()));
					shark1.up.add(Integer.parseInt(st2.nextToken()));
					shark1.up.add(Integer.parseInt(st2.nextToken()));
				}else if(p==1) {
					shark1.down.add(Integer.parseInt(st2.nextToken()));
					shark1.down.add(Integer.parseInt(st2.nextToken()));
					shark1.down.add(Integer.parseInt(st2.nextToken()));
					shark1.down.add(Integer.parseInt(st2.nextToken()));
				}else if(p==2) {
					shark1.left.add(Integer.parseInt(st2.nextToken()));
					shark1.left.add(Integer.parseInt(st2.nextToken()));
					shark1.left.add(Integer.parseInt(st2.nextToken()));
					shark1.left.add(Integer.parseInt(st2.nextToken()));
				}else if(p==3) {
					shark1.right.add(Integer.parseInt(st2.nextToken()));
					shark1.right.add(Integer.parseInt(st2.nextToken()));
					shark1.right.add(Integer.parseInt(st2.nextToken()));
					shark1.right.add(Integer.parseInt(st2.nextToken()));
				}
			}
		}
		moving();
	}
	public static void moving() {
		// 맨 처음에는 모든 상어가 자신의 위치에 자신의 냄새를 뿌린다
		int time = 0;
		while(true) {
			for(Integer key : shark.keySet()) {
				point shark1 = shark.get(key);
				sm[shark1.x][shark1.y] = new smell(shark1.x,shark1.y,k, shark1.num); 
			}
			// 6. 그 후 1초마다 모든 상어가 동시에 상하좌우로 인접한 칸 중 하나로 이동하고,
			// 7. 각 상어가 이동 방향을 결정할 때는, 먼저 인접한 칸 중 아무 냄새가 없는 칸의 방향으로 잡는다. 그런 칸이 없으면 자신의 냄새가 있는 칸의 방향으로 잡는다.
			// 8. 이때 가능한 칸이 여러 개일 수 있는데, 그 경우에는 특정한 우선순위를 따른다. 
			//		우선순위는 상어마다 다를 수 있고, 같은 상어라도 현재 상어가 보고 있는 방향에 따라 또 다를 수 있다. 
			// 9. 상어가 맨 처음에 보고 있는 방향은 입력으로 주어지고, 그 후에는 방금 이동한 방향이 보고 있는 방향이 된다.
			for(int i=0; i<shark.size(); i++) {
				point shark1 = shark.get(i);
				int dir = shark1.dir;
				int nextdir = 0;
				for(int k=0; k<4; k++) {
					if(dir == 1) {
						nextdir = shark1.up.get(k);
					}else if(dir ==2) {
						nextdir = shark1.down.get(k);
					}else if(dir ==3) {
						nextdir = shark1.left.get(k);
					}else if(dir ==4) {
						nextdir = shark1.right.get(k);
					}
					int ni = shark1.x +di[nextdir];
					int nj = shark1.y +dj[nextdir];
					if(ni>=0 && ni<n && nj>=0 && nj<n ) {
						if(sm[ni][nj] == null) {
							shark1.x = ni;
							shark1.y = nj;
							shark1.dir = nextdir;
							shark.put(shark1.num,shark1);
							break;
						}
					}
				}
				point shark2 = shark.get(i);
				if(shark1.x == shark2.x && shark1.y == shark2.y) {
					for(int t = 1; t<=4; t++) {
						int ni = shark1.x+di[t];
						int nj = shark1.y+dj[t];
						if(ni>=0 && ni<n && nj>=0 && nj<n && sm[ni][nj] != null && sm[ni][nj].num == shark1.num) {
							shark1.x = ni;
							shark1.y = nj;
							shark1.dir = t;
							shark.put(shark1.num, shark1);
						}
					}
				}
			}

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(sm[i][j] != null && sm[i][j].time >0) {
						sm[i][j].time--;
						if(sm[i][j].time == 0 ) {
							sm[i][j] = null;
						}
					}
					arr[i][j] = 0;
				}
			}

			for(Integer num : shark.keySet()) {
				point shark1 = shark.get(num);

				if(arr[shark1.x][shark1.y]  == 0) {
					arr[shark1.x][shark1.y]= shark1.num;
				}else if(shark1.num<arr[shark1.x][shark1.y] ){
					shark.remove(arr[shark1.x][shark1.y]);
					arr[shark1.x][shark1.y] = shark1.num;
				}else {
					shark.remove(shark1.num);
				}
			}
			time++;
			if(shark.size() == 1 || time >= 1000) {
				break;
			}
		}
		System.out.println(time);
	}
	public static class point{
		int x, y, num, dir;
		ArrayList<Integer> up, down, left,right;
		public point(int x, int y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.up = new ArrayList<>();
			this.down = new ArrayList<>();
			this.left = new ArrayList<>();
			this.right = new ArrayList<>();
		}
	}
	public static class smell{
		int x, y, time, num;

		public smell(int x, int y, int time, int num) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.num = num;
		}
	}

}


// 1.상어가 사는 공간에 더 이상 물고기는 오지 않고 다른 상어들만이 남아있다. 
// 2.상어에는 1 이상 M 이하의 자연수 번호가 붙어 있고, 모든 번호는 서로 다르다. 

// 3.상어들은 영역을 사수하기 위해 다른 상어들을 쫓아내려고 하는데, 
//    1의 번호를 가진 어른 상어는 가장 강력해서 나머지 모두를 쫓아낼 수 있다.
// ---

// 4. N×N 크기의 격자 중 M개의 칸에 상어가 한 마리씩 들어 있다.
// 5. 맨 처음에는 모든 상어가 자신의 위치에 자신의 냄새를 뿌린다. 
// 6. 그 후 1초마다 모든 상어가 동시에 상하좌우로 인접한 칸 중 하나로 이동하고, 
// 7. 자신의 냄새를 그 칸에 뿌린다. 냄새는 상어가 k번 이동하고 나면 사라진다.


// 7. 각 상어가 이동 방향을 결정할 때는, 먼저 인접한 칸 중 아무 냄새가 없는 칸의 방향으로 잡는다. 그런 칸이 없으면 자신의 냄새가 있는 칸의 방향으로 잡는다.
// 8. 이때 가능한 칸이 여러 개일 수 있는데, 그 경우에는 특정한 우선순위를 따른다. 
//     우선순위는 상어마다 다를 수 있고, 같은 상어라도 현재 상어가 보고 있는 방향에 따라 또 다를 수 있다. 
// 9. 상어가 맨 처음에 보고 있는 방향은 입력으로 주어지고, 그 후에는 방금 이동한 방향이 보고 있는 방향이 된다.


// 10. 모든 상어가 이동한 후 한 칸에 여러 마리의 상어가 남아 있으면, 가장 작은 번호를 가진 상어를 제외하고 모두 격자 밖으로 쫓겨난다.



//=> 1번 상어만 격자에 남게 되기까지 몇 초가 걸리는지를 구하는 프로그램을 작성하시오.