import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main9466 {
	static int[] visit;
	static int[] arr;
	static boolean[] s;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			arr = new int[N+1];
			visit = new int[N+1];
			s = new boolean[N+1];
			
			for(int i=1;i<=N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			StringBuilder sb;
			for(int i=1;i<=N;i++) {
				if(visit[i]==0) {
					dfs(i,i,1);		
				}
			
			}
			System.out.println(arr.length -1- cnt);
		}
	}
	static void dfs(int idx,int sIdx,int count) {
		if(s[idx]) { //예전 dfs에서 했던 곳이면
			return;
		}
		if(visit[idx]!=0) {
			cnt+=count-visit[idx]; //현재 count - 방문했을때 count
			
			return;
		}
		
		visit[idx] = count; //몇번째로방문했는지
		dfs(arr[idx],sIdx,count+1);
		s[idx] = true;//i번째 dfs때 방문했던 idx를 다음 dfs 때 또 탐색하기 방지용
	}
}
