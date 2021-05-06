package 카카오2019;

import java.util.Arrays;

public class Mun_불량사용자 {
	public static String[] result;
	public static boolean[] used;
	public static int answer = 0;
	public static void main(String[] args) {

		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id ={"fr*d*", "*rodo", "******", "******"};
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
			check(banned_id);
			return;
		}
		
		for(int i= 0; i<user_id.length; i++) {
			if(!used[i]) {
				used[i] = true;
				result[idx] = user_id[i];
				permu(idx+1, user_id, banned_id);
				used[i] =false;
			}
		}
	}
	
	public static void check(String[] user_id) {
		int cnt = 0;
		boolean[] use =new boolean[user_id.length];
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(user_id));
		for(int i=0; i<result.length; i++) {
			for(int j=0; j<user_id.length; j++) {
				if(result[i].length() != user_id[j].length() || use[j]) continue;
				boolean check = true;
				for(int k=0; k<result[i].length(); k++) {
					if(result[i].charAt(k) != user_id[j].charAt(k) && user_id[j].charAt(k) != '*') {
						check = false;
						break;
					}
				}
				if(check) {
					cnt++;
					use[j] = true;
					break;
				}
			}
		}
		if(cnt == user_id.length) {
			System.out.println("dd");
			answer++;
		}
	}
}
