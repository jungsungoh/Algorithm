package 자료구조;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun_요세푸스문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<n; i++) {
			q.add(i+1);
		}
		int cnt = 0;
		ArrayList<Integer> al = new ArrayList<>();
		while(!q.isEmpty()) {
			cnt++;
			int num = q.poll();
			if(cnt == k) {
				al.add(num);
				cnt = 0;
			}else {
				q.add(num);
			}
		}
		System.out.print("<");
		for(int i=0; i<al.size()-1; i++) {
			System.out.print(al.get(i) + ", ");
		}
		System.out.println(al.get(al.size()-1)+">");
		
		
	}
}
