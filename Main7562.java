import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7562 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] dx = {1,2,2,1,-1,-2,-2,-1};
		int[] dy = {-2,-1,1,2,2,1,-1,-2};
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			
			int I = Integer.parseInt(br.readLine());
			boolean[][] visit = new boolean[I][I];
			
			st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int nx = Integer.parseInt(st.nextToken());
			int ny = Integer.parseInt(st.nextToken());
			
			//bfs
			Queue<Pos> q = new LinkedList<Pos>();
			q.offer(new Pos(cx,cy,0));
			visit[cx][cy] = true;
			Pos p = null;
			while(!q.isEmpty()) {
				p = q.poll();
				if(p.x==nx && p.y==ny) {
					break;
				}
				for(int i=0;i<8;i++) {
					int nnx = p.x+dx[i];
					int nny = p.y+dy[i];
					
					if(nnx>=0 && nnx<I && nny>=0 && nny<I && !visit[nnx][nny]) {
						
						visit[nnx][nny] = true;
						q.offer(new Pos(nnx,nny,p.cnt+1));
					}
				}
			}
			System.out.println(p.cnt);
		}
	}
	
	static class Pos{
		int x;
		int y;
		int cnt;
		public Pos(int x, int y,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

}
