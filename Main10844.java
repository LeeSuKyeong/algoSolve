import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long sum = 0;

			long[][] map = new long[N + 1][10];

			for (int i = 1; i < 10; i++) {
				map[1][i] = 1;
			}

			for (int i = 2; i <= N; i++) {
				for (int j = 0; j < 10; j++) {
					if (j + 1 < 10)
						map[i][j] += map[i - 1][j + 1];
					if (j - 1 >= 0)
						map[i][j] += map[i - 1][j - 1];
					
					map[i][j] %=1_000_000_000;
				}
			}

			for (int i = 0; i < 10; i++) {
				sum = (sum+map[N][i])%1_000_000_000;
			}
		System.out.println(sum);
	}

}
