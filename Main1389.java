import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1389 {
	static boolean[] visit;
	static int[][] arr;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		
		int A,B;
		arr = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr[A][B] = 1;
			arr[B][A] = 1;
		}
		int result = 0;
		int dist = Integer.MAX_VALUE;
		int temp;
		for(int i=1;i<=N;i++) {
			visit = new boolean[N+1];
			temp = bfs(i);
			if(dist>temp) {
				result = i;
				dist = temp;
			}
		}
		
		System.out.println(result);
	}
	
	static int bfs(int start) {
		int cnt = 0;
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(start,0));
		visit[start]=true;
		
		while(!q.isEmpty()) {
			Info v = q.poll();
			cnt += v.d;
			for(int i=1;i<=N;i++) {
				if(arr[v.v][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.offer(new Info(i,v.d+1));
				}
			}
		}
		return cnt;
	}
	
	static class Info{
		int v;
		int d;
		public Info(int v, int d) {
			super();
			this.v = v;
			this.d = d;
		}
	}

}
