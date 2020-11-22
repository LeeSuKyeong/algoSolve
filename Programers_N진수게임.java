class Programers_N진수게임 {

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder();
		char[] c = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		int num = 0;

		while (sb.length() < t * m) {
			if (num == 0) {
				sb.append(0);

			} else {
				int tmp = num;
				StringBuilder ss = new StringBuilder();
				while (tmp != 0) {
					ss.insert(0, c[tmp % n]);
					tmp /= n;
				}
				sb.append(ss.toString());
			}
			num++;
		}

		StringBuilder ans = new StringBuilder();
		int idx = 0;
		for (int i = 0; i < t; i++) {
			ans.append(sb.charAt(m * idx + p - 1));
			idx++;
		}

		return ans.toString();
	}

}
