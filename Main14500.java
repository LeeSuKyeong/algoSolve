import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main14500 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[][] visit =new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visit[i][j] = true;
				dfs(i, j, 1, map[i][j], map,visit);//ㅏ,ㅗ,ㅓ,ㅜ빼고
				visit[i][j] = false;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {				
				exceptionPlay(i,j,map);
			}
		}
		System.out.println(max);
	}

	static void exceptionPlay(int x, int y, int[][] map) {
		int sum = 0;
		//ㅏ
		if(x+2<N && y+1<M) {
			sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y+1]);
		}
		
		//ㅓ
		if(x+2<N && y-1>=0) {
			sum = Math.max(sum, map[x][y] + map[x+1][y] + map[x+2][y] + map[x+1][y-1]);
		}
		
		//ㅗ
		if(x-1>=0 && y+2<M) {
			sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x][y+2] + map[x-1][y+1]);
		}
		
		//ㅜ
		if(x+1<N && y+2<M) {
			sum = Math.max(sum, map[x][y] + map[x][y+1] + map[x][y+2] + map[x+1][y+1]);
		}
		
		max = max<sum? sum:max;
	}

	static int max =0,N,M;
	static int[] dx = {0,0,1};
	static int[] dy = {-1,1,0};
	static void dfs(int x, int y,int cnt, int sum,int[][] map,boolean[][] visit) {
		if(cnt==4) {
			max = max<sum? sum:max;
			return;
		}
		
		for(int i=0;i<3;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
				visit[nx][ny] = true;
				dfs(nx,ny,cnt+1,sum+map[nx][ny],map,visit);
				visit[nx][ny] = false;
			}
		}
	}
}
