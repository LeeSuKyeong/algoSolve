import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N + 2][M + 2];
		boolean[][] check = new boolean[N + 2][M + 2];
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };
		int count = 0;

		Arrays.fill(map[0], '.');
		Arrays.fill(map[N + 1], '.');

		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			map[i][0] = '.';
			for (int j = 1; j <= M; j++) {
				map[i][j] = temp.charAt(j - 1);
			}
			map[i][M + 1] = '.';
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (map[i][j] == 'X') {
					count = 0;
					for (int k = 0; k < 4; k++) {
						if (!check[i+dx[k]][j+dy[k]] && map[i + dx[k]][j + dy[k]] == '.') {
							count++;
						}
					}
					if (count >= 3) {
						map[i][j] = '.';
						check[i][j] = true;
					}
				}
			}
		}
		
		int[] startPos= {N,M};
		int[] endPos = {1,1};
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=M;j++) {
				if(map[i][j] =='X') {
					startPos[0]= i<startPos[0]?i:startPos[0];
					startPos[1]= j<startPos[1]?j:startPos[1];
					endPos[0] = i>endPos[0]?i:endPos[0];
					endPos[1] = j>endPos[1]?j:endPos[1];
				}
			}
		}
		
		for(int i=startPos[0];i<=endPos[0];i++) {
			for(int j=startPos[1];j<=endPos[1];j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
