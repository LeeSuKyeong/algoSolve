import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012 {
	static boolean[][] map ,visit;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new boolean[N][M];
			visit = new boolean[N][M];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[y][x] = true;
			}
			
			int cnt =0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j] && !visit[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}

	}
	
	
	static void bfs(int x, int y) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx= p.x+dx[i];
				int ny= p.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] && !visit[nx][ny]) {
					q.offer(new Pos(nx,ny));
					visit[nx][ny] = true;
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
