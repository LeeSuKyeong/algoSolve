import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1197 {
	static int[] parent;
	static int cnt,cost;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		cnt = 0;
		cost = 0;
		
		PriorityQueue<Info> q = new PriorityQueue<>();
		for(int i=0;i<E;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(a>b) {
				int temp = a;
				a = b;
				b = temp;
			}
			q.offer(new Info(a,b,w));
		}

		parent = new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
		
		while(!q.isEmpty() && cnt<V-1) {
			Info p = q.poll();
			
			union(p);
		}
		
		System.out.println(cost);
	}
	
	static void  union(Info p) {
		int pA = find(p.a);
		int pB = find(p.b);
		
		if(pA != pB) {
			parent[pA] = pB;
			cnt++;
			cost += p.w;
		}
	}
	static int find(int x) {
		if(x==parent[x]) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	static class Info implements Comparable<Info>{
		int a,b,w;

		public Info(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return this.w-o.w;
		}
		
		
	}
}
