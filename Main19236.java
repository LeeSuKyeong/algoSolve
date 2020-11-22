import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main19236 {
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map = new int[4][4];
	static int[] shark; // x y d
	static int[][] fishes = new int[16 + 1][3];
	static int maxSum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 4; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[i][j] = a;
				fishes[a][0] = i;
				fishes[a][1] = j;
				fishes[a][2] = b - 1;
			}
		}

		shark = new int[3];
		int fishNum = map[0][0];
		shark[2] = fishes[fishNum][2]; // d
		maxSum = map[0][0];
		fishes[fishNum] = new int[] { -1, -1, -1 }; // dead
		map[0][0] = 0;
		play(maxSum);

		System.out.println(maxSum);
	}

	static void play(int sum) {

		fishMove();
		sharkMove(sum);

	}

	static void copyVariable(int[][] cMap, int[] cShark, int[][] cFishes, int[][] map, int[] shark, int[][] fishes) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				map[i][j] = cMap[i][j];
			}
		}

		for (int i = 0; i < 3; i++) {
			shark[i] = cShark[i];
		}

		for (int i = 1; i <= 16; i++) {
			fishes[i][0] = cFishes[i][0];
			fishes[i][1] = cFishes[i][1];
			fishes[i][2] = cFishes[i][2];
		}
	}

	static void sharkMove(int sum) {
		int nx = shark[0];
		int ny = shark[1];
		for (int i = 0; i < 4; i++) {
			nx += dx[shark[2]];
			ny += dy[shark[2]];

			if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
				// 비교
				maxSum = maxSum > sum ? maxSum : sum;
				break;
			}

			int fishNum = map[nx][ny];
			if (fishNum != 0) {
				int[][] cMap = new int[4][4];
				int[] cShark = new int[3]; // x y d
				int[][] cFishes = new int[16 + 1][3];
				copyVariable(map, shark, fishes, cMap, cShark, cFishes);
				shark[0] = nx;
				shark[1] = ny;
				shark[2] = fishes[fishNum][2];
				map[nx][ny] = 0;
				fishes[fishNum][0] = -1;
				fishes[fishNum][1] = -1;
				fishes[fishNum][2] = -1;
		
				play(sum + fishNum);
				copyVariable(cMap, cShark, cFishes, map, shark, fishes);
			}
		}
	}

	static void fishMove() {
		for (int i = 1; i <= 16; i++) {
			if (fishes[i][0] != -1 && fishes[i][1] != -1 && fishes[i][2] != -1) {// live

				for (int j = 0; j < 8; j++) {
					int nx = fishes[i][0] + dx[fishes[i][2]];
					int ny = fishes[i][1] + dy[fishes[i][2]];

					if (nx == shark[0] && ny == shark[1]) {
						fishes[i][2] = (fishes[i][2] + 1) % 8;
						continue;
					}

					if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
						fishes[i][2] = (fishes[i][2] + 1) % 8;
						continue;
					}

					if (map[nx][ny] != 0) {
						swap(i, map[nx][ny]);
					} else {
						map[fishes[i][0]][fishes[i][1]] = 0;
						map[nx][ny] = i;
						fishes[i][0] = nx;
						fishes[i][1] = ny;
					}

					break;
				}

			}
		}
	}

	static void swap(int a, int b) {
		int ax = fishes[a][0];
		int ay = fishes[a][1];
		int bx = fishes[b][0];
		int by = fishes[b][1];

		map[ax][ay] = b;
		map[bx][by] = a;
		
		int tmpx = fishes[b][0];
		int tmpy = fishes[b][1];
		fishes[b][0] = fishes[a][0];
		fishes[b][1] = fishes[a][1];
		fishes[a][0] = tmpx;
		fishes[a][1] = tmpy;

	}

	static void printMap() {
		for (int i = 0; i < 4; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
