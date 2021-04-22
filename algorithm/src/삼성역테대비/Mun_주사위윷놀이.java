package 삼성역테대비;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mun_주사위윷놀이 {
	public static ArrayList<Integer>[] al;
	public static int[] timetable;
	public static int[] select;
	public static boolean[] used;
	public static int max = 0;
	public static horse[] h;
	public static Node start, end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		timetable = new int[10];
		for(int i=0; i<10; i++) {
			timetable[i] = sc.nextInt();
		}
		init();
		select = new int[10];
		permu(0);
		System.out.println(max);

	}
	public static void permu(int idx) {
		if(idx == 10) {
			max = Math.max(moving(),  max);
			return;
		}

		for(int i=0; i<4; i++) {
			select[idx] = i;
			permu(idx+1);
		}

	}

	public static int moving() {
		h = new horse[4];
		for(int i=0; i<4; i++) {
			h[i] = new horse(start,0);
		}

		int score = 0;
		
		for(int i=0; i<10; i++) {
			horse move_horse = h[select[i]];
			Node cur = move_horse.present;
			Node startn = move_horse.present;
			for(int j=0; j<timetable[i]; j++) {
				if(j ==0 && cur.hasFast) {
					cur = cur.fastNode;
				}else {
					cur = cur.next;
				}
			}
			if(!cur.isEmpty && !cur.isEnd) {
				move_horse.present = startn;
				score = 0;
				break;
			}else if(cur.isEnd) {
				startn.isEmpty = true;
				move_horse.present = cur;
			}else {
				startn.isEmpty = true;
				move_horse.present = cur;
				cur.isEmpty = false;
				score += cur.score;
			}
		}
		
		
		
		for(int i=0; i<4; i++) {
			h[i].present.isEmpty = true;
		}
		
		return score;


	}
	public static class Node{
		int  score;
		Node next, fastNode;
		boolean isEmpty, isEnd, hasFast;
		public Node(int score) {
			super();
			this.score = score;
			this.isEmpty = true;
		}

		public Node nextNode(int idx) {
			next = new Node(idx);
			return next;
		}
		public Node fastNode(int idx) {
			fastNode = new Node(idx);
			return fastNode;
		}
		public Node getNode(int target) {
			Node pre = start;
			while(true) {
				if(pre == null) {
					return null;
				}
				if(pre.score == target) {
					return pre;
				}
				pre = pre.next;
			}
		}
	}
	public static class horse{
		int sum;
		Node present;
		public horse(Node present, int sum) {
			super();
			this.present = present;
			this.sum = sum;
		}

	}

	public static void init() {
		start = new Node(0);

		Node temp = start;
		for(int i=2; i<=40; i+=2) {
			temp = temp.nextNode(i);
		}
		
		Node end = temp.nextNode(0);
		end.isEnd = true;
		end.next = end;
		
		Node centerNode = new Node(25);
		
		temp = centerNode.nextNode(30);
		temp = temp.nextNode(35);
		temp.next = temp.getNode(40);
		
		
		temp = start.getNode(10);
		temp.hasFast = true;
		temp = temp.fastNode(13);
		temp = temp.nextNode(16);
		temp = temp.nextNode(19);
		temp.next = centerNode;

		temp = start.getNode(20);
		temp.hasFast = true;
		temp = temp.fastNode(22);
		temp = temp.nextNode(24);
		temp.next = centerNode;


		temp = start.getNode(30);
		temp.hasFast = true;
		temp= temp.fastNode(28);
		temp = temp.nextNode(27);
		temp = temp.nextNode(26);
		temp.next = centerNode;
		// 윷놀이 판 만듬
	}
}
