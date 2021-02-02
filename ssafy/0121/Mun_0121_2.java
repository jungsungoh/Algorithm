import java.util.Scanner;

public class Mun_0121_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for(int tc = 0 ; tc<TC; tc++) {
			String[] input = new String[5];
			String result = "";
			int max = 0;
			for(int i=0; i< 5; i++){
				input[i] = sc.next();
				if(max <=input[i].length()) {
					max = input[i].length();
				}
			}
			for(int i=0; i<max; i++)	{
				for(int j=0; j<5; j++) {
					if(input[j].length() <= i){}
					else {
						result += input[j].charAt(i);
					}
				}
			}
			System.out.println("#" + (tc+1) + " " +result);
		}
	}
}
