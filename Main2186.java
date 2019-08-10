import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2186 {
	static char[][] map;
	static int[][][] count;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};	//상우하좌
	static int N,M,K,cnt=0;
	static String word;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}

		word = br.readLine();
		count = new int[N][M][word.length()]; //(n,m)좌표에서 word의 idx번째가 나온 수
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				Arrays.fill(count[i][j], -1); //접근안한 (i,j)칸 ->-1
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==word.charAt(0)) {
					cnt += dfs(i,j,0);					
				}
			}
		}	
		System.out.println(cnt);
	}

	static int dfs(int x,int y,int idx) {
		int nx;
		int ny;
		if(idx ==word.length()-1) {
			count[x][y][idx]=1;
			return 1;
		}
		if(count[x][y][idx] != -1) {
			return count[x][y][idx];
		}
		count[x][y][idx] =0;
		for(int i=0;i<4;i++) {
			nx = x;
			ny = y;
			for(int j=0;j<K;j++) {
				nx +=dx[i];
				ny +=dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] == word.charAt(idx+1)) {
					count[x][y][idx]+=dfs(nx,ny,idx+1);
				}
			}			
		}
		
		return count[x][y][idx];
	
	}
}
