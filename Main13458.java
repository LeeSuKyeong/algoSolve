import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		long cnt = 0;
		for(int i=0;i<N;i++) {
			arr[i]-=A;
			cnt++;
			if(arr[i]<0) arr[i] = 0;
			
			if(arr[i] !=0) {
				cnt+= arr[i]%B==0?arr[i]/B:(arr[i]/B)+1;
			}
		}
		
		System.out.println(cnt);
	}

}
