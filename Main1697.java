import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1697 {
	static boolean[] visit;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		visit = new boolean[100000 + 1];
		
		if(N==K) {
			cnt = 0;
		}else {
			bfs(N,K);
		}
		System.out.println(cnt);
	}
	
	static void bfs(int N,int K) {
		Queue<Info> q = new LinkedList<>();
		visit[N] = true;
		q.offer(new Info(N,0));
		
		while(!q.isEmpty()) {
			Info n = q.poll();
			if(n.x -1 == K || n.x+1 == K || n.x*2 == K) {
				cnt = n.time+1;
				return;
			}
			
			if(n.x-1>=0 && !visit[n.x-1]) {
				visit[n.x] = true;
				q.offer(new Info(n.x-1,n.time+1));
			}
			
			if(n.x+1 <=100000 && !visit[n.x+1]) {
				visit[n.x+1] = true;
				q.offer(new Info(n.x+1,n.time+1));
			}
			
			if(n.x*2 >0 && n.x*2 <=100000 && !visit[2*n.x]) {
				visit[2*n.x] = true;
				q.offer(new Info(2*n.x,n.time+1));
			}
		}
	}
	static class Info{
		int x,time;

		public Info(int x, int time) {
			super();
			this.x = x;
			this.time = time;
		}
		
	}
}
