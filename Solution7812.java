import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합 문제( sum[i] - sum[j])
public class Solution7812 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] sum = new int[N + 1];
			st = new StringTokenizer(br.readLine());

			int c;
			int count = 0;
			for (int i = 1; i <= N; i++) {

				sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());

				c = 1;
				while (i - c >= 0) {
					if (sum[i] - sum[i - c] == M) {
						count++;
						break;
					} else if (sum[i] - sum[i - c] > M) {
						break;
					} else {
						c++;
					}
				}
			}

			System.out.println("#" + tc + " " + count);
		}

	}

}
