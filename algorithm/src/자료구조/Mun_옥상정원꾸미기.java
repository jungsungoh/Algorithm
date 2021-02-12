package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Mun_옥상정원꾸미기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Stack<Integer> st = new Stack<>();
		long cnt = 0;
		for(int i=0; i<n; i++) {
			while(!st.isEmpty() && st.peek() <= arr[i]) {
				st.pop();
			}
			st.push(arr[i]);
			cnt += st.size()-1;
		}
		System.out.println(cnt);
	}
}
// 순회하면서 스택에 넣는다. (0=>i)
// 맨위에 있는거보다 들어오는게 같거나 크면 작거나 빌떄까지 빼고 넣음
// 작으면 스택에 넣는다.
// 스택에서 나갈떄 idx랑 처음 idx 차이 -1;
