import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1949_bfs {
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
						bfs(i,j);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(max).append('\n');
		}
		
		System.out.println(sb);
	}
	static boolean[][] copy(boolean[][] f){
		boolean[][] t = new boolean[f.length][f.length];
		for(int i=0;i<f.length;i++) {
			for(int j=0;j<f.length;j++) {
				t[i][j] = f[i][j];
			}
		}
		return t;
	}
	static void bfs(int x, int y) {
		
		boolean[][] visit = new boolean[N][N];
		visit[x][y] = true;
		Queue<Info> q = new LinkedList<Info>();
		q.offer(new Info(x,y,map[x][y],false,visit));
		
		int len = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				Info p = q.poll();
	
				for(int j=0;j<4;j++) {
					int nx = p.x+dx[j];
					int ny = p.y+dy[j];
					if(nx>=0 &&ny>=0 && nx<N && ny<N && !p.visit[nx][ny] ) {
						if(p.h> map[nx][ny]) {
							boolean[][] t = copy(p.visit);
							t[nx][ny] = true;
							q.offer(new Info(nx,ny,map[nx][ny],p.f,t));
						}else {
							for(int k=1;k<=K;k++) {
								if(!p.f && p.h>map[nx][ny]-k) {
									boolean[][] t = copy(p.visit);
									t[nx][ny] = true;
									q.offer(new Info(nx,ny,map[nx][ny]-k,true,t));
								}
							}
						}

					}
				}
			}
			len++;
		}
		max = len<max?max:len;
	}
	static class Info{
		int x,y,h;
		boolean f;
		boolean[][] visit;
		
		public Info(int x, int y, int h, boolean f, boolean[][] visit) {
			super();
			this.x = x;
			this.y = y;
			this.h = h;
			this.f = f;
			this.visit = visit;
		}
		
	}
	
}
