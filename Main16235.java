import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16235 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		int[][] A = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5; //초기맵 5
			}
		}
		
		PriorityQueue<Tree> q = new PriorityQueue<>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			q.offer(new Tree(x,y,age));
		}

		System.out.println(simulation(map,A,q,N,K));
	}
	
	static int simulation(int[][] map,int[][] A,PriorityQueue<Tree> q,int N,int K) {
		int[] dx = {-1,-1,-1,0,0,1,1,1};
		int[] dy = {-1,0,1,-1,1,-1,0,1};
		
		for(int year=0;year<K;year++) {
			//봄
			Queue<Tree> dead = new LinkedList<>();
			Queue<Tree> live = new LinkedList<>();
			while(!q.isEmpty()) {
				Tree p = q.poll();
				if(p.age<=map[p.x][p.y]) {
					map[p.x][p.y]-=p.age; 
					p.age+=1;
					live.add(p);
					
				}else {
					dead.offer(p);
				}
			}
			//여름
			while(!dead.isEmpty()) {
				Tree p = dead.poll();
				map[p.x][p.y]+=p.age/2; 
			}
			
			//가을
			int size = live.size();
			for(int i=0;i<size;i++) {
				Tree p = live.poll();
				if(p.age%5==0) {
					for(int j=0;j<8;j++) {
						int nx = p.x+dx[j];
						int ny = p.y+dy[j];
						
						if(nx>=0 && ny>=0 && nx<N && ny<N) {
							q.offer(new Tree(nx,ny,1));
						}
					}
				}
				q.offer(p);
			}
			//겨울
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j] +=A[i][j];
				}
			}
		}
		
		return q.size();
	}
	
	static class Tree implements Comparable<Tree>{
		int x,y;
		int age;
		public Tree(int x, int y, int age) {
			super();
			this.x = x;
			this.y = y;
			this.age = age;
		}
		
		@Override
		public int compareTo(Tree o) {
			return this.age-o.age;
		}
		
		
	}
}
