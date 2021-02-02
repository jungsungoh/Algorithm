import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class Solution {
    static boolean[] visited;
    static int[][] arr;
    static int result=0;
    static int[] arr2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int tc=1; tc<=10;tc++) {
            result = 0;
            int n2 = sc.nextInt();
            int n = n2/2;
            int st = sc.nextInt();
            visited = new boolean[101];
            arr= new int[101][101];
            arr2 = new int[101];
            for(int i=0; i<n; i++) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                arr[v1][v2] = 1;
            }
            bfs(st);
            int max = 0;
            for(int i=0; i<101; i++) {
                if(max <arr2[i]) {max = arr2[i];}
            }
            for(int i=0; i<101; i++) {
                if(arr2[i] == max) {
                    result = i;
                }
            }
            System.out.println("#" +tc + " " + result);
             
        }
    }
    static void bfs(int st) {
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        int dist = 1;
        visited[st] = true;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int s= 0; s<size; s++) {
                int num = q.poll();
                arr2[num] = dist;
                for(int i=1; i<=100; i++) {
                    if(arr[num][i] == 1 && !visited[i]) {
                        q.add(i);   
                        visited[i] = true;
                    }
                }
            }
            dist++;
        }
    }
}