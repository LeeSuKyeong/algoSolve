import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {

	static int L,R,C;
	static char[][][] map;
	static boolean[][][] visit;
	static int[][] d = {{0,1,0},{0,-1,0},{1,0,0},{-1,0,0},{0,0,1},{0,0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sx = 0,sy = 0,sz = 0;
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			if(L==0 && R==0 && C==0) {
				break;
			}
			
			map = new char[R][C][L];
			visit = new boolean[R][C][L];
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					String temp = br.readLine();
					for(int k=0;k<C;k++) {
						map[j][k][i] = temp.charAt(k);
						if(map[j][k][i] =='S') {
							sx = j;
							sy = k;
							sz = i;
						}
					}
				}
				br.readLine();
			}
		
			int result = bfs(sx,sy,sz);
			System.out.println(result==0?"Trapped!":("Escaped in " + result + " minute(s)."));
		}
		
	}
	
	static int bfs(int sx,int sy,int sz) {
		Pos p;
		int nx,ny,nz;
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(sx,sy,sz,0));
		visit[sx][sy][sz] = true;
		
		while(!q.isEmpty()) {
			p = q.poll();
			for(int i=0;i<6;i++) {
				nx = p.x + d[i][0];
				ny = p.y + d[i][1];
				nz = p.z + d[i][2];
				
				if(nx>=0 && ny>=0 && nz>=0 && nx<R && ny<C && nz<L && map[nx][ny][nz] != '#' &&!visit[nx][ny][nz]) {
					if(map[nx][ny][nz] == 'E') {
						return p.time+1;
					}
					visit[nx][ny][nz] = true;
					q.offer(new Pos(nx,ny,nz,p.time+1));
				}
			}
			
		}
		
		return 0;
	}

	static class Pos{
		int x,y,z,time;

		public Pos(int x, int y, int z,int time) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.time = time;
		}
		
	}
}
