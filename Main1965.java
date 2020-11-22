import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1965 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] cnt = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[i] = 1;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && cnt[i]<cnt[j]+1) {
					cnt[i] = cnt[j]+1;
				}
			}
		}
		
		Arrays.sort(cnt);
		System.out.println(cnt[cnt.length-1]);
	}

}
