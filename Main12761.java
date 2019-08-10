import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12761 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] bridge = new int[100000 + 1];
		Arrays.fill(bridge, 100000);
		bridge[N] = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);

		while (!q.isEmpty()) {
			int p = q.poll();

			if (p + 1 <= 100000 && bridge[p] + 1 < bridge[p + 1]) {
				bridge[p + 1] = bridge[p] + 1;
				if (p +1 == M) {
					break;
				}
				q.offer(p + 1);
			}
			if (p - 1 >= 0 && bridge[p] + 1 < bridge[p - 1]) {
				bridge[p - 1] = bridge[p] + 1;
				if (p -1 == M) {
					break;
				}
				q.offer(p - 1);
			}
			if (p + A <= 100000 && bridge[p] + 1 < bridge[p + A]) {
				bridge[p + A] = bridge[p] + 1;
				if (p +A== M) {
					break;
				}
				q.offer(p + A);
			}
			if (p - A >= 0 && bridge[p] + 1 < bridge[p - A]) {
				bridge[p - A] = bridge[p] + 1;
				if (p -A== M) {
					break;
				}
				q.offer(p - A);
			}
			if (p + B <= 100000 && bridge[p] + 1 < bridge[p + B]) {
				bridge[p + B] = bridge[p] + 1;
				if (p +B== M) {
					break;
				}
				q.offer(p + B);
			}
			if (p - B >= 0 && bridge[p] + 1 < bridge[p - B]) {
				bridge[p - B] = bridge[p] + 1;
				if (p -B== M) {
					break;
				}
				q.offer(p - B);
			}
			if (p != 0 && p * A <= 100000 && bridge[p] + 1 < bridge[p * A]) {
				bridge[p * A] = bridge[p] + 1;
				if (p *A== M) {
					break;
				}
				q.offer(p * A);
			}
			if (p * B != 0 && p * B <= 100000 && bridge[p] + 1 < bridge[p * B]) {
				bridge[p * B] = bridge[p] + 1;
				if (p *B== M) {
					break;
				}
				q.offer(p * B);
			}
		}

		System.out.println(bridge[M]);
	}

}
