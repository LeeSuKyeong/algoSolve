import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472 {
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	static int[][] map,dist;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map= new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num=1;
		//labeling
		boolean[][] visit = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] != 0 && !visit[i][j]) {
					bfs(i,j,visit,num);
					num++;
				}
			}
		}
		
		//다리길이 구하기
		dist = new int[num][num];
		for(int i=1;i<num;i++) {
			for(int j=1;j<num;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
			
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] !=0) {					
					for(int k=2;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] ==0) {
								check(k,map[i][j],i,j);
						}
					}
				}
			}
		}
		//다리연결(mst)
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for(int i=1;i<num;i++) {
			for(int j=i+1;j<num;j++) {
				if(dist[i][j] != Integer.MAX_VALUE) {
					pq.offer(new Info(i,j,dist[i][j]));
				}
			}
		}

		int result=0;
		int[] parent = new int[num];
		for(int i=1;i<num;i++) {
			parent[i] =i;
		}
		
		int cnt = 0;
		while(!pq.isEmpty() && cnt<num-1) {
			Info p = pq.poll();
			if(union(p.f,p.t,parent)) {
				result+=p.d;
				cnt++;
			}
		}
		
		//모든 부모가 같은지 확인
		int p = parent[1];
		for(int i=2;i<num;i++) {
			if(find(parent[i],parent) !=p) {
				result =-1;
				break;
			}
		}
		System.out.println(Arrays.toString(parent));
		System.out.println(result);
	}
	
	static void bfs(int x,int y, boolean[][] visit,int num) {
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(x,y));
		visit[x][y] = true;
		map[x][y] = num;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N&& ny<M) {
					if(!visit[nx][ny] && map[nx][ny]!=0) {
						
						visit[nx][ny]=true;
						map[nx][ny] = num;
						q.offer(new Pos(nx,ny));
					}
				}
			}
		}
	}
	static boolean union(int a, int b,int[] parent) {
		int pa=find(a,parent);
		int pb=find(b,parent);
		if(pa!=pb) {
			if(pa<pb) {
				parent[pb]=pa;
				
			}else {
				parent[pa]=pb;
			}

			return true;
		}
		return false;
	}
	
	static int find(int a,int[] parent) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a],parent);
	}
	static void check(int d,int f,int x,int y) {
		
		int nx = x;
		int ny =y;
		int cnt=0;
		
		while(true) {
			nx+=dx[d];
			ny+=dy[d];
			cnt++;
			if(nx==N || ny==M) {
				break;
			}else if(map[nx][ny] !=0) {
				if(cnt==2) {
					break;
				}
				
				if(dist[f][map[nx][ny]]<cnt-1) {
					break;
				}else {
					dist[f][map[nx][ny]]=cnt-1;
					dist[map[nx][ny]][f]=cnt-1;					
				}
				
				break;
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
	static class Info implements Comparable<Info> {
		int f,t,d;

		public Info(int f, int t, int d) {
			super();
			this.f = f;
			this.t = t;
			this.d = d;
		}

		@Override
		public int compareTo(Info o) {
			return this.d -o.d;
		}
		
	}
}
