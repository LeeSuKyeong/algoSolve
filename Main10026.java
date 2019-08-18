import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main10026 {

	static boolean[][] visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		char[][] bMap = new char[N][N];
		visit = new boolean[N][N];
		int cnt1 = 0,cnt2=0;
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<N;j++) {
				bMap[i][j] = map[i][j] =='G'?'R':map[i][j]; 
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					bfs(i,j,map[i][j],map);
					cnt1++;
				}
			}
		}//색맹x
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visit[i][j]) {
					bfs(i,j,bMap[i][j],bMap);
					cnt2++;
				}
			}
		}//색맹
		System.out.println(cnt1 + " " + cnt2);
		
	}
	
	static void bfs(int x, int y,char c,char[][] arr) {
		Pos p;
		int nx,ny;
		
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(x,y));
		visit[x][y] =true;
		while(!q.isEmpty()) {
			p = q.poll();
			for(int i=0;i<4;i++) {
				nx = p.x + dx[i];
				ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && arr[nx][ny] ==c){
					visit[nx][ny] = true;
					q.offer(new Pos(nx,ny));
				}
					
				
			}
		}
	}
	
	static class Pos{
		int x,y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

}
