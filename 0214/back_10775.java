import java.util.Scanner;

public class back_10775 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		int p = sc.nextInt();
		
		int[] arr = new int[g+1];
		int cnt = 0;
		for(int i=0; i<p; i++) {
			int flag = 0;
			int p1 = sc.nextInt();
			if(arr[p1] == 0) {
				arr[p1] = p1;
				flag = 1;
				cnt++;
			}
			else {
				for(int j=p1-1; j>=1; j--) {
					if(arr[j] == 0) {
						arr[j] = p1;
						flag = 1;
						cnt++;
						break;
					}
				}
			}
			if(flag == 0) {
				break;
			}
		}
		System.out.println(cnt);
	}
}