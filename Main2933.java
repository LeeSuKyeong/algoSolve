import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2933 {
	static char[][] map;
	static int R, C;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int dir;
			if (i % 2 == 0) {
				dir = 0;// l->r
			} else {
				dir = 1;// r->l
			}
			int h = Integer.parseInt(st.nextToken());

			throwStick(dir, h);

			check();
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	static void check() {
		boolean[][] visit = new boolean[R][C];

		for (int i = 0; i < C; i++) {
			if (map[R - 1][i] == 'x' && !visit[R - 1][i]) {
				bfs(R - 1, i, visit);
			}
		}
		// 떨어뜨릴게있는지 확인후 down
		label: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'x' && !visit[i][j]) {

					down(visit);
					break label;
				}
			}
		}

	}

	static void copy(char[][] cMap) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cMap[i][j] = map[i][j];
			}
		}
	}

	static void down(boolean[][] visit) {
		boolean flag = false;
		char[][] cMap = new char[R][C];
		while (!flag) {
			copy(cMap);
			loop: for (int i = R - 2; i >= 0; i--) {
				for (int j = 0; j < C; j++) {
					if (!visit[i][j] && map[i][j] == 'x') {
						if (map[i + 1][j] == 'x') { // 더이상못내려갈경우 break
							flag = true;
							break loop;
						} else {
							map[i + 1][j] = 'x';
							map[i][j] = '.';
						}
					}
				}
			} // 한칸씩 down
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = cMap[i][j];
			}
		} // 움직였던거 한칸위로 원래대로

	}

	static void bfs(int x, int y, boolean[][] visit) {
		Queue<Pos> q = new LinkedList<>();

		visit[x][y] = true;
		q.offer(new Pos(x, y));

		while (!q.isEmpty()) {
			Pos p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == 'x' && !visit[nx][ny]) {
					q.offer(new Pos(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
	}

	static void throwStick(int dir, int h) {
		if (dir == 0) {
			int x = R - h;
			int y = 0;
			while (true) {
				if (map[x][y] == 'x') {
					map[x][y] = '.';
					break;
				} else {
					y++;
					if (y >= C) {
						break;
					}
				}
			}
		} else {
			int x = R - h;
			int y = C - 1;
			while (true) {
				if (map[x][y] == 'x') {
					map[x][y] = '.';
					break;
				} else {
					y--;
					if (y < 0) {
						break;
					}
				}
			}
		}
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
