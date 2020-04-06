import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16236 {

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int[][] map;
	static int time;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
	
		int N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		int sx = 0,sy = 0;
		
		for(int i=0;i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					sx =i;
					sy =j;
					map[i][j] = 0;
				}
			}
		}
		Shark s = new Shark(2, 0,sx,sy,0);
		solve(s,N);
		
		System.out.println(time);
		
	}
	
	static void solve(Shark ss,int N) {
		
		Shark s =ss;
		Queue<Shark> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		visit[s.x][s.y]= true; 
		q.offer(s);
		int minDist = Integer.MAX_VALUE;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		//상어가 먹을수있는거 찾기
		//가장 가까운물고기
		label:while(!q.isEmpty()) {
			Shark p = q.poll();
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny]) {
					visit[nx][ny] = true;
					if(map[nx][ny]>0 && p.size>map[nx][ny]) {
						if(minDist<p.time+1) {
							break label;
						}
						minDist =p.time+1;
						pq.offer(new Node(nx,ny,p.time+1));
					}else if(map[nx][ny]==0 || p.size==map[nx][ny]) {
						q.offer(new Shark(p.size,p.cnt,nx,ny,p.time+1));
					}

				}
			}
		}
		//먹을물고기
		if(!pq.isEmpty()) {
			Node fish = pq.poll();
			time += fish.dist;
			map[fish.x][fish.y]= 0; 
			if(s.cnt+1 == s.size) {
				s= new Shark(s.size+1, 0, fish.x, fish.y,0);
			}else {
				s = new Shark(s.size, s.cnt+1, fish.x, fish.y,0);
			}
			
			solve(s,N);
		}

		
	}
	static class Shark{
		int size,cnt,x,y,time;

		public Shark(int size, int cnt, int x, int y,int time) {
			super();
			this.size = size;
			this.cnt = cnt;
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	static class Node implements Comparable<Node>{
		int x,y,dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			return this.x==o.x?this.y-o.y:this.x-o.x;
		}
		
		
	}
	
}
