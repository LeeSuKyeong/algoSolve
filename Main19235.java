import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main19235 {
	static int[][] mapDown = new int[6][4];
	static int[][] mapRight = new int[6][4];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			block(t, x, y);
			
		}

		int cnt = 0;
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				if (mapRight[i][j] != 0)
					cnt++;
				if (mapDown[i][j] != 0)
					cnt++;
			}
		}
		System.out.println(score);
		System.out.println(cnt);
	}

	static int score = 0;

	static void down1x1(int x, int y, int[][] map) {
		int pos = 0;
		for (int i = 2; i < 6; i++) {
			if (map[i][y] != 0) {
				pos = i - 1;
				break;
			}
			pos = i;
		}

		map[pos][y] = 1;
		while (check(map)) {
			getScore(map);
		}

		blank(map);
	}

	static void down1x2(int x, int y, int[][] map) {
		int pos = 0;
		for (int i = 2; i < 6; i++) {
			if (y != 3 && map[i][y] != 0 || map[i][y + 1] != 0) {
				pos = i - 1;
				break;
			}
			pos = i;
		}
		map[pos][y] = 2;
		map[pos][y + 1] = 2;

		while (check(map)) {
			getScore(map);
		}

		blank(map);
	}
	static void print(int[][] map) {
		for(int i=0;i<6;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	static void down2x1(int x, int y, int[][] map) {
		int pos = 0;
		for (int i = 1; i < 5; i++) {
			if (map[i][y] != 0 || map[i + 1][y] != 0) {
				pos = i - 1;
				break;
			}
			pos = i;
		}

		map[pos][y] = 3;
		map[pos + 1][y] = 3;
		while (check(map)) {
			getScore(map);
		}

		blank(map);
	}

	static boolean check(int[][] map) {
		for (int i = 0; i < 6; i++) {
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 0) {
					flag = false;
					break;
				}
			}

			if (flag)
				return true;
		}

		return false;
	}

	static void blank(int[][] map) {
		boolean flag1 = false, flag2 = false;

		for (int j = 0; j < 4; j++) {
			if (map[0][j] != 0) {
				flag1 = true;
			}

			if (map[1][j] != 0) {
				flag2 = true;
			}
		}
		if (flag2) {
			for (int i = 5; i >= 1; i--) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = map[i - 1][j];
				}
			}
			for (int j = 0; j < 4; j++) {
				map[0][j] = 0;
			}
		}

		if (flag1) {
			for (int i = 5; i >= 1; i--) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = map[i - 1][j];
				}
			}

			for (int j = 0; j < 4; j++) {
				map[0][j] = 0;
			}
		}
	}

	static void getScore(int[][] map) {
		// 맵의 다찬 모든 줄 체크
		for (int i = 0; i < 6; i++) {
			boolean flag = true;
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				score++;
				makeZero(map, i);
			}
		}
		// 점수 다 얻고 내리기
		down(map);

	}

	static void makeZero(int[][] map, int idx) {
		for (int j = 0; j < 4; j++) {
			map[idx][j] = 0;
		}
	}

	static void down(int[][] map) {
		for (int i = 5; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == 1 || map[i][j] == 3) {
					int p = i;
					for (int k = i + 1; k < 6; k++) {
						if (map[k][j] != 0) {
							p = k - 1;
							break;
						}
						p=k;
					}

					if (p != i) {
						map[p][j] = map[i][j];
						map[i][j] = 0;
					}
				} else if (j != 3 && map[i][j] == 2 && map[i][j + 1] == 2) {
					int p = i;
					for (int k = i + 1; k < 6; k++) {
						if (map[k][j] != 0 || map[k][j + 1] != 0) {
							p = k - 1;
							break;
						}
						p=k;
					}
					if (p != i) {
						map[p][j] = map[i][j];
						map[p][j + 1] = map[i][j + 1];
						map[i][j] = 0;
						map[i][j + 1] = 0;
					}
				}
			}
		}
	}

	static void block(int t, int x, int y) {
		if (t == 1) {
			down1x1(x, y, mapDown);
			down1x1(y, 3 - x, mapRight);
		} else if (t == 2) {
			down1x2(x, y, mapDown);
			down2x1(y, 3 - x, mapRight);
		} else if (t == 3) {
			down2x1(x, y, mapDown);
			down1x2(y, 3 - (x + 1), mapRight);
		}
	}

}
