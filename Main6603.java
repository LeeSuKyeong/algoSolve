import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {
	static int[] arr;
	static int k;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			k = Integer.parseInt(st.nextToken());
			if(k== 0) {
				break;
			}
			
			arr =new int[k];
			for(int i=0;i<k;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			boolean[] visit = new boolean[k];
			comb(0,0,visit);
			System.out.println();
		}
		
	}
	static void print(boolean[] visit) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<k;i++) {
			if(visit[i]) {
				sb.append(arr[i]);
				sb.append(" ");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		
		System.out.println(sb);
	}
	static void comb(int cnt,int idx,boolean[] visit) {
		if(cnt == 6) {
			print(visit);
			return;
		}
		if(idx>=k) {
			return;
		}
		visit[idx] = true;
		comb(cnt+1,idx+1,visit);
		
		visit[idx] = false;
		comb(cnt,idx+1,visit);
		
	}
}
