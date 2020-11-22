import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1600 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//출발점 도착점 같은경우 0
		System.out.println(W==1 && H==1 && map[0][0] ==0 ?0:bfs(map, W, H, K));

	}

	static int bfs(int[][] map, int W, int H, int K) {
		int min = -1;

		int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2, -1, 0, 1, 0 };
		int[] dy = { -1, 1, -2, 2, -2, 2, -1, 1, 0, -1, 0, 1 };

		boolean[][][] visit = new boolean[H][W][K + 1];
		Queue<Pos> q = new LinkedList<>();
		visit[0][0][0] = true;

		q.offer(new Pos(0, 0, 0, 0));

		Label: while (!q.isEmpty()) {
			Pos p = q.poll();

			if (p.use < K) {
				for (int i = 0; i < 8; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0 && !visit[nx][ny][p.use + 1]) {
						if (ny == W - 1 && nx == H - 1) {
							min = p.cnt + 1;
							break Label;
						}
						visit[nx][ny][p.use + 1] = true;
						q.offer(new Pos(nx, ny, p.cnt + 1, p.use + 1));
					}
				}
			}

			for (int i = 8; i < 12; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == 0 && !visit[nx][ny][p.use]) {
					if (ny == W - 1 && nx == H - 1) {
						min = p.cnt + 1;
						break Label;
					}
					visit[nx][ny][p.use] = true;
					q.offer(new Pos(nx, ny, p.cnt + 1, p.use));
				}
			}
		}

		return min;

	}

	static class Pos {
		int x, y, cnt, use;

		public Pos(int x, int y, int cnt, int use) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.use = use;
		}

	}
}
