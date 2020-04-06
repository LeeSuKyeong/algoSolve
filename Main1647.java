import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1647 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N  = Integer.parseInt(st.nextToken());
		int M  = Integer.parseInt(st.nextToken());
		
		int cost = 0;
		PriorityQueue<Info> q = new PriorityQueue<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a>b) {
				int temp = a;
				a = b;
				b = temp;
			}
			
			q.offer(new Info(a,b,c));
		}
		
		int[] parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		int cnt = 0;
		while(!q.isEmpty()) {
			Info p  = q.poll();
			
			//union
			int parentA = find(p.a,parent);
			int parentB = find(p.b,parent);
			
			if(parentA !=parentB) {
				parent[parentA] = parentB;
				cost += p.c;
				cnt++;
				
				if(cnt ==N-2) {
					break;
				}
			}
		}
		System.out.println(cost);
		
	}
	
	
	static int find(int x,int[] parent) {
		
		if(parent[x] == x) {
			return x;
		}else {
			return parent[x] = find(parent[x],parent);
		}
	}
	
	static class Info implements Comparable<Info>{
		int a,b,c;

		public Info(int a, int b, int c) {
			super();
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Info o) {
			return this.c-o.c;
		}
	}
}
