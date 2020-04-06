import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7465 {
	static int arr[];
	static  int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			
			makeset();
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int f = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				unionset(f,t);
			}
			
			int cnt =0;
			for(int i=1;i<=N;i++) {
				if(arr[i] == i) {
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	static void makeset() {
		for(int i=1;i<=N;i++) {
			arr[i] =i;
		}
	}
	static int findset(int idx) {
		if(arr[idx]== idx) {
			return idx;
		}
		return findset(arr[idx]);
	}
	static void unionset(int f,int t) {
		if(arr[f] == arr[t]) {
			return;
		}
		arr[findset(t)] = arr[findset(f)];
	}
	
	
}
