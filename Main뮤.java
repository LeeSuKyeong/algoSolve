import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main뮤 {
	static int[][] map,visit;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int N,M,minTime;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}

		bfs();
		for(int i=0;i<N;i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		System.out.println(minTime);
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.offer(new Pos(0,0,false));
		visit[0][0] = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(p.x == N-1 && p.y == N-1) {
				minTime = minTime<visit[N-1][N-1]?minTime:visit[N-1][N-1];
				
			}
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N && visit[p.x][p.y]<visit[nx][ny]) {
					if(map[nx][ny] == 1) {			//일반땅			
						q.offer(new Pos(nx,ny,p.use));
						visit[nx][ny] = visit[p.x][p.y]+1;
					}else {
						//현재위치가 오작교 or절벽
						if(map[p.x][p.y]!=1 ) {
							continue;
						}
						
						//일반땅에서 오작교
						if(map[nx][ny] >=2) {
							if((visit[p.x][p.y]+1)%map[nx][ny] ==0) {
								q.offer(new Pos(nx,ny,p.use));
								visit[nx][ny] = visit[p.x][p.y]+1;
							}else {
								q.offer(new Pos(p.x,p.y,p.use));
								visit[p.x][p.y]++; 
							}
						}else {//일반땅에서 절벽

							if(p.use) {//이미 오작교 사용했으면
								continue;
							}

							int cnt = 0;
							int temp = map[nx][ny];
							for(int k=0;k<4;k++) {
								int nnx = temp+dx[k];
								int nny = temp+dy[k];
								if(nnx>=0 && nny>=0 && nnx<N && nny<N && map[nnx][nny] ==0) {
									cnt++;
								}
							}
							if(cnt>=2) { //절벽 교차지점
								continue;
							}
							System.out.println("mmmm?"+ p.x + " " + p.y );
							if((visit[p.x][p.y]+1) % M == 0) {
								q.offer(new Pos(nx,ny,true));
								visit[nx][ny] = visit[p.x][p.y]+1;
							}else {
								q.offer(new Pos(p.x,p.y,false));
								visit[p.x][p.y]++; 
							}

						}
					}
				}
			}
		}
	}

	static class Pos{
		int x,y;
		boolean use;

		public Pos(int x, int y, boolean use) {
			super();
			this.x = x;
			this.y = y;
			this.use = use;
		}



	}
}
