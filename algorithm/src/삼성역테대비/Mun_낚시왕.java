package 삼성역테대비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_낚시왕 {
	public static Map<Integer, shark> sharks;
	public static int n, m, mary;
	public static int[][] arr;
	public static int[] di = {0,-1,1,0,0};
	public static int[] dj = {0,0,0,1,-1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m = Integer.parseInt(l1.split(" ")[1]);
		mary = Integer.parseInt(l1.split( " ")[2]);
		sharks = new HashMap<>();
		arr = new int[n+1][m+1];

		for(int i=0; i<mary; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int si = Integer.parseInt(st.nextToken());
			int sj = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			arr[si][sj] = size;
			if(dir == 1 || dir==2) {
				speed = speed%(n*2-2);
			}else {
				speed = speed%(m*2-2);
			}
			sharks.put(size, new shark(si,sj,speed,size,dir));
		}
		int stand = 1;
		int size = 0;
		while(stand <=m) {
			// 상어잡기
			for(int i=1; i<=n; i++) {
				if(arr[i][stand] != 0) {
					size += arr[i][stand];
					sharks.remove(arr[i][stand]);
					arr[i][stand] =0;
					break;
				}
			}
			shark_move();
			stand++;
		}
		System.out.println(size);

	}
	public static void shark_move() {
		int[][] temp = new int[n+1][m+1];

		Queue<Integer> q = new LinkedList<>();
		for(Integer key : sharks.keySet()) {
			shark sh = sharks.get(key); 
			arr[sh.x][sh.y]= 0; 
			int speed = sh.speed;
			int ni = sh.x, nj = sh.y;
			
			// 상어가 들어갈 위치 찾기
			for(int i=1; i<=speed; i++) {
				ni+=di[sh.dir];
				nj+=dj[sh.dir];
				if(!(ni>=1 && ni<=n && nj>=1 && nj<=m)) {
					if(sh.dir == 1) sh.dir =2;
					else if(sh.dir == 2) sh.dir = 1;
					else if(sh.dir == 3) sh.dir = 4;
					else if(sh.dir == 4) sh.dir = 3;
					ni += di[sh.dir];
					nj += dj[sh.dir];
					i--;
				}
			}
			if(temp[ni][nj] == 0) { // 아무것도 없으면
				temp[ni][nj] = sh.size;
			}else if(temp[ni][nj] < sh.size) { // 약한애 있으면
				q.add(temp[ni][nj]);
				temp[ni][nj] = sh.size;
			} else { // 쌘애 있으면?
				q.add(sh.size);
			}
			sharks.put(sh.size, new shark(ni, nj, sh.speed, sh.size, sh.dir));
		}

		// 작은 애들 삭제
		int size = q.size();
		for(int i=0; i<size; i++) {
			int shsize = q.poll();
			sharks.remove(shsize);
		}
		for(Integer key : sharks.keySet()) {
			shark s = sharks.get(key);
			arr[s.x][s.y]= temp[s.x][s.y]; 
		}
	}
	public static class shark{
		int x, y, speed, size, dir;

		public shark(int x, int y, int speed, int size, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.size = size;
			this.dir = dir;
		}

	}
}


// 낚시왕 오른쪽 한칸 이동
// 낚시왕 상어잡기 => 잡히면 상어 제거
// 상어 무빙 함수

