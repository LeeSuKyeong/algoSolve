import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14501_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] arr = new int[N+2];
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = 0;
		for(int i=1;i<=N;i++) {
			int n = arr[i]+P[i];
			for(int j=i+T[i];j<=N+1;j++) {
				arr[j]=arr[j]<n?n:arr[j];
				max = max<n?n:max;
			}
		}
		
		System.out.println(max);
	}
	
}
