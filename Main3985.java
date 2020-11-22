import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3985 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L =Integer.parseInt(br.readLine());
		int N =Integer.parseInt(br.readLine());
		
		int au = 0;
		int max = 0;
		int expect = 0;
		int eMax = 0;
		boolean[] visit = new boolean[L];
		int[] arr = new int[L];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			if(eMax<k-p) {
				eMax = k-p;
				expect = i+1;
			}
			
			int n = 0;
			for(int j=p-1;j<k;j++) {
				if(!visit[j]) {
					visit[j] = true;
					arr[j] = i+1;
					n++;
				}
			}
			
			if(max<n) {
				max = n;
				au = i+1;
			}
		}
		
		System.out.println(expect);
		System.out.println(au);
		
	}
}
