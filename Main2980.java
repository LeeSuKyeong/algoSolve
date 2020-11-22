import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2980 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
					
		}
		
		int idx =0;
		int d= 0;
		int time =0;
		while(d<L) {
			if(idx<N && arr[idx][0]==d) {
				int tmp =time % (arr[idx][1]+arr[idx][2]); 
				if(tmp<arr[idx][1]) {
					time+=(arr[idx][1]-tmp);
				}
				idx++;
			}
			time++;
			d++;
		}
		System.out.println(time);
	}
}
