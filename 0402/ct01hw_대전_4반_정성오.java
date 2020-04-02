package swexpert;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Mun_조합 {
	static long[] factorial;
	static final int mod = 1234567891;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc=1 ;tc<=TC; tc++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			factorial = new long[n+1];
			factorial[0] = 1;
			facto(n);
            //System.out.println(Arrays.toString(fac));
			long p = factorial[n];
			long p2 = (factorial[n-r]*factorial[r])%mod;
			long result = (p*pow(p2, 1234567889))%mod;
			System.out.println("#" + tc+ " " + result);
		}
	}
	static long facto(int k) {
        if(k==1 || k== 0) 
        	return 1;
        else if(factorial[k] != 0) 
        	return factorial[k];
        else
            return factorial[k] = (k*facto(k-1))%mod;
    }
	static long pow(long n, int x) {
		if(x==0) return 1;
		long tmp = pow(n,x/2);
		long val = (tmp*tmp)%mod;
		if(x%2 ==0) 
			return val;
		else 
			return (val *n) % mod;
	}
}
