
import java.util.Scanner;

public class Mun_0121 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		for(int tc=0; tc< 10; tc++)
		{
			int TC = sc.nextInt();
			int[][] arr = new int[100][102];

			for(int i=0; i < 100; i++)
			{
				for(int j=1; j<101; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int start = -1;
			for(int i=0; i< 101; i++)
			{
				if(arr[99][i] == 2)
				{
					start = i;
				}
			}
			int hang = 99;
			while(hang >0)
			{
				if(arr[hang][start+1] == 1 )
				{
					while(arr[hang][start+1] != 0)
					{
						start+=1;
					}	
				}
				else if(arr[hang][start-1] == 1)
				{
					while(arr[hang][start-1] !=0)
					{
						start-=1;
					}
				}
				hang--;
			}
			int result = start-1;
			System.out.println("#" +(tc+1)+ " " +result);
		}
	}
}
