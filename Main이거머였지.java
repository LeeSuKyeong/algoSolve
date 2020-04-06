import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main이거머였지 {
	static boolean[] visit;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int f = st.nextToken().charAt(0)-'A';
			int t = st.nextToken().charAt(0)-'A';
			
			int dist = Integer.parseInt(st.nextToken());
			arr[f][t] = dist;
			arr[t][f] = dist;
		}
		
		visit[0] = true;
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		for(int i=0;i<N;i++) {
			if(arr[0][i]!=0) {
				visit[i] = true;
				sb.append(i);
				dfs(i,k-arr[0][i],0,arr,sb);
				sb.deleteCharAt(sb.length()-1);
				visit[i] = false;
			}
		}
	}
	
	static void dfs(int idx,int k, int money,int[][] arr,StringBuilder sb) {
		
		if(idx == N-1) {
			//계산
			StringBuilder s = new StringBuilder();
			for(int i=0;i<sb.length();i++) {
				s.append((char)(sb.charAt(i)-'0'+'A'));
			}
			
			System.out.println(s);
			int totalMoney = money + 300;
			int oil = k+10;
			System.out.println(k + " " + totalMoney);
		}
		
		for(int i=0;i<N;i++) {
			if(arr[idx][i] !=0 && !visit[i]) {
				visit[i] = true;
				sb.append(i);
				dfs(i,k-arr[idx][i]+10,money+200,arr,sb);
				sb.deleteCharAt(sb.length()-1);
				visit[i] = false;
			}
		}
	}
}
