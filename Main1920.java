import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] num = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb.append(bs(arr,num[i])).append('\n');
		}
		System.out.println(sb);
	}
	
	static int bs(int[] arr, int num) {
		
		
		int f = 0;
		int e = arr.length-1;
		int mid;
		while(f<=e) {
			mid = (f+e)/2;
			
			if(arr[mid] <num) {
				f = mid+1;
			}else if(arr[mid]>num) {
				e = mid-1;
			}else {
				return 1;
			}
			
		}
		
		return 0;
	}
}
