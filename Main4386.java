import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4386 {
	static int[] parent;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double[][] map = new double[N][2];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			map[i][0] = x;
			map[i][1] = y;
		}
		
		PriorityQueue<Info> q = new PriorityQueue<>();
		for(int i=0;i<N-1;i++) {
			double x1 = map[i][0];
			double y1 = map[i][1];
			for(int j=i+1;j<N;j++) {
				double x2 = map[j][0];
				double y2 = map[j][1];
				
				double dist = Math.sqrt(Math.pow(Math.abs(x1-x2),2) + Math.pow(Math.abs(y1-y2),2));
				
				q.offer(new Info(i,j,dist));
			}
		}
		
		parent = new int[N];
		for(int i=0;i<N;i++) {
			parent[i] = i;
		}
		
		double result = 0;
		while(!q.isEmpty()) {
			Info p = q.poll();
			
			result += union(p);
			
			if(cnt==N-1) {
				break;
			}
		}
		
		System.out.printf("%.2f",result);
	}
	
	static double union(Info p) {
		
		int parentA = find(p.a);
		int parentB = find(p.b);
		
		if(parentA != parentB) {
			parent[parentA] = parentB;
			cnt++;
			return p.w;
		}else {
			return 0;
		}
	}
	
	static int find(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return find(parent[x]);
		}
	}
	static class Info implements Comparable<Info>{
		int a,b;
		double w;

		
		public Info(int a, int b, double w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Info o) {
			return this.w - o.w<0? -1:1;
		}

		
	}
	
}
