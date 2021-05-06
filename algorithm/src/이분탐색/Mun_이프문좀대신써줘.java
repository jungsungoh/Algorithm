package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Mun_이프문좀대신써줘 {
	public static void main(String[] args) throws IOException {


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l1 = br.readLine();
		int n = Integer.parseInt(l1.split(" ")[0]);
		int m = Integer.parseInt(l1.split(" ")[1]);
		Map<Integer,String> map = new HashMap<>();

		for(int i=0; i<n; i++) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			String key = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if(!map.containsKey(num)) {
				map.put(num, key);
			}
		}

		int[] arr = new int[m];

		for(int i=0; i<m; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		Arrays.sort(arr);
		int idx = 0;
		for(Integer num : map.keySet()) {
			String key = map.get(num);
			int upper = upperbound(arr, num);
			for(int i=idx; i<upper; i++) {
				System.out.println(key);
			}
			idx = upper;
		}
	}
	public static int upperbound(int[] arr, int target) {

		int start = 0, end = arr.length;
		while(start< end) {
			int mid = (start + end) / 2;

			if(arr[mid] > target) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		return start;
	}
}
