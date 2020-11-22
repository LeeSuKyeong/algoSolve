import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17142 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		ArrayList<int[]> v = new ArrayList<>();
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					v.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					zeroCnt++;
				}
			}
		}
		int[][] active = new int[M][2];
		if (zeroCnt == 0) {
			System.out.println(0);
		} else {

			virus(map, 0, 0, v, active, new boolean[v.size()]);
			System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		}

	}

	static int N, M, min = Integer.MAX_VALUE;
	static int zeroCnt = 0;

	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static int spread(int[][] map, int[][] active) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		int zeros = zeroCnt;

		Queue<Pos> q = new LinkedList<>();
		int[][] visit = new int[N][N];
		for (int i = 0; i < active.length; i++) {
			visit[active[i][0]][active[i][1]] = 1;
			q.offer(new Pos(active[i][0], active[i][1]));
		}

		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();

				for (int j = 0; j < 4; j++) {

					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (map[nx][ny] != 1 && visit[nx][ny] == 0) {
							visit[nx][ny] = visit[p.x][p.y] + 1;
							q.offer(new Pos(nx, ny));
							if (map[nx][ny] == 0)
								zeros--;
						}
					}
				}
			}
			time++;
			if (zeros == 0)
				break;
		}

		return zeros != 0 ? Integer.MAX_VALUE : time;
	}

	static void virus(int[][] map, int cnt, int idx, ArrayList<int[]> virus, int[][] active, boolean[] visit) {
		if (cnt == M) {
			int tmp = spread(map, active);
			if (tmp < min) {
				min = tmp;
			}

			return;
		}

		for (int i = idx; i < virus.size(); i++) {
			if (!visit[i]) {
				active[cnt][0] = virus.get(i)[0];
				active[cnt][1] = virus.get(i)[1];
				visit[i] = true;
				virus(map, cnt + 1, i, virus, active, visit);
				visit[i] = false;
				active[cnt][0] = -1;
				active[cnt][1] = -1;
			}

		}

	}
}
