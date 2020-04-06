import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] tmp = new int[n][n];
		tmp[0][0]=arr[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<i+1;j++) {
				tmp[i][j] = arr[i][j] + Math.max(tmp[i-1][j], j-1>=0?tmp[i-1][j-1]:0);
			}
		}
	
		Arrays.sort(tmp[n-1]);
		System.out.println(tmp[n-1][n-1]);
	}
	
}
