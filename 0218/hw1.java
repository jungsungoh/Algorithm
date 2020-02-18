import java.util.Scanner;
 
public class hw1 {
    static point[] p1,result;
    static boolean[] visited;
    static int n,min;
    static point st, end;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int tc=1; tc<=TC; tc++) {
            n = sc.nextInt();
            min = 9999999;
            p1 = new point[n];
            result = new point[n];
            visited= new boolean[n];
            st = new point(sc.nextInt(), sc.nextInt());
            end = new point(sc.nextInt(), sc.nextInt());
            for(int i=0; i<n; i++) {
                p1[i]= new point(sc.nextInt(), sc.nextInt());
            }
            check(0);
            System.out.println("#" + tc + " " +min);
        }
    }
    static void check(int idx) {
        if(idx == result.length) {
            int sum =dist(st,result[0]);
            for(int i=0; i<result.length-1; i++) {
                sum += dist(result[i],result[i+1]);
            }
            sum+= dist(result[result.length-1],end);
            if(sum<min) {
                min = sum;
            }
            return ;
        }
        for(int i=0; i<p1.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[idx] = p1[i];
                check(idx+1);
                visited[i] = false;
            }
        }
    }
    static int dist(point a, point b) {
        int all = Math.abs(b.x-a.x) + Math.abs(b.y-a.y);
        return all;
    }
    static class point{
        int x, y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}