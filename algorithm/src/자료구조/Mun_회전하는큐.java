package 자료구조;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Mun_회전하는큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			list.add(i);
		}
		int cnt = 0;
		for(int j=0; j<m; j++) {
			int num = sc.nextInt();
			if(list.indexOf(num)<=list.size()/2) {
				while(true) {
					int tmp = list.get(0);
					if(tmp == num) {
						list.removeFirst();
						break;
					}
					list.addLast(list.removeFirst());
					cnt++;
				}
			}else {
				while(true) {
					int tmp = list.get(0);
					if(tmp == num) {
						list.removeFirst();
						break;
					}
					list.addFirst(list.removeLast());
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
