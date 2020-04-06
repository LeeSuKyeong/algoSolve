import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1922 {
	static int[] parent;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		cnt = 0;
		
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		
		PriorityQueue<Info> q = new PriorityQueue<>();
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
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

		while(!q.isEmpty()) {
			Info p = q.poll();
			
			int parentA = find(p.a);
			int parentB = find(p.b);
			
			union(parentA,parentB,p.w);
		}
		
		System.out.println(cnt);
	}
	
	static void union(int a, int b,int w) {
		if(a != b) {
			parent[a] = b;
			cnt += w;
		}
	}
	static int find(int x) {
		
		if(x == parent[x]) {
			return x;
		}else {
			return find(parent[x]);
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
