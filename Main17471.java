import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main17471 {
	static boolean[] visit, visitTrue, visitFalse;
	static int[] person;
	static int N, result = Integer.MAX_VALUE;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		person = new int[N + 1];
		for (int i = 0; i < N; i++) {
			person[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		map = new boolean[N + 1][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			for (int j = 0; j < len; j++) {
				map[i + 1][Integer.parseInt(st.nextToken())] = true;
			}
		}
		
		visit = new boolean[N + 1];
		comb(1);

		System.out.println(result==Integer.MAX_VALUE?-1:result);
	}

	public static void comb(int idx) {
		if (idx > N) {
			if (check()) {
				calc();
			}
			return;
		}

		visit[idx] = true;
		comb(idx + 1);
		visit[idx] = false;
		comb(idx + 1);
	}

	public static void calc() {
		int a = 0, b = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i]) {
				a += person[i];
			} else {
				b += person[i];
			}
		}
		
		result = result < Math.abs(a - b) ? result : Math.abs(a - b);
	}

	public static boolean check() {
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (visit[i])
				cnt++;
		}
		if (cnt == N) {
			return false;
		}

		// 다이어져있는지체크
		visitTrue = new boolean[N + 1];
		visitFalse = new boolean[N + 1];
		for (int i = 1; i <= N; i++) { //true인것 중 하나 선택
			if (visit[i]) {
				visitTrue[i] = true;
				dfs(i, 0);
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				visitFalse[i] = true;
				dfs(i, 1);
				break;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (visit[i] != visitTrue[i]) {
				return false;
			}
			if (!visit[i] != visitFalse[i]) {
				return false;
			}
		}

		return true;
	}

	
	public static void dfs(int idx, int c) {
		if (c == 0) {
			for (int i = 1; i <= N; i++) {
				if (visit[i] && map[idx][i] && !visitTrue[i]) {
					visitTrue[i] = true;
					dfs(i, 0);
				}
			}
			
		} else {
			for (int i = 1; i <= N; i++) {
				if (!visit[i] && map[idx][i] && !visitFalse[i]) {
					visitFalse[i] = true;
					dfs(i, 1);
				}
			}
		}

	}

}
