package 카카오2019;

import java.util.Stack;

public class Mun_크레인인형뽑기 {
	public static void main(String[] args) {
		int[][] board = 	{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(solution(board, moves));
	}
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> st = new Stack<>();
		Stack<Integer>[] boards = new Stack[board[0].length];
		for(int i=0; i<boards.length; i++) {
			boards[i] = new Stack<>();
		}
		for(int j=0; j<board[0].length; j++) {
			for(int i=board.length-1; i>=0; i--) {
				if(board[i][j] == 0) break;
				boards[j].add(board[i][j]);
			}
		}
		int cnt = 0;

		for(int i=0; i<moves.length; i++) {
			int position = moves[i]-1;
			
			if(st.isEmpty()) {
				if(!boards[position].isEmpty()) {
					int num = boards[position].pop();
					st.push(num);
				}
			}else {
				if(!boards[position].isEmpty()) {
					int num = boards[position].pop();
					int top = st.peek();
					if(top == num) {
						st.pop();
						cnt+=2;
					}else {
						st.push(num);
					}
				}
			}
		}
		answer = cnt;
		return answer;
	}
}
