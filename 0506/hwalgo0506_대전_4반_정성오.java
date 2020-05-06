package online;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Mun_월드컵 {
	static int[] game1 = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
    static int[] game2 = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };
    static int[][] game,arr;
    static int flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int tc=0; tc<4; tc++) {
			flag = 0;
			arr = new int[6][3];
			game = new int[6][3];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<6; i++) {
				for(int j=0; j<3; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0);
			bw.append(flag + " ");
		}
		bw.flush();
	}
	static void dfs(int game_su) {
		if(game_su == 15) {
			if(flag == 0) { 
			for (int i = 0; i < 6; i++) {
                 for (int j = 0; j < 3; j++)
                     if (arr[i][j] != game[i][j])
                         return;
			 }
				flag = 1;
				return;
			}else {
				return;
			}
		}
		int t1 = game1[game_su];
        int t2 = game2[game_su];

        game[t1][0]++;
        game[t2][2]++;
        dfs(game_su + 1);
        game[t1][0]--;
        game[t2][2]--;

        game[t1][1]++;
        game[t2][1]++;
        dfs(game_su + 1);
        game[t1][1]--;
        game[t2][1]--;

        game[t1][2]++;
        game[t2][0]++;
        dfs(game_su+ 1);
        game[t1][2]--;
        game[t2][0]--;

	}
}
