import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3197 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		boolean[][] visit = new boolean[R][C];
		char[][] map = new char[R][C];
		int cnt = 0;
		Pos[] swan = new Pos[2];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			if (cnt < 2) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] == 'L') {
						swan[cnt++] = new Pos(i, j);
						map[i][j] = '.';
					}
				}
			}
		}
		// 초기 호수
		Queue<Pos> ice = new LinkedList<>();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] =='.' && !visit[i][j]) {
					visit[i][j] = true;
					
					for(int k=0;k<4;k++) {
						int nx = dx[k] +i;
						int ny = dy[k] +j;
						
						if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[nx][ny]) {
							if(map[nx][ny] =='X') {
								visit[nx][ny] = true;
								ice.offer(new Pos(nx,ny));
							}
						}
					}
				}
			}
		}
		
		bfs(map, visit, ice, swan);
		System.out.println(time);
	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static int R, C, time = 0;
	static Queue<Pos> sw = new LinkedList<>();
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static void bfs(char[][] map, boolean[][] visit, Queue<Pos> q, Pos[] swan) {
		//백조
		boolean[][] sVisit = new boolean[visit.length][visit[0].length];
		sw.offer(swan[0]);
		sVisit[swan[0].x][swan[0].y]= true;
		
		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			//빙하녹이기
			for (int s = 0; s < size; s++) {
				Pos p = q.poll();
				map[p.x][p.y] = '.';
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[nx][ny]) {
						visit[nx][ny] = true;
						q.offer(new Pos(nx, ny));
					}
				}
			}
			if (chk(map, swan[1],sVisit)) {	//백조가 만나는지확인			
				break;
			}

		}
	}

	static boolean chk(char[][] map, Pos to,boolean[][] visit) {
		Queue<Pos> tmp = new LinkedList<>();
		while (!sw.isEmpty()) {
			Pos p = sw.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C && !visit[nx][ny]) {
					
					if(nx==to.x && ny==to.y) {
						return true;
					}
					
					visit[nx][ny] = true;
					if(map[nx][ny] =='.') {
						sw.offer(new Pos(nx,ny));						
					}else {
						tmp.offer(new Pos(nx,ny));
					}
				}
			}

		}
		
		sw=tmp;
		
		return false;
	}
}
