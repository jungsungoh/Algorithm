package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mun_다항식계산 {
	static final int MOD = 998244353;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] t = new int[N+1];
			int[] a = new int[N+1];
			int[] b = new int[N+1];
			ArrayList<Long> al = new ArrayList<>();
			for(int i=2; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			long[] result = new long[N+1];
			result[0] = 1;
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				int arg = Integer.parseInt(st2.nextToken());
				result[1] = arg;
				for(int j=2; j<=N; j++) {
					if(t[j] == 1)
						result[j] = (result[a[j]]+result[b[j]])%MOD;
					else if(t[j] == 2)
						result[j] = (a[j] * result[b[j]])%MOD;
					else if(t[j] == 3)
						result[j] = (result[a[j]]*result[b[j]])%MOD;
				}
				al.add(result[N]);
			}
			System.out.print("#" + tc + " ");
			for(long q : al) {
				System.out.print(q + " ");
			}
			System.out.println();
		}
	}
	
	
}
