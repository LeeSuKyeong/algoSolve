import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3187 {

	static char[][] map;
	static boolean[][] visit;
	static int R,C, kNum = 0, vNum = 0;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visit[i][j] && map[i][j] == 'v' | map[i][j] == 'k') {
					bfs(i, j);
				}
			}
		}
		System.out.println(kNum + " " + vNum);
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
	static void bfs(int x, int y) {
		int nx, ny;
		int kn = 0, vn = 0;

		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(x,y));
		visit[x][y] = true;

		if (map[x][y] == 'k') {
			kn++;
		} else {
			vn++;
		}

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				nx = p.x+ dx[i];
				ny = p.y + dy[i];
				if (nx>=0 && ny>=0 && nx<R && ny<C && !visit[nx][ny] && map[nx][ny] != '#') {
					if (map[nx][ny] == 'k') {
						kn++;
					} else if (map[nx][ny] == 'v') {
						vn++;
					}
					
					q.offer(new Pos(nx,ny));
					visit[nx][ny] = true;
				}
			}
		}

		if (kn > vn) {
			kNum += kn;
		} else {
			vNum += vn;
		}
	}

}
