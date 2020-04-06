import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution7206 {
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String N = br.readLine();

			int max = dfs(N, 0);
			System.out.println("#" + tc + " " + max);
		}
	}

	static int dfs(String n, int cnt) {
		if (n.length() == 1) {
			map.put(n, 1);
			return 0;
		}

		if (map.containsKey(n)) {
			return map.get(n);
		}

		int tmp = 0;
		int temp;
		int a, b, c, d, e;
		for (int i = 1; i < n.length(); i++) {
			a = Integer.valueOf(n.substring(0, i));
			
			for (int j = i + 1; j < n.length(); j++) {
				b = Integer.valueOf(n.substring(i, j));
				
				for (int k = j + 1; k < n.length(); k++) {
					c = Integer.valueOf(n.substring(j, k));
					
					for (int w = k + 1; w < n.length(); w++) {
						d = Integer.valueOf(n.substring(k, w));
						e = Integer.valueOf(w);
					
						temp = dfs(String.valueOf(a * b * c * d * e), cnt + 1);
						tmp = temp < tmp ? tmp : temp;
					}
					d = Integer.valueOf(n.substring(k));
					
					temp = dfs(String.valueOf(a * b * c * d), cnt + 1);
					tmp = temp < tmp ? tmp : temp;
				}
				c = Integer.valueOf(n.substring(j));
				
				temp = dfs(String.valueOf(a * b * c), cnt + 1);
				tmp = temp < tmp ? tmp : temp;
			}
			b = Integer.valueOf(n.substring(i));
			
			temp = dfs(String.valueOf(a * b), cnt + 1);
			tmp = temp < tmp ? tmp : temp;
		}

		map.put(n, tmp + 1);
		return map.get(n);
	}
}
