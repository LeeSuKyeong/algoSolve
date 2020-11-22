import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1592 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N];
		int idx = 0;
		int cnt=-1;
		while(true) {
			cnt++;
			arr[idx]++;
			if(arr[idx] ==M) {
				break;
			}
			if(arr[idx] %2==0) {
				idx = (idx-L+N)%N;
			}else {
				idx = (idx+L)%N;
			}
			
		}
		
		System.out.println(cnt);
	}
}
