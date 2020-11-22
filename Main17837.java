import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17837 {
	static int[][] cmap;
	static ArrayList<Integer>[][] hmap;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		cmap = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cmap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		hmap = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				hmap[i][j] = new ArrayList<>();
			}
		}

		int[][] horse = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			horse[i][0] = Integer.parseInt(st.nextToken()) - 1;
			horse[i][1] = Integer.parseInt(st.nextToken()) - 1;
			horse[i][2] = Integer.parseInt(st.nextToken());
			hmap[horse[i][0]][horse[i][1]].add(i);
		}

		boolean flag = false;
		int turn = 0;
		Turn: while (turn < 1000) {
			turn++;
			for (int i = 0; i < K; i++) {
				int nx = horse[i][0] + dx[horse[i][2]];
				int ny = horse[i][1] + dy[horse[i][2]];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
					// 맵밖
					ArrayList<Integer> tmp = hmap[horse[i][0]][horse[i][1]];
					int idx = tmp.indexOf(i);

					horse[i][2] = horse[i][2] % 2 == 0 ? horse[i][2] - 1 : horse[i][2] + 1;
					nx = horse[i][0] + dx[horse[i][2]];
					ny = horse[i][1] + dy[horse[i][2]];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N && cmap[nx][ny] != 2) {
						if(cmap[nx][ny] == 0) {
							for (int j = idx; j < tmp.size();) {
								int htmp = tmp.get(idx);
								hmap[nx][ny].add(htmp);
								horse[htmp][0] = nx;
								horse[htmp][1] = ny;
								tmp.remove(idx);
							}
							if (hmap[nx][ny].size() >= 4) {
								flag = true;
								break Turn;
							}
						}else {
							for (int j = tmp.size() - 1; j >= idx; j--) {
								int htmp = tmp.get(tmp.size() - 1);
								hmap[nx][ny].add(htmp);
								horse[htmp][0] = nx;
								horse[htmp][1] = ny;
								tmp.remove(tmp.size() - 1);
							}
							if (hmap[nx][ny].size() >= 4) {
								flag = true;
								break Turn;
							}
						}
					}

				} else if (cmap[nx][ny] == 0) {
					// 흰
					ArrayList<Integer> tmp = hmap[horse[i][0]][horse[i][1]];
					int idx = tmp.indexOf(i);
					for (int j = idx; j < tmp.size();) {
						int htmp = tmp.get(idx);
						hmap[nx][ny].add(htmp);
						horse[htmp][0] = nx;
						horse[htmp][1] = ny;
						tmp.remove(idx);
					}

					if (hmap[nx][ny].size() >= 4) {
						flag = true;
						break Turn;
					}

				} else if (cmap[nx][ny] == 1) {
					// 빨
					ArrayList<Integer> tmp = hmap[horse[i][0]][horse[i][1]];
					int idx = tmp.indexOf(i);

					for (int j = tmp.size() - 1; j >= idx; j--) {
						int htmp = tmp.get(tmp.size() - 1);
						hmap[nx][ny].add(htmp);
						horse[htmp][0] = nx;
						horse[htmp][1] = ny;
						tmp.remove(tmp.size() - 1);
					}
					if (hmap[nx][ny].size() >= 4) {
						flag = true;
						break Turn;
					}
				} else {
					// 파
					ArrayList<Integer> tmp = hmap[horse[i][0]][horse[i][1]];
					int idx = tmp.indexOf(i);

					horse[i][2] = horse[i][2] % 2 == 0 ? horse[i][2] - 1 : horse[i][2] + 1;
					if (cmap[nx][ny] == 2) {
						nx = horse[i][0] + dx[horse[i][2]];
						ny = horse[i][1] + dy[horse[i][2]];
						if (nx >= 0 && ny >= 0 && nx < N && ny < N && cmap[nx][ny] != 2) {
							if(cmap[nx][ny] == 0) {
								for (int j = idx; j < tmp.size();) {
									int htmp = tmp.get(idx);
									hmap[nx][ny].add(htmp);
									horse[htmp][0] = nx;
									horse[htmp][1] = ny;
									tmp.remove(idx);
								}
								if (hmap[nx][ny].size() >= 4) {
									flag = true;
									break Turn;
								}
							}else {
								for (int j = tmp.size() - 1; j >= idx; j--) {
									int htmp = tmp.get(tmp.size() - 1);
									hmap[nx][ny].add(htmp);
									horse[htmp][0] = nx;
									horse[htmp][1] = ny;
									tmp.remove(tmp.size() - 1);
								}
								if (hmap[nx][ny].size() >= 4) {
									flag = true;
									break Turn;
								}
							}
							
						}

					}

				}
			}
		}

		if (!flag) {
			System.out.println(-1);
		} else {
			System.out.println(turn);
		}
	}
}
