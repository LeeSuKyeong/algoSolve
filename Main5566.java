import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main5566 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr= new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dice = new int[M];
		for(int i=0;i<M;i++) {
			dice[i] = Integer.parseInt(br.readLine());
		}
		
		int time= 0;
		int p = 1;
		int idx = 0;
		while(p<N) {
			time++;
			
			p +=dice[idx++];
			if(p>=N) break;
			if(p<1) p=1;
			
			p += arr[p];
			if(p>=N) break;
			if(p<1) p=1;
			
		}
		
		System.out.println(time);
	}

}
