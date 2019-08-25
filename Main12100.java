import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main12100 {
	static int[][] map;
	static int N,result =0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				result = result<map[i][j]?map[i][j] :result;
			}
		}

		dfs(0);

		System.out.println(result);
	}
	
	static void dfs(int cnt) {
		if(cnt == 5) {
			find();
			return;
		}
		int[][] oMap = new int[N][N]; //이동전
		copy(oMap,map);
		
		for(int i=0;i<4;i++) {//nesw
			int[][] tMap = new int[N][N];//이동후
			move(i,tMap);
			if(memoization(tMap,map)) {
				continue;//map 변화가없으면
			}
			copy(map,tMap);
			dfs(cnt+1);
			copy(map,oMap);
		}
	}
	static boolean memoization(int[][] tMap,int[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] != tMap[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	static void copy(int[][] a,int[][] b) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	static void move(int dir,int[][] tMap) {

		int idx = 0;
		if(dir == 0) {
			//up
			for(int j=0;j<N;j++) {
				idx =0;
				for(int k=0;k<N;k++) {
					if(map[k][j] !=0) {
						if(tMap[idx][j] == map[k][j]) {
							tMap[idx][j] +=map[k][j];
							idx++;
						}else {
							if(tMap[idx][j] != 0) {
								idx++;
							}
							tMap[idx][j]=map[k][j];
						}
					}
				}
			}
			
		}else if(dir==1) {
			//right
			for(int j=0;j<N;j++) {
				idx =N-1;
				for(int k=N-1;k>=0;k--) {
					if(map[j][k] !=0) {
						if(tMap[j][idx] == map[j][k]) {
							tMap[j][idx] +=map[j][k];
							idx--;
						}else {
							if(tMap[j][idx] != 0) {
								idx--;
							}
							tMap[j][idx]=map[j][k];
						}
					}
				}
			}
		}else if(dir == 2) {
			//down
			for(int j=0;j<N;j++) {
				idx =N-1;
				for(int k=N-1;k>=0;k--) {
					if(map[k][j] !=0) {
						if(tMap[idx][j] == map[k][j]) {
							tMap[idx][j] +=map[k][j];
							idx--;
						}else {
							if(tMap[idx][j] != 0) {
								idx--;
							}
							tMap[idx][j]=map[k][j];
						}
					}
				}
			}
		}else {//left
			for(int j=0;j<N;j++) {
				idx =0;
				for(int k=0;k<N;k++) {
					if(map[j][k] !=0) {
						if(tMap[j][idx] == map[j][k]) {
							tMap[j][idx] +=map[j][k];
							idx++;
						}else {
							if(tMap[j][idx] != 0) {
								idx++;
							}
							tMap[j][idx]=map[j][k];
						}
					}
				}
			}
			
		}

	}
	
	static void find() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] > result) {
					result = map[i][j];
				}
			}
		}
	}
}
