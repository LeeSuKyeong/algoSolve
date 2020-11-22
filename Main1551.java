import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1551 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(),",");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<K;i++) {
			int[] tmp= new int[--N];
			
			for(int j=0;j<N;j++) {
				tmp[j] = arr[j+1]-arr[j];
			}
			
			arr = tmp;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		for(int i=1;i<N;i++) {
			sb.append(',').append(arr[i]);
		}
		System.out.println(sb);
	}
}
