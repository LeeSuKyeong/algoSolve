import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1461 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int dist = 0;
		if(Math.abs(arr[0])>Math.abs(arr[arr.length-1])) {
			dist+=Math.abs(arr[0]);
			for(int j=M;j<arr.length && arr[j]<0;j+=M) {
				dist+=Math.abs(arr[j])*2;
			}
			for(int j=arr.length-1;j>=0 && arr[j]>0;j-=M) {
				dist+=arr[j]*2;
			}
		}else {
			dist+=Math.abs(arr[arr.length-1]);		
			for(int j=0;j<arr.length && arr[j]<0;j+=M) {
				dist+=Math.abs(arr[j])*2;
			}
			for(int j=arr.length-1-M;j>=0 && arr[j]>0;j-=M) {
				dist+=arr[j]*2;
			}
		}
		System.out.println(dist);
	}
}
