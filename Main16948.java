import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(r1,c1,r2,c2,N));
	}
	static int[] dx = { -2, -2, 0, 0, 2, 2 };
	static int[] dy = { -1, 1, -2, 2, -1, 1 };

	static int bfs(int r1,int c1,int r2,int c2,int N) {
		
		if(r1==r2 && c1==c2) return 0;

		int[][] map = new int[N][N];
		boolean[][] visit = new boolean[N][N];
		
		visit[r1][c1] = true;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(r1,c1));
		
		int time = 0;
		boolean flag = false;
		Label : while(!q.isEmpty()) {
			int size = q.size();
			time++;
			for(int s=0;s<size;s++) {
				Pos p = q.poll();
				
				for(int i=0;i<6;i++) {
					int nx = p.x+dx[i];
					int ny = p.y+dy[i];
					
					if(nx>=0 && nx<N && ny>=0 && ny<N && !visit[nx][ny]) {
						if(r2 == nx && c2 == ny) {
							flag = true;
							break Label;
						}
						
						q.offer(new Pos(nx,ny));
						visit[nx][ny] = true;
					}
				}
			}
		}
		
		return flag?time:-1;
	}
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
}
