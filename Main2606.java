import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		boolean[] visit = new boolean[N+1]; 
		visit[1] = true;
		dfs(1,arr,visit);
		System.out.println(cnt);
	}
	static int cnt = 0;
	static void dfs(int n,ArrayList<Integer>[] arr,boolean[] visit) {
		ArrayList<Integer> l = arr[n];
		int size= l.size();
		for(int i=0;i<size;i++) {
			
			if(!visit[l.get(i)]) {
				visit[l.get(i)] =true;
				cnt++;
				dfs(l.get(i),arr,visit);
			}
		}
		
	}
}
