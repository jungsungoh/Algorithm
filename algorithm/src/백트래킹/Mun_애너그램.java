package 백트래킹;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Mun_애너그램 {
	public static boolean[] used;
	public static char[] result;
	public static ArrayList<Character> al;
	public static Set<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		set = new TreeSet<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return Integer.compare(o1.length(), o2.length());
			}
		});
		for(int i=0; i<n; i++) {
			String s = sc.next();
			al = new ArrayList<>();
			for(int j=0; j<s.length(); j++) {
				al.add(s.charAt(j));
			}
			result = new char[al.size()];
			used = new boolean[al.size()];
			permu(0);
		}
		for(String s : set) {
			System.out.println(s);
		}
	}
	public static void permu(int idx) {
		if(result.length == idx) {
			String val = "";
			for(int i=0; i<result.length;i++) {
				val += result[i];
			}
			set.add(val);
			return;
		}
		
		
		for(int i=0; i<al.size(); i++) {
			if(!used[i]) {
				used[i] = true;
				result[idx] = al.get(i);
				permu(idx+1);
				used[i] = false;
			}
		}
	}
}	 
