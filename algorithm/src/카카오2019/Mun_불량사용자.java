package 카카오2019;

public class Mun_불량사용자 {
	public static void main(String[] args) {

		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"*rodo", "*rodo", "******"};
		System.out.println(solution(user_id, banned_id));
	}

	public static int solution(String[] user_id, String[] banned_id) {
		int answer = 1;
		for(int j=0; j<banned_id.length; j++) {
			int result = 0;
			for(int i=0; i<user_id.length; i++) {
				if(!check(user_id[i], banned_id[j])) {
					System.out.println(user_id[i] + " " + banned_id[j]);
					result++;
				}
			}
			System.out.println("===========");
			answer *=result;
		}
		return answer;
	}

	// ban id인지 아닌지 판단. 밴아니면 트루, 밴이면 펄스
	public static boolean check(String id, String ban) {
			if(ban.length() != id.length()) return true;
			for(int j=0; j<id.length(); j++) {
				char ch = id.charAt(j);
				if(ch!=ban.charAt(j) && ban.charAt(j) != '*') {
					// 밴아이디아님.
					return true;
				}
			}
			return false;
	}
}
