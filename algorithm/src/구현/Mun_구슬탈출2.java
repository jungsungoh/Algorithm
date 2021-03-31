package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Mun_구슬탈출2 {
	public static int n, m, result = -1;
	public static char[][] arr;
	public static ball red, blue;
	public static boolean[][][][][][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		n = Integer.parseInt(l1.split(" ")[0]);
		m =Integer.parseInt(l1.split(" ")[1]);
		arr = new char[n][m];
		visited = new boolean[n][m][n][m][2][2];

		for(int i=0; i<n; i++) {
			String l2 = br.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j] = l2.charAt(j);
				if(arr[i][j] == 'R') {
					red = new ball(i, j, 'R', 0);
				}else if(arr[i][j] =='B'){
					blue = new ball(i, j, 'B', 0);
				}
			}
		}

		bfs();
		System.out.println(result);
	}
	public static void bfs() {
		Queue<ball[]> q = new LinkedList<>();
		ball[] e = new ball[2];
		e[0] = red;e[1] = blue;
		q.add(e);
		visited[red.x][red.y][blue.x][blue.y][0][0]= true;  
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s<size;s++) {
				ball[] b = q.poll();
				if(time > 10) {
					return;
				}
				if(b[0].goal == 1 && b[1].goal ==0) {
					result = time;
					return;
				}

				for(int k=0; k<4; k++) {
					ball tmp1 = new ball(b[0].x, b[0].y, b[0].type,0);
					ball tmp2 = new ball(b[1].x, b[1].y, b[1].type,0);
					move(tmp1, tmp2, k);
					if(!visited[tmp1.x][tmp1.y][tmp2.x][tmp2.y][tmp1.goal][tmp2.goal]) {
						ball[] newb = new ball[2];
						newb[0] = new ball(tmp1.x, tmp1.y,tmp1.type,tmp1.goal);
						newb[1] = new ball(tmp2.x, tmp2.y, tmp2.type, tmp2.goal);
						q.add(newb);
						visited[tmp1.x][tmp1.y][tmp2.x][tmp2.y][tmp1.goal][tmp2.goal] = true;
					}
				}
			}
			time++;
		}
	}

	public static void move(ball red, ball blue, int idx) {
		if(idx ==0) {// 왼쪽무빙
			if(red.x == blue.x) {
				if(red.y < blue.y) {
					ballmove(red,blue,0);
					ballmove(blue,red,0);
				}else {
					ballmove(blue,red,0);
					ballmove(red,blue,0);
				}
			}else{
				ballmove(red,blue,0);
				ballmove(blue,red,0);
			}
		}else if(idx == 1) { // 오른쪽
			if(red.x == blue.x) {
				if(red.y > blue.y) {
					ballmove(red, blue,1);
					ballmove(blue,red,1);
				}else {
					ballmove(blue,red,1);
					ballmove(red,blue, 1);
				}
			}else {
				ballmove(red,blue,1);
				ballmove(blue,red,1);
			}
		}else if(idx ==2) { // 위
			if(red.y == blue.y) {
				if(red.x < blue.x) {
					ballmove(red,blue,2);
					ballmove(blue,red,2);
				}else {
					ballmove(blue,red,2);
					ballmove(red,blue,2);
				}
			}else {
				ballmove(red,blue,2);
				ballmove(blue,red,2);
			}
		}else if(idx ==3) { // 아래
			if(red.y == blue.y) {
				if(red.x > blue.x) {
					ballmove(red,blue,3);
					ballmove(blue,red,3);
				}else {
					ballmove(blue,red,3);
					ballmove(red,blue,3);
				}
			}else {
				ballmove(red,blue,3);
				ballmove(blue,red,3);
			}
		}
	}

	public static void ballmove(ball b, ball b2, int idx) { 
		int ni =b.x, nj = b.y;
		while(true) {
			if(idx == 0) {
				nj = nj-1;
			}else if(idx == 1) {
				nj = nj+1;
			}else if(idx == 2) {
				ni = ni-1;
			}else if(idx == 3) {
				ni = ni+1;
			}
			if(ni >=0 && ni<n && nj>=0 && nj<m &&(!(ni ==b2.x && nj ==b2.y) || arr[ni][nj] =='O' ) && arr[ni][nj] !='#') {
				if(arr[ni][nj] == 'O') {
					b.x = ni; b.y = nj;
					b.goal = 1;
					return;
				}
			}else {
				break;
			}
		}
		if(idx == 0) {
			b.x = ni;b.y = nj+1;
		}else if(idx == 1) {
			b.x = ni;b.y = nj-1;
		}else if(idx == 2) {
			b.x = ni+1;b.y = nj;
		}else if(idx == 3) {
			b.x = ni-1;b.y = nj;
		}
	}

	public static class ball{
		int x, y, goal;
		char type;

		public ball(int x, int y, char type, int goal) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.goal = goal;
		}
	}
}



// 구슬 탈출은 직사각형 보드에 빨간 구슬과 파란 구슬을 하나씩 넣은 다음, 빨간 구슬을 구멍을 통해 빼내는 게임이다.
// 가장 바깥 행과 열은 모두 막혀져 있고, 보드에는 구멍이 하나 있다. 빨간 구슬과 파란 구슬의 크기는 보드에서 1×1크기의 칸을 가득 채우는 사이즈이고, 각각 하나씩 들어가 있다.
// 게임의 목표는 빨간 구슬을 구멍을 통해서 빼내는 것이다. 이때, 파란 구슬이 구멍에 들어가면 안 된다.
// 왼쪽으로 기울이기, 오른쪽으로 기울이기, 위쪽으로 기울이기, 아래쪽으로 기울이기와 같은 네 가지 동작이 가능하다.
// 보드의 상태가 주어졌을 때, 최소 몇 번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지 구하는 프로그램을 작성하시오


// 전략
// 1. 무브
// 2. 정지한 위치가 o 이면 time
// 3. 