import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main13023 {
	static int N,M,result=0;
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N];
		for(int i=0;i<N;i++) {
			map[i] = new ArrayList<>();
		}
		visit = new boolean[N];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			map[a].add(b);
			map[b].add(a);
		}
		
		for(int i=0;i<N;i++) {
			dfs(i,0);
			if(result == 1) {
				break;
			}
		}
		System.out.println(result);

	}
	static void dfs(int idx,int cnt) {
		if(result == 1) {
			return;
		}
		if(cnt == 5) {
			result = 1;
			return;
		}
		
		for(int i=0;i<map[idx].size();i++) {
			if(!visit[map[idx].get(i)]) {
				visit[map[idx].get(i)]=true;
				dfs(map[idx].get(i),cnt+1);
				visit[map[idx].get(i)]=false;
			}
		}

	}
}
