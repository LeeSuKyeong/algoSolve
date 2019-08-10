import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468 {
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visit;
	static int[][] map;
	static int count=0;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map =new int[N][N];
		int maxH=0;
		int minH=0;
		int maxCount =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = maxH<map[i][j]?map[i][j]:maxH;
				minH = minH>map[i][j]?map[i][j]:minH;
			}
		}
		
		for(int h=minH;h<maxH;h++) {
			visit = new boolean[N][N];
			count = 0;
			//침수시키자
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j] && map[i][j] > h) {
						bfs(i,j,h);
					}
				}
			}
			maxCount= maxCount<count?count:maxCount;
		}
		System.out.println(maxCount);
		
	}
	static void bfs(int x,int y,int h) {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(x,y));
		visit[x][y] = true;
		
		count++;
		while(!q.isEmpty()) {
			Pos p = q.poll();

			for(int i=0;i<4;i++) {
				int nx = p.x +dx[i]; 
				int ny = p.y +dy[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] >h && !visit[nx][ny]) {
					visit[nx][ny] = true;
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

