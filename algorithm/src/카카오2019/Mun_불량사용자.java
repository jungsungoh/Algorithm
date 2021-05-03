package 카카오2019;

import java.util.Arrays;

public class Mun_불량사용자 {
	public static String[] result;
	public static boolean[] used;
	public static int answer = 0;
	public static void main(String[] args) {

		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		System.out.println(solution(user_id, banned_id));
	}

	public static int solution(String[] user_id, String[] banned_id) {
		result = new String[banned_id.length];
		used = new boolean[user_id.length];
		permu(0, user_id,banned_id);
		return answer;
	}
	public static void permu(int idx, String[] user_id,String[] banned_id) {
		if(idx == result.length) {
			System.out.println(Arrays.toString(result));
			check(banned_id);
			return;
		}
		
		
		for(int i=0; i<user_id.length; i++) {
			if(!used[i]) {
				used[i] = true;
				result[idx] = user_id[i];
				permu(idx+1, user_id,banned_id);
				used[i] = false;
			}
		}
	}
	public static void check(String[] user_id) {
		int cnt = 0;
		boolean[] use =new boolean[user_id.length];
		for(int i=0; i<user_id.length; i++) {
			for(int j=0; j<result.length; j++) {
				boolean isEqual = true;
				if(result[j].length() != user_id[i].length() || use[j]) break;
				for(int k=0; k<user_id[i].length(); k++) {
					if((user_id[i].charAt(k) != '*') && ( user_id[i].charAt(k) != result[j].charAt(k))) {
						isEqual = false;
						break;
					}
				}
				if(isEqual) {
					System.out.println(user_id[i] + " " + result[j]);
					use[j] = true;
					cnt++;
					break;
				}
			}
		}
		if(cnt == user_id.length) {
			answer++;
		}
		System.out.println(cnt);
	}
}
