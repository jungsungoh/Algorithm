package day0210;

import java.util.Scanner;

public class Mun_jun {
	static char[][] arr;
	static int n1, n2;
	static int si, sj;
	static char dir;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC= sc.nextInt();
		for(int tc=1; tc<=TC; tc++) {
			n1= sc.nextInt();
			n2 = sc.nextInt();
			arr= new char[n1][n2];
			for(int i=0; i<n1; i++)
			{
				String s = sc.next();
				for(int j=0; j<n2; j++)
				{
					arr[i][j] = s.charAt(j);
				}
			}
			si =0;
			sj = 0;
			for(int i=0; i<n1; i++)
			{
				for(int j=0; j<n2; j++)
				{
					if(arr[i][j] == '<' || arr[i][j] == '>' || arr[i][j] == '^' || arr[i][j] == 'v') {
						si = i;
						sj = j;
						dir = arr[i][j];
						arr[i][j] = '.';
					}
				}
			}
			int s_size = sc.nextInt();
			String s2 = sc.next();
			char[] arr2 = new char[s_size];
			for(int i=0; i<s2.length(); i++) {
				char ch = s2.charAt(i);
				command(ch,si,sj);
			}
			arr[si][sj] = dir;
			System.out.print("#" + tc + " ");
			print();
		}
		
	}
	// * : 벽돌, . : 평지, # : 강철, - : 물,
	public static void command(char a,int i, int j) {
		switch(a) {
		case 'L':
			dir = '<';
			if(j-1 >=0) {
				if(arr[i][j-1] == '.') {
					si = i;
					sj = j-1;
					arr[i][j] = '.';
					arr[i][j-1] = '<';
				}
				else if(arr[i][j-1] == '*') {
					arr[i][j] = '<';
				}
			}
			break;
		case 'R':
			dir = '>';
			if(j+1 <n2) {
				if(arr[i][j+1] == '.') {
					si = i;
					sj = j+1;
					arr[i][j] = '.';
					arr[i][j+1] = '>';
				}
				else if(arr[i][j+1] == '*') {
					arr[i][j] = '>';
				}
			}
			break;
		case 'U':
			dir = '^';
			if(i-1 >=0) {
				if(arr[i-1][j] == '.') {
					si = i-1;
					sj = j;
					arr[i][j] = '.';
					arr[i-1][j] = '^';
				}
				else if(arr[i-1][j] == '*') {
					arr[i][j] = '^';
				}
				
			}
			break;
		case 'D':
			dir = 'v';
			if(i+1 <n1) {
				if(arr[i+1][j] == '.') {
					si = i+1;
					sj = j;
					arr[i][j] = '.';
					arr[i+1][j] = 'v';
				}
				else if(arr[i+1][j] == '*') {
					arr[i][j] = 'v';
				}
			}
			break;
		case 'S':
			if(dir == '>')
			{
				while( j <n2 && arr[i][j] != '*' ) {
					if(arr[i][j] == '#') {break;}
					j++;
				}
				if(j <n2) {
					if(arr[i][j] == '*') {
						arr[i][j] = '.';
					}
				}
			}
			else if(dir == '<') {
				while( j >=0 && arr[i][j] != '*' ) {
					if(arr[i][j] == '#') {break;}
					j--;
				}
				if(j >=0) {
					if(arr[i][j] == '*') {
						arr[i][j] = '.';
					}
				}
			}
			else if(dir == '^') {
				while( i >=0 && arr[i][j] != '*' ) {
					if(arr[i][j] == '#') {break;}
					i--;
				}
				if(i >=0) {
					if(arr[i][j] == '*') {
						arr[i][j] = '.';
					}
				}
			}
			else if(dir == 'v') {
				while( i <n1 && arr[i][j] != '*' ) {
					if(arr[i][j] == '#') {break;}
					i++;
				}
				if(i<n1) {
					if(arr[i][j] == '*') {
						arr[i][j] = '.';
					}
				}
				
			}
			break;
		}
	}
	public static void print() {
		for(int i=0; i<n1; i++) {
			for(int j=0; j<n2; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
