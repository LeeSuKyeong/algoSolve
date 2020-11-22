import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		boolean[][] chk = new boolean[N][N];
		while (chk(N, map, chk)) {
			move(map, N, chk);
			cnt++;
			chk = new boolean[N][N];
		}

		System.out.println(cnt);
	}

	static int L, R;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void move(int[][] map, int N, boolean[][] chk) {
		boolean[][] visit = new boolean[N][N]; // 갈수있는곳 중에서 인구이동 끝낸곳

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (chk[i][j] && !visit[i][j]) {
					bfs(i, j, map, N, visit, chk);
				}
			}
		}
	}

	static void bfs(int x, int y, int[][] map, int N, boolean[][] visit, boolean[][] chk) {

		int sum = 0;
		int cnt = 1;
		Queue<Pos> q = new LinkedList<>();
		ArrayList<Pos> region = new ArrayList<>();
		q.offer(new Pos(x, y));
		visit[x][y] = true;
		sum+=map[x][y];
		region.add(new Pos(x, y));

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && chk[nx][ny]) {
					int diff = Math.abs(map[p.x][p.y]- map[nx][ny] );
					if (diff >= L && diff <= R) {
						Pos n = new Pos(nx, ny);

						q.offer(n);
						visit[nx][ny] = true;
						region.add(n);

						sum += map[nx][ny];
						cnt++;
					}

				}
			}
		}

		sum /= cnt;
		for (int i = 0; i < cnt; i++) {
			Pos n = region.get(i);
			map[n.x][n.y] = sum;
		}
	}

	static boolean chk(int N, int[][] map, boolean[][] chk) {
		boolean flag = false;
		for (int i = 0; i < N; i++) { // 주변과 차이 L~R인지 확인

			for (int j = 0; j < N; j++) {
				for (int k = 1; k <= 2; k++) {

					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx >= 0 && ny >= 0 && nx < N && ny < N ) {
						int diff = Math.abs(map[i][j] - map[nx][ny]);
						if (diff >= L && diff <= R) {
							chk[i][j] = true;
							chk[nx][ny] = true;
							flag = true;
						}
					}
				}
			}
		}
		return flag;
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
