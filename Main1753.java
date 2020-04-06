import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());//시작번호
		boolean[] visit = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, INF);
		
		ArrayList<Info>[] arr = new ArrayList[V+1];
		for(int i=1;i<=V;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			arr[f].add(new Info(t,w));
		}
		
		//다익스트라
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.offer(new Info(K,0));
		dist[K] = 0;
		
		while(!pq.isEmpty()) {
			Info v= pq.poll();
			if(visit[v.v]) {
				continue;
			}
			visit[v.v] = true;
			for(int i=0;i<arr[v.v].size();i++) {
				int n = arr[v.v].get(i).v;
				int w = arr[v.v].get(i).w;
				
				if( dist[n]>dist[v.v]+w) {
					dist[n] = dist[v.v]+w;
					pq.offer(new Info(n,dist[n]));
				}
			}
		}
		
		for(int i=1;i<=V;i++) {
			if(dist[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
	}
	
	static class Info implements Comparable<Info> {
		int v,w;
		
		public Info(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return this.w - o.w;
		}

	}
	
}
