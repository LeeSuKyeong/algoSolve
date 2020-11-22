import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main13460 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean rflag = false, bflag = false;
		map = new char[N][M];
		visit = new boolean[N][M][4];
		
		int[] bpos = null,rpos = null;
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();

			if (!(rflag && bflag)) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 'B') {
						map[i][j] = '.';
						bpos = new int[]{i,j,0};
						bflag = true;
					}
					if (map[i][j] == 'R') {
						map[i][j] = '.';
						rpos = new int[]{i,j,0};
						rflag = true;
					}
				}
			}
		}
		
		dfs(0,rpos,bpos);
		System.out.println(min==11?-1:min+1);
	}

	static int N, M, min = 11;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static void dfs(int cnt,int[] rpos, int[] bpos) {
		if (cnt >= 10) {
			return;
		}

		if (min <= cnt) {
			return;
		}
		
		int[] trpos = { rpos[0], rpos[1], rpos[2] };
		int[] tbpos = { bpos[0], bpos[1], bpos[2] };
		
		for (int i = 0; i < 4; i++) {
			if(visit[rpos[0]][rpos[1]][i]) continue;
			
			int f = move(i, trpos, tbpos,rpos, bpos);
			if (f == 1) {
				min = min < cnt ? min : cnt ;
				break;
			}else if(f==0){
				dfs(cnt+1,rpos, bpos);
			}
			for (int j = 0; j < 3; j++) {
				bpos[j] = tbpos[j];
				rpos[j] = trpos[j];
			}

		}
	}

	static int move(int d, int[] trpos, int[] tbpos,int[] rpos, int[] bpos) {
		// r
		while (true) {
			rpos[0] += dx[d];
			rpos[1] += dy[d];

			if (map[rpos[0]][rpos[1]] == 'O') {
				rpos[2] = 1;
				break;
			}

			if (map[rpos[0]][rpos[1]] == '#') {
				rpos[0] -= dx[d];
				rpos[1] -= dy[d];
				break;
			}
		}

		// b
		while (true) {
			bpos[0] += dx[d];
			bpos[1] += dy[d];

			if (map[bpos[0]][bpos[1]] == 'O') {
				bpos[2] = 1;
				break;
			}

			if (map[bpos[0]][bpos[1]] == '#') {
				bpos[0] -= dx[d];
				bpos[1] -= dy[d];
				break;
			}
		}

		if (bpos[2] == 1)
			return -1;
		if (rpos[2] == 1)
			return 1;

		if (rpos[0] == bpos[0] && rpos[1] == bpos[1]) {
			switch (d) {
			case 0:
				if(trpos[0]>tbpos[0]) rpos[0]++;
				else bpos[0]++;
				break;
			case 1:
				if(trpos[1]>tbpos[1]) bpos[1]--;
				else rpos[1]--;
				break;
			case 2:
				if(trpos[0]<tbpos[0]) rpos[0]--;
				else bpos[0]--;
				break;
			case 3:
				if(trpos[1]>tbpos[1]) rpos[1]++;
				else bpos[1]++;
				break;
			}
		}

		return 0;
	}

}
