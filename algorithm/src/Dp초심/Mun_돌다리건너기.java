package Dp초심;

public class Mun_돌다리건너기 {
	public static void main(String[] args) {
		String s  = "RGS";
		char[][] arr = {{'R','I','N','G','S','R'},{'G','R','G','G','N','S'}};

		int n = arr.length;
		int[][][] d = new int[n][n][s.length()];

		for(int i=0; i<2; i++) {
			for(int j=0; j<arr[0].length; j++) {

				if(arr[i][j] == s.charAt(0)){
					for(int k =j+1; k<n; k++) {
						if( i == 0) {
							d[i+1][k][0] = 1;
						}else {
							d[i-1][k][0] = 1;
						}
					}
				}
			}
		}

		for(int i=1; i<s.length(); i++) {
			char ch  =s.charAt(i);

		}

	}
}
