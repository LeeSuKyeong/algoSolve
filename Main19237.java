import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19237 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		sharkCnt = M;
		shark = new Shark[M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					shark[tmp] = new Shark(tmp, i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			shark[i].d = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int d = 0; d < 4; d++) {
					shark[i].priority[j][d] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// time = 0;
		Smell[][] map = makeMap(N);
		for (int i = 1; i <= M; i++) {
			map[shark[i].x][shark[i].y].duration = k;
			map[shark[i].x][shark[i].y].sharkNum = i;
		}

//		int time = 0;
		while (sharkCnt != 1 && time < 1000) {
			time++;
			map = move(map, N,M,k);
			updateDuration(map, N,M,k);
		}

		if (time >= 1000 && sharkCnt != 1)
			System.out.println(-1);
		else
			System.out.println(time);
	}
	static int time = 0;
	static int sharkCnt;
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	static Smell[][] makeMap(int N) {
		Smell[][] map = new Smell[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new Smell(0, 0);
			}
		}

		return map;
	}

	static Shark[] shark;

	static class Shark {
		int num, x, y, d;
		boolean dead;
		int[][] priority = new int[4 + 1][4];

		public Shark(int num, int x, int y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.dead = false;
		}

	}

	static class Smell {
		int sharkNum;
		int duration;

		public Smell(int sharkNum, int k) {
			super();
			this.sharkNum = sharkNum;
			this.duration = k;
		}
	}

	static void updateDuration(Smell[][] map, int N,int M, int K) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].duration != 0) {
					map[i][j].duration -= 1;
					if (map[i][j].duration == 0) {
						map[i][j].sharkNum = 0;
					}
				}

			}
		}
		for(int i=1;i<=M;i++) {
			if(!shark[i].dead) {
				map[shark[i].x][shark[i].y].duration =K;
			}
		}
	}

	static Smell[][] move(Smell[][] map, int N, int M, int K) {
		Smell[][] newMap = copyMap(map, N);

		// move
		for (int i = 1; i <= M; i++) {
			if (!shark[i].dead) {
				boolean moveFlag = false;
				for (int j = 0; j < 4; j++) {
					int dir = shark[i].priority[shark[i].d][j];
					int nx = shark[i].x + dx[dir];
					int ny = shark[i].y + dy[dir];
					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					// 빈칸
					if (map[nx][ny].sharkNum == 0) {
						moveFlag = true;
						// 냄새뿌리기
						if (newMap[nx][ny].sharkNum != 0) { //다른상어가 있는경우
							if (newMap[nx][ny].sharkNum < i) {
								shark[i].dead = true;
								sharkCnt--;
							} else {
								shark[newMap[nx][ny].sharkNum].dead = true;
								sharkCnt--;
							}
						} else {
							newMap[nx][ny].sharkNum = i;
							newMap[nx][ny].duration = K;
							shark[i].x = nx;
							shark[i].y = ny;
							shark[i].d = dir;
						}
						break;
					}
				}

				if (!moveFlag) {
					for (int j = 0; j < 4; j++) {
						int dir = shark[i].priority[shark[i].d][j];
						int nx = shark[i].x + dx[dir];
						int ny = shark[i].y + dy[dir];
						if (nx < 0 || ny < 0 || nx >= N || ny >= N)
							continue;
						// 이미이동한 상어가있는칸
						if (map[nx][ny].sharkNum == i) {
							// 냄새뿌리기

							newMap[nx][ny].duration = K;
							shark[i].x = nx;
							shark[i].y = ny;
							shark[i].d = dir;

							break;
						}
					}
				}
			}
		}

		return newMap;
	}

	static Smell[][] copyMap(Smell[][] map, int N) {
		Smell[][] newMap = new Smell[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Smell tmp = map[i][j];
				newMap[i][j] = new Smell(tmp.sharkNum, tmp.duration);
			}
		}
		return newMap;
	}
}
