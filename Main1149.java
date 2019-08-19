import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] rgb = new int[N][3];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
			if(i!=0) {
				for(int j=0;j<3;j++) {
					int min = Integer.MAX_VALUE;
					for(int k=0;k<3;k++) {
						if(j!=k) {
							min = min<rgb[i-1][k]?min:rgb[i-1][k];
						}
					}
					rgb[i][j] += min;
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			result = result<rgb[N-1][i]?result:rgb[N-1][i];
		}
		
		System.out.println(result);
		
	}

}
