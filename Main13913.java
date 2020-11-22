import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main13913 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] visit = new int[100000+1];
		int[] parent = new int[100000+1];
		
		int time = go(N,K,visit,parent);
		
		int[] arr = new int[time];
		
		StringBuilder sb = new StringBuilder();
		int idx = 0;
		int n = K;
		while(n !=N) {
			arr[idx++] = n;
			n = parent[n];
		}
		arr[idx] = N;
		
		sb.append(time-1).append('\n');
		for(int i=time-1;i>=0;i--) {
			sb.append(arr[i]).append(' ');
		}
		System.out.println(sb.toString());
	}

	static int go(int N, int K, int[] visit,int[] parent) {
		int[] dx = {-1,1};
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		visit[N] = 1;
		
		int p = 0;
		while(!q.isEmpty()) {
			
			p = q.poll();
			for(int i=0;i<3;i++) {
				int nx;
				if(i==2) nx = p*2;
				else nx = p+dx[i];

				if(nx>=0 && nx<=100000 && visit[nx]==0) {					
					q.offer(nx);
					visit[nx] =visit[p]+1;
					parent[nx] = p;
					if(nx == K) break;
				}
			}
		}
		
		return visit[K];
	}
}
