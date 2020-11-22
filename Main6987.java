import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main6987 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		game = new int[15][2];
		int a = 0, b = 1;
		for (int i = 0; i < 15; i++) {
			game[i] = new int[] { a, b };
			b++;
			if (b == 6) {
				a++;
				b = a + 1;
			}
		}

		for (int tc = 0; tc < 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			resultScore = new int[6][3];
			flag = 0;
			int totalCnt = 0;

			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					resultScore[i][j] = Integer.parseInt(st.nextToken());
					totalCnt += resultScore[i][j];
				}
			}

			if (totalCnt != 30) {
				sb.append(0).append(' ');
			} else {
				int[][] score = new int[6][3];
				dfs(score, 0);
				sb.append(flag).append(' ');
			}

		}
		System.out.println(sb);

	}

	static int[][] resultScore, game;
	static int flag = 0;

	static void dfs(int[][] score, int cnt) {

		if (flag == 1) {
			return;
		}

		if (cnt == 15) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (resultScore[i][j] != score[i][j]) {
						return;
					}
				}
			}
			flag = 1;
			return;
		}

		int i = game[cnt][0];
		int j= game[cnt][1];
		if (score[i][0] + 1 <= resultScore[i][0] && score[j][2] + 1 <= resultScore[j][2]) {
			score[i][0]++;
			score[j][2]++;
			dfs(score, cnt + 1);
			score[i][0]--;
			score[j][2]--;
		}

		if (score[i][1] + 1 <= resultScore[i][1] && score[j][1] + 1 <= resultScore[j][1]) {
			score[i][1]++;
			score[j][1]++;
			dfs(score, cnt + 1);
			score[i][1]--;
			score[j][1]--;
		}

		if (score[i][2] + 1 <= resultScore[i][2] && score[j][0] + 1 <= resultScore[j][0]) {
			score[i][2]++;
			score[j][0]++;
			dfs(score, cnt + 1);
			score[i][2]--;
			score[j][0]--;
		}

	}

}
