import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		System.out.println(bs(arr,C));
		
	}
	
	
	static int bs(int[] arr,int C) {
		int len = arr.length;
		int f= 1;
		int mid,s=arr[0];
		int e= arr[len-1]-arr[0];
		int cnt =1;
		while(f<=e){
			cnt=1;
			s=arr[0];
			mid = (f+e)/2;
			
			for(int i=0;i<len;i++) {
				if(arr[i]- s>=mid) {
					cnt++;
					s=arr[i];
				}
				
				if(cnt==C) {
					break;
				}
			}
			
			if(cnt<C) {
				e= mid-1;
			}else {
				f=mid+1;
			}
			
		}
		
		return e;
	}
}
