import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2872 {
	/* 풀이
	 * 배열의 끝에서 부터 arr[idx]<N 이면 제일 앞으로 옮겨야하는 수 (cnt++)
	 * arr[i] == N 이면 N--
	 * -> N번째 와야하는 수이므로 그대로 두고 그다음 큰수를 찾아야하므로
	 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;

		for (int i = arr.length - 1; i >= 0; i--) {

			if (arr[i] < N) {
				cnt++;
			} else if (arr[i] == N) {
				N--;
			}
		}

		System.out.println(cnt);
	}
}
