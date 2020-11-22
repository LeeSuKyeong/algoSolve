import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4485 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		int tc = 0;
		while ((N = Integer.parseInt((br.readLine()))) != 0) {
			tc++;
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem ").append(tc).append(": ").append(bfs(map, N)).append('\n');
		}
		System.out.println(sb);
	}
	static class Info implements Comparable<Info>{
		int x,y,d;

		public Info(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Info o) {
			return this.d-o.d;
		}
		
		
	}
	static int bfs(int[][] map, int N) {
		int[][] dist= new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		PriorityQueue<Info> q = new PriorityQueue<>();
		q.offer(new Info(0,0,map[0][0]));
		
		while (!q.isEmpty()) {
			Info p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if (nx >= 0 && ny >= 0 && nx < N && ny < N ) {
					if( dist[nx][ny]>p.d+map[nx][ny]) {
						dist[nx][ny] = p.d+map[nx][ny];
						q.offer(new Info(nx,ny,dist[nx][ny]));
					}
				}
			}
			
		}

		return dist[N-1][N-1];
	}
}
