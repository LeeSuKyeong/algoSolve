import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7965{
	static long[] arr;
	static long mod =  1000000007;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int[] N = new int[T+1];
		int maxN=0;
		for (int tc = 1; tc <= T; tc++) {
			N[tc] = Integer.parseInt(br.readLine());
			maxN = maxN<N[tc]?N[tc]:maxN;
		}
		
		arr = new long[maxN+1];
		for(int i=1;i<=maxN;i++) {
			arr[i] +=(arr[i-1]+pow(i,i))%mod;
		}
		
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc + " " + arr[N[tc]]);
		}
			
	}
	
	static long pow(int n, int pow) {

		if(pow == 1) {
			return n;
		}
		long temp = pow(n,pow/2);
		long np;
		if(pow % 2==0) {
			np =  (temp * temp)%mod;
		}else {
			np =((temp* temp)%mod * n%mod)%mod;
		}
		
		return np;
	}
	
	
}
