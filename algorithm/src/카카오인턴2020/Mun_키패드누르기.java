package 카카오인턴2020;

import java.util.LinkedList;
import java.util.Queue;

public class Mun_키패드누르기 {
	public static int[] di = {-1,1,0,0};
	public static int[] dj = {0,0,-1,1};
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}
	public static String solution(int[] numbers, String hand) {
		String answer = "";
		char[][] key = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
		hands left = new hands(3,0,0);
		hands right = new hands(3,2,0);

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<numbers.length; i++) {
			System.out.print(numbers[i] + " ");
			char find = (char)(numbers[i]+'0');
			if(find == '1' || find == '4' || find == '7') {
				sb.append('L');
				System.out.print('L' + " ");
				hands l_temp = bfs(left.x,  left.y, find, key);
				left = new hands(l_temp.x, l_temp.y, 0);
			}else if(find =='3' || find =='6' || find =='9') {
				sb.append('R');
				System.out.print('R' + " ");
				hands r_temp = bfs(right.x, right.y, find, key);
				right = new hands(r_temp.x, r_temp.y, 0);
			}else if(find =='2' || find =='5' || find =='8' || find =='0') {
				hands l_temp = bfs(left.x,  left.y, find, key);
				hands r_temp = bfs(right.x, right.y, find, key);
				System.out.print(l_temp.cnt+ " " + r_temp.cnt);
				if(l_temp.cnt > r_temp.cnt) {
					sb.append('R');
					right = new hands(r_temp.x, r_temp.y, 0);
				}else if(l_temp.cnt < r_temp.cnt) {
					sb.append('L');
					left = new hands(l_temp.x, l_temp.y, 0);
				}else {
					if(hand == "right") {
						sb.append('R');
						right = new hands(r_temp.x, r_temp.y, 0);
					}else {
						sb.append('L');
						left = new hands(l_temp.x, l_temp.y, 0);
					}
				}
			}
			System.out.println();
		}
		answer = sb.toString();
		System.out.println(answer);
		System.out.println("LRLLLRLLRRL");
		return answer;
	}
	public static hands bfs(int si, int sj, char target, char[][] key) {
		boolean[][] visited = new boolean[4][3];
		Queue<hands> q = new LinkedList<>();
		q.add(new hands(si,sj,0));
		visited[si][sj] = true;

		while(!q.isEmpty()) {
			hands h = q.poll();
			if(key[h.x][h.y] == target) {
				return h;
			}
			for(int k=0; k<4; k++) {
				int ni = h.x + di[k];
				int nj = h.y + dj[k];
				if(ni>=0 && ni<4 && nj>=0 && nj<3) {
					if(!visited[ni][nj]){
						q.add(new hands(ni,nj,h.cnt+1));
						visited[ni][nj] = true;
					}
				}
			}
		}
		return null;
	}
	public static class hands{
		int x, y, cnt;

		public hands(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}
