package 카카오2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Mun_호텔방배정 {
	public static void main(String[] args) {
		int k = 10;
		long[] room_number = {1,3,4,1,3,1};
		solution(k, room_number);
	}
	public static long[] solution(long k, long[] room_number) {
		long[] answer = {};
		long[] result = new long[room_number.length];
		Map<Long, Integer> m = new HashMap<>();
		for(int i=0; i<room_number.length; i++) {
			if(m.containsKey(room_number[i])) {
				long idx = m.get(room_number[i]);
				while(true) {
					if(m.containsKey(idx+1)) {
						idx += m.get(idx+1);
						System.out.println(idx);
					}else {
						m.put(room_number[i], m.get(room_number[i])+1);
						result[i] = room_number[i];
						break;
					}
				}

			}else {
				m.put(room_number[i], 1);
				result[i] = room_number[i];
			}
		}
		System.out.println(Arrays.toString(result));
		return result;
	}
}
