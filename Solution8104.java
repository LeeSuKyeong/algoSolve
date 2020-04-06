import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution8104 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc);
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			int sum = 0;
			if (N % 2!= 0) {
				sum = (N-1)*(1+K*(N-1))/2;

				int val = 2*K*(N/2)+1;
				
				for (int i = 0; i < K; i++) {
					sb.append(" ").append(sum+val);
					val++;
				}
			} else {
				sum = N * (1 + K * N) / 2;
				for (int i = 0; i < K; i++) {
					sb.append(" ").append(sum);
				}
			}

			System.out.println(sb);
		}
	}

}