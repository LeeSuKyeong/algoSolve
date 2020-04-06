import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11047 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coin = new int[N];
		for(int i=0;i<N;i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		dfs(K,coin,N-1,K,0);
		System.out.println(min);
	}
	
	static int min = Integer.MAX_VALUE;
	static void dfs(int K, int[] coin,int idx,int rem, int cnt) {
		if(rem==0) {
			min =min<cnt?min:cnt;
			return;
		}else if(rem<0) return;
		if(idx <0) return;
		
		dfs(K,coin,idx-1,rem-(rem/coin[idx])*coin[idx],cnt+(rem/coin[idx]));
	}
}
