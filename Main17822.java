import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17822 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		// map
		int[][] map = new int[N + 1][M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			rotate(map, x, d, k);

			boolean flag = false;
			
			//인접 숫자 찾기
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != 0) {
						for (int w = 0; w < 4; w++) {
							int nx = i + dx[w];
							int ny = (j + dy[w] +M) % M;

							if (nx == 0 || nx > N)
								continue;
							if (map[nx][ny] !=0 && map[nx][ny] == map[i][j]) {
								flag = true;
								find(map, i, j);
							}
						}
					}
					
				}
			}
			if(!flag) {
				//인접한 수들 중 같은 수가 없는 경우
				int cnt =0;
				double avg =0;
				for(int i=1;i<=N;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] !=0) {
							cnt++;
							avg+=map[i][j];
						}
					}
				}
				
				if(cnt !=0) {					
					avg/=(double)cnt;
				}
				
				for(int i=1;i<=N;i++) {
					for(int j=0;j<M;j++) {
						if(map[i][j] !=0) {
							if(map[i][j] < avg) {
								map[i][j] +=1;
							}else if(map[i][j] >avg){
								map[i][j] -=1;
							}
						}
					}
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<M;j++) {
				cnt+=map[i][j];
			}
		}
		
		System.out.println(cnt);
	}

	static int N, M;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void find(int[][] map, int x, int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] {x,y});
		int val = map[x][y];
		map[x][y] = 0;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = p[0] + dx[k];
				int ny = (p[1] + dy[k]+M) % M;

				if (nx == 0 || nx > N)
					continue;
				
				if (map[nx][ny] == val) {
					map[nx][ny] = 0;
					q.offer(new int[] { nx, ny });
				}
			}
		}
		
	}

	static void rotate(int[][] map, int x, int d, int k) {

		for (int i = 1; i <= N; i++) {
			if (i % x == 0) { // 배수
				int[] tmp = new int[M];

				for (int j = 0; j < M; j++) {
					tmp[(j + (d == 0 ? k : -k + M)) % M] = map[i][j];
				}
				map[i] = tmp;
			}
		}

	}
}
