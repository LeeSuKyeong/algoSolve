import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9372 {
	static int[] parent;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			ans = 0;
			parent = new int[N+1];
			for(int i=1;i<=N;i++) {
				parent[i] = i;
			}
			
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a= Integer.parseInt(st.nextToken());
				int b= Integer.parseInt(st.nextToken());
				
				unionset(a,b);
			}
			
			System.out.println(ans);
		}
		
	}
	
	
	
	static void unionset(int a, int b) {
		int parentA = findset(a);
		int parentB = findset(b);
		if(parentA == parentB) {
			return;
		}else {
			parent[parentA] = parentB;
			ans++;
		}
	}
	
	static int findset(int x) {
		if(x != parent[x]) {
			return findset(parent[x]);
		}else {
			return x;
		}
	}
	
}
