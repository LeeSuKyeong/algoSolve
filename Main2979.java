import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2979 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] val = new int[4];
		for(int i=1;i<=3;i++) {
			val[i]=Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[100+1];
		
		int mf=0,mt=100;
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			
			int f = Integer.parseInt(st.nextToken());
			int t =Integer.parseInt(st.nextToken());
			mf=mf<f?mf:f;
			mt=mt>t?mt:t;
			
			for(int j=f+1;j<=t;j++) {
				arr[j]++;
			}
		}
		
		int cnt = 0;
		for(int i=mf+1;i<=mt;i++) {
			cnt+=val[arr[i]]*arr[i];
		}
		System.out.println(cnt);

	}
	
}
