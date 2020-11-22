import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[x][y];
		
		for(int i=0;i<x;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int max = 0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(map[i][j] =='L') {
					int[][] visit = new int[x][y];
					int tmp = bfs(i,j,map,visit); 
					if(max<tmp) max = tmp;
				}
			}
		}
		

		System.out.println(max-1);
	}
	
	static int x,y;
	static int[] dx ={-1,0,1,0};
	static int[] dy ={0,-1,0,1};
	static int tmpx = 0,tmpy=0;
	
	static int bfs(int sx, int sy,char[][] map,int[][] visit) {
		int tmpmax = 0;
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(sx,sy));
		visit[sx][sy] = 1;
		
		while(!q.isEmpty()){
			
			Pos p = q.poll();
			
			for(int i=0;i<4;i++){
				
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<x&& ny<y && map[nx][ny] =='L' && visit[nx][ny] ==0){
					
					visit[nx][ny] = visit[p.x][p.y]+1;
					q.offer(new Pos(nx,ny));
					
					if(visit[nx][ny] > tmpmax){
						tmpmax = visit[nx][ny];
					}
				}
			}
		}
		
		return tmpmax;
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
