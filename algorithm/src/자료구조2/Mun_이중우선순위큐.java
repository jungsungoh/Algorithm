package 자료구조2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Mun_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			int n = Integer.parseInt(br.readLine());

			TreeMap<Integer, Integer> m = new TreeMap<>();
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int value = Integer.parseInt(st.nextToken());
				if(command.equals("I")) {
					m.put(value, m.getOrDefault(value, 0)+1);
				}else if(command.equals("D")) {
					if(value == -1) {
						if(m.size() !=0) {
							int min = m.firstKey();
							if(m.get(min) == 1) {
								m.remove(min);
							}else {
								m.put(min, m.get(min)-1);
							}
						}
					}else if(value == 1) {
						if(m.size() !=0) {
							int max = m.lastKey();
							if(m.get(max) == 1) {
								m.remove(max);
							}else {
								m.put(max, m.get(max)-1);
							}
						}
					}
				}
			}
			if(m.isEmpty()) {
				System.out.println("EMPTY");
			}else if(m.size() == 1){
				System.out.println(m.firstKey() + " " + m.firstKey());
			}else {
				System.out.println(m.lastKey() + " " + m.firstKey());
			}
		}
	}
}
