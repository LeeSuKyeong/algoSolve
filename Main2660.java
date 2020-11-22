import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main2660 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[][] arr =new int[N+1][N+1];
		for(int i=1;i<N+1;i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1) {
				break;
			}
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j) continue;
					if(arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
						
						arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
					}
				}
			}
		}
		
		ArrayList<Integer> chk = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=N;i++) {
			int max =0;
			for(int j=1;j<=N;j++) {
				if(arr[i][j] != Integer.MAX_VALUE) {
					if(max<arr[i][j]) {
						max = arr[i][j];
					}
				}
			}
			
			if(min>max) {
				min = max;
				chk.clear();
				chk.add(i);
			}else if(min==max) {
				chk.add(i);
			}
		}
		Collections.sort(chk);
		StringBuilder sb = new StringBuilder();
		sb.append(min).append(" ").append(chk.size()).append('\n');
		for(int i=0;i<chk.size();i++) {
			sb.append(chk.get(i)).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
	
}
