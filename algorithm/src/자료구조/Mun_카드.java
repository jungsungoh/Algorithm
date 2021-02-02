package 자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun_카드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n ==1) {
			System.out.println(1);
			return;
		}
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=0; i<n; i++) {
			q.add(i+1);
		}
		while(true) {
			int num = q.poll();
			if(q.size() == 1) {
				break;
			}else {
				q.add(q.poll());
			}
		}
		System.out.println(q.poll());
	}
}
