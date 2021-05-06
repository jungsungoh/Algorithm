package 카카오2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Mun_튜플 {
	public static void main(String[] args) {
		
		
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
		solution(s);
	}
	public static int[] solution(String s) {
        int[] answer = {};
        s = s.substring(1, s.length()-1);
        
        int start = 0, end = 0;
        ArrayList<String> al = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
        	char ch = s.charAt(i);
        	if(ch == '{') {
        		start = i;
        	}
        	if(ch == '}') {
        		end = i;
        		al.add(s.substring(start+1, end));
        		start = i+1;
        	}
        }
        Collections.sort(al, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1.length(),o2.length());
			}
		});
        Set<Integer> set = new LinkedHashSet<>();
        
        for(int i=0; i<al.size(); i++) {
        	StringTokenizer val = new StringTokenizer(al.get(i),",");
        	while(val.hasMoreTokens()) {
        		int num = Integer.parseInt(val.nextToken());
        		set.add(num);
        	}
        }
        
        answer = new int[set.size()];
        int idx = 0;
        for(Integer x : set) {
        	answer[idx++] = x;
        }
        return answer;
    }
}
