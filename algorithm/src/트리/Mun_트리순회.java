package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Mun_트리순회 {
	public static int[] lc, rc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		lc = new int[n+1];
		rc = new int[n+1];
		int[] parents = new int[n+1];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = st.nextToken().charAt(0) -'A' +1;
			char leftchild = st.nextToken().charAt(0);
			char rightchild = st.nextToken().charAt(0);
			lc[idx] = leftchild=='.'?0:leftchild-'A'+1;
			rc[idx] = rightchild=='.'?0:rightchild-'A'+1;
		}
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
	}
	public static void preorder(int idx) {

		System.out.print((char)(idx+'A'-1));
		if(lc[idx] !=0) preorder(lc[idx]);
		if(rc[idx] != 0) preorder(rc[idx]);
	}
	public static void inorder(int idx) {

		if(lc[idx] !=0) inorder(lc[idx]);
		System.out.print((char)(idx+'A'-1));
		if(rc[idx] != 0) inorder(rc[idx]);
	}
	public static void postorder(int idx) {

		if(lc[idx] !=0) postorder(lc[idx]);
		if(rc[idx] != 0) postorder(rc[idx]);
		System.out.print((char)(idx+'A'-1));
	}
}
