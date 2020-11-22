import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14889 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		table = new int[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean[] visit = new boolean[N];
		comb(0, -1, visit);
		System.out.println(min);
	}

	static int N,min=Integer.MAX_VALUE;
	static int[][] table;
	static void comb(int cnt,int idx,boolean[] visit) {
		if(cnt>N/2) return;
		
		if(cnt ==N/2) {
			int team1=0,team2=0;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if(visit[i] && visit[j]) team1+=table[j][i]+table[i][j];
					if(!visit[i] && !visit[j]) team2+=table[j][i]+table[i][j];
				}
			}
			
			min = Math.min(min, Math.abs(team2-team1));
			return;
		}
		
		for(int i=idx+1;i<N;i++) {
			visit[i] = true;
			comb(cnt+1,i,visit);
			visit[i] = false;
		}
	}
}
