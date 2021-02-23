package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_계란으로계란치기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		egg[] eg = new egg[n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			eg[i] = new egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
	}
	public static void crush() {
		
	}
	public static class egg{
		int s, w;

		public egg(int s, int w) {
			super();
			this.s = s;
			this.w = w;
		}
	}
}

// 계란에는 내구도와 무게가 정해져있다. 
// 계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다. 
// 그리고 내구도가 0 이하가 되는 순간 계란은 깨지게 된다. 
// 예를 들어 계란 1의 내구도가 7, 무게가 5이고 계란 2의 내구도가 3, 무게가 4라고 해보자. 
// 계란 1으로 계란 2를 치게 되면 계란 1의 내구도는 4만큼 감소해 3이 되고 계란 2의 내구도는 5만큼 감소해 -2가 된다. 
// 충돌 결과 계란 1은 아직 깨지지 않았고 계란 2는 깨졌다.

// 유현이가 인범이에게 알려준 퍼즐은 일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제였다. 
// 구체적으로 계란을 치는 과정을 설명하면 아래와 같다.

// 1. 가장 왼쪽의 계란을 든다.
// 2. 손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다. 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다. 
// 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
// 3. 가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다. 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.

// 8
// 44 11
// 116 73
// 121 54
// 49 232
// 69 136
// 159 242
// 109 172
// 28 31