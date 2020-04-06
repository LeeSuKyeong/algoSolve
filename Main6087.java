import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6087 {
	static char[][] map;
	static int[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};//nwse
	static int W,H,cnt = Integer.MAX_VALUE-1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int sx=-1,sy=-1,ex=-1,ey=-1;
		map = new char[H][W];
		visit = new int[H][W];

		for(int i=0;i<H;i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(visit[i], Integer.MAX_VALUE-1);
				for(int j=0;j<W;j++) {
					if(map[i][j] =='C') {
						if(sx ==-1 && sy ==-1) {
							sx = i;
							sy = j;
						}else if(sx !=-1 && sy != -1){
							ex =i;
							ey = j;
						}
					}
				}
		}
		bfs(sx,sy,ex,ey);

		System.out.println(visit[ex][ey]-1);
	}

	static void bfs(int x, int y,int ex,int ey) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(x,y,-1,0));
		visit[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.x == ex && p.y== ey) {//도착점이면 (map[x][y] = c로 하면 초기지점도 가버린당
				if(p.cnt <visit[ex][ey]) {
					visit[ex][ey] = p.cnt;
				}
				continue;
			}
			for(int i=0;i<4;i++) {
				int nx =p.x+dx[i];
				int ny =p.y+dy[i];

				if(nx>=0 && ny>=0 && nx<H && ny<W && map[nx][ny] != '*') {
					if(p.dir == i) {
						if(p.cnt<=visit[nx][ny]) {
							visit[nx][ny] = p.cnt;
							q.offer(new Pos(nx,ny,i,p.cnt));
						}
					}else {
						if(p.cnt+1<=visit[nx][ny]) {
							visit[nx][ny] = p.cnt+1;
							q.offer(new Pos(nx,ny,i,p.cnt+1));
						}
					}
				}
			}
		}
	}
	static class Pos{
		int x,y,dir,cnt;

		public Pos(int x, int y, int dir,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cnt = cnt;
		}

	}
}
