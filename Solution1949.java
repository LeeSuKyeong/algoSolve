import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1949 {
	static int[][] map;
	static int[] dx= {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N,K,max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N= Integer.parseInt(st.nextToken());
			K= Integer.parseInt(st.nextToken());
			max =0;
			map = new int[N][N];

			int heap=1;
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					heap= heap<map[i][j]?map[i][j]:heap;
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(heap == map[i][j]) {
						boolean[][] visit = new boolean[N][N];
						visit[i][j] = true;
						dfs(i,j,map[i][j],visit,false,1);
						visit[i][j] = false;
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int x, int y,int h,boolean[][] visit,boolean f,int len) {
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 &&ny>=0 && nx<N && ny<N && !visit[nx][ny] ) {
				
				if(h > map[nx][ny]) {
					visit[nx][ny] = true;
					dfs(nx,ny,map[nx][ny],visit,f,len+1);
					visit[nx][ny] = false;
				}else {
					for(int j=1;j<=K;j++) {
						if(!f && h>map[nx][ny]-j) {
							visit[nx][ny] = true;
							dfs(nx,ny,map[nx][ny]-j,visit,true,len+1);
							visit[nx][ny] = false;
						}
					}
					
				}
			}
			
		}
		max=max<len?len:max;
	}
}
