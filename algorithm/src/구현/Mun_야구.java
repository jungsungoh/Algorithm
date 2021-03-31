package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Mun_야구 {
	public static int n, solution;
	public static boolean[] used;
	public static int[] result , man = {2,3,4,5,6,7,8,9};
	public static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1][10];
		result = new int[9];
		used = new boolean[8];
		for(int j=1; j<=n; j++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<10;i++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		permu(0);
		System.out.println(solution);
	}
	public static void permu(int idx) {
		if(result.length == idx) {
			lineup();
			return;
		}
		if(idx == 3) {
			result[idx] = 1;
			permu(idx+1);
		}else {
			for(int i=0; i<8; i++) {
				if(!used[i]) {
					used[i] = true;
					result[idx] = man[i];
					permu(idx+1);
					used[i] = false;
				}
			}
		}
	}
	public static void lineup() {
		
		int target = 0;
		int sum = 0;
		for(int i=1; i<=n; i++) {
			boolean[] ru = new boolean[4];
			int cnt = 0;
			while(cnt<3) {
				int score = arr[i][result[target]];
				ru[0] = true;
				switch(score) {
				case 1:
				case 2:
				case 3:
				case 4:
					for(int k=3; k>=0; k--) {
						if(ru[k]) {
							if(k+score > 3) {
								sum+=1;
								ru[k] = false;
							}else {
								ru[k+score] = true;
								ru[k] = false;
							}
						}
					}
					break;
				case 0:
					cnt++;
					ru[0] = false;
					break;
				}
				target = (target+1)%9;
			}
		}
		solution = Math.max(solution, sum);
	}
}
// ⚾는 9명으로 이루어진 두 팀이 공격과 수비를 번갈아 하는 게임이다. 하나의 이닝은 공격과 수비로 이루어져 있고, 총 N이닝 동안 게임을 진행해야 한다.
// 한 이닝에 3아웃이 발생하면 이닝이 종료되고, 두 팀이 공격과 수비를 서로 바꾼다.


// 두 팀은 경기가 시작하기 전까지 타순(타자가 타석에 서는 순서)을 정해야 하고, 경기 중에는 타순을 변경할 수 없다. 


// 9번 타자까지 공을 쳤는데 3아웃이 발생하지 않은 상태면 이닝은 끝나지 않고, 
// 1번 타자가 다시 타석에 선다. 타순은 이닝이 변경되어도 순서를 유지해야 한다. 
// 예를 들어, 2이닝에 6번 타자가 마지막 타자였다면, 3이닝은 7번 타자부터 타석에 선다.

// 공격은 투수가 던진 공을 타석에 있는 타자가 치는 것이다.

// 공격 팀의 선수가 1루, 2루, 3루를 거쳐서 홈에 도착하면 1점을 득점한다.
// 타자가 홈에 도착하지 못하고 1루, 2루, 3루 중 하나에 머물러있을 수 있다. 루에 있는 선수를 주자라고 한다. 이닝이 시작될 때는 주자는 없다.


// 타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃 중 하나이다. 각각이 발생했을 때, 벌어지는 일은 다음과 같다.

// 안타: 타자와 모든 주자가 한 루씩 진루한다.
// 2루타: 타자와 모든 주자가 두 루씩 진루한다.
// 3루타: 타자와 모든 주자가 세 루씩 진루한다.
// 홈런: 타자와 모든 주자가 홈까지 진루한다.
// 아웃: 모든 주자는 진루하지 못하고, 공격 팀에 아웃이 하나 증가한다.

// 한 야구팀의 감독 아인타는 타순을 정하려고 한다. 아인타 팀의 선수는 총 9명이 있고, 1번부터 9번까지 번호가 매겨져 있다.


// 아인타는 각 선수가 각 이닝에서 어떤 결과를 얻는지 미리 알고 있다. 
// 가장 많은 득점을 하는 타순을 찾고, 그 때의 득점을 구해보자.