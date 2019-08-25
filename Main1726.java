import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1726 {
	static int[][] map ;
	static boolean[][][] visit;
	static int[] dx = {0,0,0,1,-1};
	static int[] dy = {0,1,-1,0,0};
	static int M,N,result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M  = Integer.parseInt(st.nextToken());
		N  = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visit= new boolean[M][N][4+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int[] start = new int[3];
		for(int i=0;i<3;i++) {
			start[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int[] end= new int[3];
		for(int i=0;i<3;i++) {
			end[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs(start,end);
		System.out.println(result);
	}
	static void bfs(int[] start,int[] end) {
		Queue<Pos> q = new LinkedList<>();
		visit[start[0]-1][start[1]-1][start[2]]=true;
		q.offer(new Pos(start[0]-1,start[1]-1,0,start[2]));
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.x == end[0]-1 && p.y==end[1]-1 && p.dir == end[2]) {
				result = p.cnt;
				return;
			}
			int nx = p.x;
			int ny = p.y;
			for(int i=0;i<3;i++) {//command 1 (k=0~3)
				nx += dx[p.dir];
				ny += dy[p.dir];
				if(nx>=0 && ny>=0 && nx<M && ny<N) {
					if(map[nx][ny] == 0 && !visit[nx][ny][p.dir]) {
						visit[nx][ny][p.dir] = true;
						q.offer(new Pos(nx,ny,p.cnt+1,p.dir));
					}else if(map[nx][ny] ==1){
						break;
					}
				}
			}
			
			
			if(p.dir==1 && !visit[p.x][p.y][3]){
				visit[p.x][p.y][3]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,3)); //command 2. R;
			}else if(p.dir==3 && !visit[p.x][p.y][2]){
				visit[p.x][p.y][2]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,2)); //command 2. R;
			}else if(p.dir==2 && !visit[p.x][p.y][4]){
				visit[p.x][p.y][4]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,4)); //command 2. R;
			}else if(p.dir==4 && !visit[p.x][p.y][1]){
				visit[p.x][p.y][1]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,1)); //command 2. R;
			}
			
			if(p.dir==1 && !visit[p.x][p.y][4]){
				visit[p.x][p.y][4]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,4)); //command 2. R;
			}else if(p.dir==4 && !visit[p.x][p.y][2]){
				visit[p.x][p.y][2]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,2)); //command 2. R;
			}else if(p.dir==2 && !visit[p.x][p.y][3]){
				visit[p.x][p.y][3]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,3)); //command 2. R;
			}else if(p.dir==3 && !visit[p.x][p.y][1]){
				visit[p.x][p.y][1]=true;
				q.offer(new Pos(p.x,p.y,p.cnt+1,1)); //command 2. R;
			}

		}
	}
	
	static class Pos{
		int x;
		int y;
		int cnt;
		int dir;
		public Pos(int x, int y, int cnt,int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dir = dir;
		}
		
	}
}
