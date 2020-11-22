import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1952 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int dir = 0;
		boolean[][] visit =new boolean[M][N];
		int cnt =0;
		int x = 0,y=0;
		while(true) {
			if(visit[x][y]) {
				break;
			}
			visit[x][y] =true;
			x+=dx[dir];
			y+=dy[dir];
			
			if(x<0 || y<0 || x==M || y==N || visit[x][y]) {
				x-=dx[dir];
				y-=dy[dir];
				dir=(dir+1)%4;
				x+=dx[dir];
				y+=dy[dir];
				cnt++;
			}
		}
		System.out.println(cnt-1);
	}
}
