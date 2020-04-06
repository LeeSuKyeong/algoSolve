import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4963 {
	static int[] dx = {-1,0,1,0,-1,-1,1,1};
	static int[] dy = {0,-1,0,1,-1,1,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) {
				break;
			}
			
			int[][] map = new int[h][w];
			boolean[][] visit  = new boolean[h][w];
			for(int i=0;i<h;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<w;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<h;i++) {
				for(int j=0;j<w;j++) {
					if(!visit[i][j] && map[i][j] == 1) {
						bfs(i,j,visit,map,w,h);
						count++;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	static void bfs(int x, int y,boolean[][] visit,int[][] map,int w, int h) {
		
		Queue<Pos> q = new LinkedList<>();
		
		visit[x][y] = true;
		q.offer(new Pos(x,y));

		while(!q.isEmpty()) {
			
			Pos p = q.poll();
			
			for(int i=0;i<8;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<h && ny<w && map[nx][ny] == 1 && !visit[nx][ny]) {
					q.offer(new Pos(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}
	}
	
}
