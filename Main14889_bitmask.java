import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14889_bitmask {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] table = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int team1=0,team2=0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<(1<<N);i++) {
			if(Integer.bitCount(i)==N/2) {
				team1 = 0;
				team2 = 0;
				for(int j=0;j<N;j++) {
					for(int k=j+1;k<N;k++) {
						if(((i>>j) &1) ==0 && ((i>>k) &1) ==0) {
							team1 += table[j][k] + table[k][j];
						}else if(((i>>j) &1) ==1 && ((i>>k) &1) ==1) {
							team2 += table[j][k] + table[k][j];
						}
					}
				}
				
				int diff =Math.abs(team2-team1); 
				min = min<diff?min:diff;
			}
		}
		
		System.out.println(min);
	}

}
