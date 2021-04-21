package 삼성역테대비;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mun_주사위윷놀이 {
	public static ArrayList<Integer>[] al;
	public static int[] timetable;
	public static int[] select;
	public static boolean[][] used;
	public static mob[] mset;
	public static int max = 0;
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
			mset = new mob[4];
			for(int k=0; k<4; k++) {
				mset[k] = new mob(0,0,0,0);
			}
			used = new boolean[4][22];
			for(int i=0 ;i<10; i++) {
				if(mset[select[i]].isEnd ==0) {
					moving(mset[select[i]], timetable[i]);
				}
			}
			
			int sum = 0;
			for(int i=0; i<4; i++) {
				sum += mset[i].sum;
			}
			max = Math.max(sum,  max);
			System.out.println(max);
			return;
		}
		
		for(int i=0; i<4; i++) {
			select[idx] = i;
			permu(idx+1);
		}
		
	}
	
	public static void moving(mob m1, int cnt) {
		int tmp = m1.x;
		int tmpy = m1.y;
		int nj = m1.y + cnt;
		m1.y = nj;
		if(nj >= al[m1.x].size()) {
			m1.y = al[m1.x].size()-1;
			m1.isEnd = 1;
		}else if(al[m1.x].get(nj) == 10) {
			m1.x = 1;
			m1.y = 0;
		}else if(al[m1.x].get(nj) == 20) {
			m1.x = 2;
			m1.y = 0;
		}else if(al[m1.x].get(nj) == 30) {
			m1.x = 3;
			m1.y = 0;
		}
		// 만약 거기 이미 점거중. 원래 값으로 돌리기
		if(al[m1.x].get(m1.y) != 0 && used[m1.x][m1.y] ) {
			m1.x = tmp;
			m1.y = tmpy;
		}else { // 새로 가는곳이면 점거하고, 값 더하기.
			used[m1.x][m1.y]= true; 
			m1.sum += al[m1.x].get(m1.y);
		}
		
		
	}
	public static class mob{
		int x, y, sum, isEnd;
		public mob(int x, int y, int sum, int isEnd) {
			super();
			this.x = x;
			this.y = y;
			this.sum = sum;
			this.isEnd = isEnd;
		}
	}
	public static void init() {
		// 시작 -1 도착 -2
				int[] arr0 = {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,0};
				int[] arr1 = {10,13,16,19,25,30,35,40,0};
				int[] arr2 = {20,22,24,25,30,35,40,0};
				int[] arr3 = {30,28,27,26,25,30,35,40,0};
				al = new ArrayList[4];
				for(int i=0; i<4; i++) {
					if(i == 0) {
						al[i] = new ArrayList<>();
						for(int j=0; j<arr0.length; j++) {
							al[i].add(arr0[j]);
						}
					}else if(i == 1) {
						al[i] = new ArrayList<>();
						for(int j=0; j<arr1.length; j++) {
							al[i].add(arr1[j]);
						}
					}else if(i == 2) {
						al[i] = new ArrayList<>();
						for(int j=0; j<arr2.length; j++) {
							al[i].add(arr2[j]);
						}
					}else if(i == 3) {
						al[i] = new ArrayList<>();
						for(int j=0; j<arr3.length; j++) {
							al[i].add(arr3[j]);
						}
					}
				}
				// 윷놀이 판 만듬
	}
}
