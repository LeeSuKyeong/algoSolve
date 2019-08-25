import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7733 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int[][] map;
	static boolean[][] visit;
	static int N,k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				st =new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int result =1;
			k=1;
			while(k<=100) {
				int cnt =0;
				visit =new boolean[N][N];
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(map[i][j] >k && !visit[i][j]) {
							bfs(i,j);
							cnt++;
						}
					}
				}
				if(result<cnt) {
					result = cnt;
				}
				k++;
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void bfs(int x,int y) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N && map[nx][ny]>k && !visit[nx][ny]) {
					visit[nx][ny] =true;
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
