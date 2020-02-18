import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
 
public class hw2 {
    static final long val = 1000000007;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC= Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {
            int num =Integer.parseInt(br.readLine());
            long sum = 0;
            for(int i=1; i<=num; i++) {
                sum+= pow(i,i);
            }
            System.out.println("#" + tc + " " +(sum%val));
        }
    }
    static long pow(int x, int n) {
        if (n==1) {
            return x;
        }
        if(n%2==0) {
            long y = pow(x,n/2);
            long result = (y%val)*(y%val)%val;
            return result;
        }
        else {
            long y = pow(x,(n-1)/2);
            long result =  (y%val)*(y%val)%val;
            long result2 = result*x%val;
            return result2;
        }
    }
     
}