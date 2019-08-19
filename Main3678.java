import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3678 {
	static int[] tile, count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		// 배열 채우기 중복 방지를 위한 테케 중 가장 큰 n값으로 돌리기
		int[] N = new int[T];
		int maxN = 0;

		for (int tc = 0; tc < T; tc++) {
			N[tc] = Integer.parseInt(br.readLine());
			maxN = maxN < N[tc] ? N[tc] : maxN;
		}

		// 배열 채우기
		tile = new int[maxN];
		count = new int[5 + 1];

		int state = 0;
		int cnt = 1;
		int idx = 0;

		// state 0
		tile[0] = 1;
		count[1]++;
		state++;
		idx++;

		if (idx != maxN) {
			while (idx != maxN && idx < 6) {// idx<6
				tile[idx] = check(idx - 1, 0);
				count[tile[idx]]++;
				idx++;
			}
			if (idx != maxN) {
				// idx == 6
				tile[idx] = check(idx - 1, 0, 1);
				count[tile[idx]]++;
				state++;
				idx++;

				if (idx != maxN) {
					label: while (true) {
						// state 단 첫 시작 idx
						tile[idx] = check(idx - 1, cnt);
						count[tile[idx]]++;
						idx++;
						if (idx == maxN) {
							break label;
						}
						// 3개 확인
						for (int i = 0; i < state - 2; i++) {
							tile[idx] = check(idx - 1, cnt, cnt + 1);
							count[tile[idx]]++;
							idx++;
							cnt++;
							if (idx == maxN) {
								break label;
							}
						}

						for (int j = 0; j < 4; j++) {
							// 2개 확인(육각형의 꼭지점 부분 4개)
							tile[idx] = check(idx - 1, cnt);
							count[tile[idx]]++;
							idx++;
							if (idx == maxN) {
								break label;
							}
							// 3개 확인
							for (int i = 0; i < state - 1; i++) {
								tile[idx] = check(idx - 1, cnt, cnt + 1);
								count[tile[idx]]++;
								idx++;
								cnt++;
								if (idx == maxN) {
									break label;
								}
							}

						}

						// 2개(육각형의 마지막 꼭지점부분)
						tile[idx] = check(idx - 1, cnt);
						count[tile[idx]]++;
						idx++;
						if (idx == maxN) {
							break label;
						}
						// 3개
						for (int i = 0; i < state; i++) {
							tile[idx] = check(idx - 1, cnt, cnt + 1);
							count[tile[idx]]++;
							idx++;
							cnt++;
							if (idx == maxN) {
								break label;
							}
						}
						// 다음단
						state++;
					}

				}
			}

		}

		// 배열 채운 후 해당 테케 결과값 출력
		for (int tc = 0; tc < T; tc++) {
			System.out.println(tile[N[tc] - 1]);
		}

	}

	static int check(int a, int b) {
		int idxVal = Integer.MAX_VALUE;
		int idx = 1;
		for (int i = 1; i <= 5; i++) {
			if (count[i] < idxVal) {
				if (tile[a] != i && tile[b] != i) {
					idx = i;
					idxVal = count[i];
				}
			}
		}
		return idx;
	}

	static int check(int a, int b, int c) {
		int idxVal = Integer.MAX_VALUE;
		int idx = 1;
		for (int i = 1; i <= 5; i++) {
			if (count[i] < idxVal) {
				if (tile[a] != i && tile[b] != i && tile[c] != i) {
					idx = i;
					idxVal = count[i];
				}
			}
		}
		return idx;
	}

}
