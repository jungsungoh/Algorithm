package 카카오2019;

import java.util.Arrays;

public class Mun_징검다리건너기 {
	public static void main(String[] args) {
		int k =3;
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		solution(stones, k);
	}
	public static int solution(int[] stones, int k) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0; i<stones.length; i++) {
			min = Math.min(min, stones[i]);
		}
		for(int i=0; i<stones.length; i++) {
			stones[i] -= min;
		}
		
		boolean ispossible = true;
		int cnt = min;
		while(ispossible) {
			int idx = -1;
			for(int i=0; i<stones.length; i++) {
				int flag = 0;
				for(int p=1; p<=k; p++) {
					int next = idx+p;
					if(next >= stones.length) {
						flag = 1;
						idx = stones.length;
						break;
					}else if(next < stones.length && stones[next] >= 1) {
						stones[next]--;
						flag = 1;
						idx = next;
						break;
					}
				}
				if(flag == 0) {
					ispossible = false;
					break;
				}
				i = idx;
			}
			if(ispossible) {
				cnt++;
			}
		}
		answer = cnt;
		System.out.println(cnt);
		return answer;
	}
}
// 징검다리는 일렬로 놓여 있고 각 징검다리의 디딤돌에는 
// 모두 숫자가 적혀 있으며 디딤돌의 숫자는 한 번 밟을 때마다 1씩 줄어듭니다.
// 디딤돌의 숫자가 0이 되면 더 이상 밟을 수 없으며 
// 이때는 그 다음 디딤돌로 한번에 여러 칸을 건너 뛸 수 있습니다.
// 단, 다음으로 밟을 수 있는 디딤돌이 여러 개인 경우 
// 무조건 가장 가까운 디딤돌로만 건너뛸 수 있습니다.


// 디딤돌에 적힌 숫자가 순서대로 담긴 배열 stones와 
// 한 번에 건너뛸 수 있는 디딤돌의 최대 칸수 k가 매개변수로 주어질 때,
// 최대 몇 명까지 징검다리를 건널 수 있는지 return 하도록 solution 함수를 완성해주세요.