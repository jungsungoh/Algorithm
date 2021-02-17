package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mun_트럭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int w = Integer.parseInt(l1.split(" ")[2]);
		int l = Integer.parseInt(l1.split(" ")[1]);
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Queue<truck> bridge = new LinkedList<>();
		int next = 0, time = 0;
		while(true) {
			
			int sum = 0;
			int size = bridge.size();
			if(next ==n && size == 0) {
				break;
			}
			System.out.println(time+ "초");
			if(next < n && arr[next]+sum <= w && size+1 <= l ) {
				sum+= arr[next];
				bridge.add(new truck(1,arr[next++]));
			}
			time++;
			System.out.println("==================");
		}
		System.out.println(time);
	}
	
	public static class truck{
		int length, weight;

		public truck(int length, int weight) {
			super();
			this.length = length;
			this.weight = weight;
		}
		
	}
}
