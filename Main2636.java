import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2636 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[][] map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visit =new boolean[R][C];
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0));
		air(map,R,C,q);
		System.out.println(time);
		System.out.println(cnt);
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int cnt,time;
	static boolean[][] visit;

	static void air(int[][] map,int R,int C,Queue<Pos> q) {
		while(true) {
			
			Queue<Pos> ch = new LinkedList<>();
			while(!q.isEmpty()) {
				Pos p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[nx][ny]) {
						visit[nx][ny] = true;
						if(map[nx][ny] ==0) {
							
							q.offer(new Pos(nx,ny));
						}else {
							ch.offer(new Pos(nx,ny));
						}
						
					}
				}
			}
			if(ch.isEmpty()) {
				break;
			}
			q = cheese(map,R,C,ch);
			time++;
		}
		
	}
	
	static Queue<Pos> cheese(int[][] map,int R,int C,Queue<Pos> q) {	
		cnt = 0;
		Queue<Pos> a = new LinkedList<>();
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(map[p.x][p.y]==1 ) {
				cnt++;
				map[p.x][p.y]= 0; 
			}
			a.offer(p);
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[nx][ny]) {
					if(map[nx][ny] ==0) {
						visit[nx][ny] = true;
						q.offer(new Pos(nx,ny));
					}
					
				}
			}
		}
		
		return a;
	}

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

}
