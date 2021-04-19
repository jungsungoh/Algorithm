package 삼성역테대비;

import java.util.Scanner;

public class Mun_컨베이어벨트위의로봇 {
	public static int n, k;
	public static int[] belt, power;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt(); // 내구도 0 개수
		belt = new int[n];
		power = new int[2*n];
		
		for(int i=0; i<2*n; i++) {
			power[i] = sc.nextInt();
		}
		
		
		int time = 1;
		while(true) {
			// 1. 벨트한칸회전
			int tmp = power[power.length-1]; 
			for(int i=power.length-1; i>0; i--) {
				power[i] = power[i-1];
			}
			power[0] = tmp;
			// 1-1. 로봇도 같이 회전
			for(int i=belt.length-1; i>0; i--) {
				belt[i] = belt[i-1];
			}
			belt[0] = 0;
			
			belt[belt.length-1] = 0;
			for(int i=belt.length -1 ; i>0; i--) {
				if(belt[i-1] ==1 && belt[i] ==0 && power[i] >=1) {
					belt[i] = 1;
					belt[i-1] = 0;
					power[i]--;
				}
			}
			
			if(power[0] >=1) {
				belt[0] = 1;
				power[0]--;
			}
			int cnt = 0;
			for(int i=0; i<power.length; i++) {
				if(power[i] == 0) {
					cnt++;
				}
				if(cnt >=k) {
					System.out.println(time);
					return;
				}
			}
			time++;
		}
		
	}
}
