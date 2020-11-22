import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1300 {
/*
 * i*j<=mid이므로 i행의 mid보다 작은 수의 개수는  mid/i ;
 * nxn행이므로 i행에서 mid보다 작은 수의 최대 개수는 n
 * math.min(mid/i,n)
 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int f = 1;
		int e = k;
		int mid,cnt;
		while(f<=e) {
			mid = (f+e)/2;
			cnt = 0;
			
			for(int i=1;i<=N;i++) {
				cnt+= Math.min(mid/i,N);
			}
			
			if(cnt<k) {
				f = mid+1;
			}else {
				e= mid-1;
			}
		}
		
		System.out.println(f);
	}
}
