import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9205 {
	static int N;
	static int[][] store;
	static boolean go;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			go = false;
			store = new int[N+2][2];
			for(int i=0;i<N+2;i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}			
			boolean[] visit = new boolean[N+2];
			dfs(0,visit);
			
			System.out.println(go?"happy":"sad");
			
		}
	}

	static void dfs(int idx,boolean[] visit) {
		visit[idx] = true;
		int x = store[idx][0];
		int y= store[idx][1];
		if(x==store[N+1][0] && y == store[N+1][1]) {
			go=true;
			return;
		}
		for(int i=1;i<N+2;i++) {
			if(Math.abs(x-store[i][0]) + Math.abs(y-store[i][1])<=1000) {
				if(!visit[i]) {
					dfs(i,visit);
				}
				
			}
		}
		return;
	}
}
