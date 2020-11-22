import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[][] arr =new boolean[N+1][N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = true;
		}

		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j) continue;
					arr[i][j] =arr[i][j] | (arr[i][k] & arr[k][j]); 
				}
			}
		}
		
		int cnt =0;
		int ans =0;

		for(int i=1;i<=N;i++) {
			cnt =0;
			for(int j=1;j<=N;j++) {				
				if(arr[i][j]) {
					cnt++;
				}
				if(arr[j][i]) {
					cnt++;
				}
			}
			if(cnt== N-1) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}
