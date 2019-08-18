import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1063 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] k = st.nextToken().toCharArray();
		char[] s = st.nextToken().toCharArray();
		int N = Integer.parseInt(st.nextToken());
		String dir;
		for (int i = 0; i < N; i++) {
			dir = br.readLine();
			if ("B".equals(dir) && k[1] - 1 >= '1') {
				if (s[0] == k[0] && s[1] == k[1] - 1) {
					if (s[1] - 1 < '1') {
						continue;
					}
					s[1] -= 1;
				}
				k[1] -= 1;

			} else if ("T".equals(dir) && k[1] + 1 <= '8') {
				if (s[0] == k[0] && s[1] == k[1] + 1) {
					if (s[1] + 1 > '8') {
						continue;
					}
					s[1] += 1;
				}
				k[1] += 1;
			} else if ("R".equals(dir) && k[0] + 1 <= 'H') {
				if (s[0] == k[0] + 1 && s[1] == k[1]) {
					if (s[0] + 1 > 'H') {
						continue;
					}
					s[0] += 1;
				}
				k[0] += 1;
			} else if ("L".equals(dir) && k[0] - 1 >= 'A') {
				if (s[0] == k[0] - 1 && s[1] == k[1]) {
					if (s[0] - 1 < 'A') {
						continue;
					}
					s[0] -= 1;
				}
				k[0] -= 1;
			} else if ("LT".equals(dir) && k[0] - 1 >= 'A' && k[1] + 1 <= '8') {
				if (s[0] == k[0] - 1 && s[1] == k[1] + 1) {
					if (s[0] - 1 < 'A' || s[1] + 1 > '8') {
						continue;
					}
					s[0] -= 1;
					s[1] += 1;
				}
				k[0] -= 1;
				k[1] += 1;
			} else if ("LB".equals(dir) && k[0] - 1 >= 'A' && k[1] - 1 >= '1') {
				if (s[0] == k[0] - 1 && s[1] == k[1] - 1) {
					if (s[0] - 1 < 'A' || s[1] - 1 < '1') {
						continue;
					}
					s[0] -= 1;
					s[1] -= 1;
				}
				k[0] -= 1;
				k[1] -= 1;
			} else if ("RT".equals(dir) && k[0] + 1 <= 'H' && k[1] + 1 <= '8') {
				if (s[0] == k[0] + 1 && s[1] == k[1] + 1) {
					if (s[0] + 1 > 'H' || s[1] + 1 > '8') {
						continue;
					}
					s[0] += 1;
					s[1] += 1;
				}
				k[0] += 1;
				k[1] += 1;
			} else if ("RB".equals(dir) && k[0] + 1 <= 'H' && k[1] - 1 >= '1') {
				if (s[0] == k[0] + 1 && s[1] == k[1] - 1) {
					if (s[0] + 1 > 'H' || s[1] - 1 < '1') {
						continue;
					}
					s[0] += 1;
					s[1] -= 1;
				}
				k[0] += 1;
				k[1] -= 1;
			}

		}

		System.out.println(String.valueOf(k));
		System.out.println(String.valueOf(s));
	}

}
