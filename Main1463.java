import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		int[] dp = new int[X+1];
		Arrays.fill(dp, X);
		dp[1] = 0;
		for(int i=2;i<=X;i++) {
			
			if(dp[i-1]+1<dp[i]) {
				dp[i] = dp[i-1]+1;				
			}
			
			if(i%2==0 && dp[i/2]+1<dp[i] ) {
				dp[i] = dp[i/2]+1;				
			}
			
			if(i%3==0 && dp[i/3]+1<dp[i] ) {
				dp[i] = dp[i/3]+1;				
			}
		}
		
		System.out.println(dp[X]);
	}
	
}
