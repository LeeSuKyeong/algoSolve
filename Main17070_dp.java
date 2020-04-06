import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17070_dp {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[][][] map = new int[N][N][3+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {				
				map[i][j][0]=Integer.parseInt(st.nextToken());
			}
		}
		
		map[0][1][1] = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(j>=1 && map[i][j][0] ==0 && map[i][j-1][0] ==0) {//가로막대
					map[i][j][1] += map[i][j-1][1]; //가->가
					map[i][j][1] += map[i][j-1][3];//대->가
					
				}
				
				if(i>=1 && map[i][j][0] ==0 && map[i-1][j][0] ==0) {//세로막대
					map[i][j][2]+=map[i-1][j][3]; //대->세
					map[i][j][2]+= map[i-1][j][2]; //세->세					
				}
				
				if(i>=1 && j>=1 && map[i][j][0] ==0 && map[i][j-1][0] ==0 && map[i-1][j][0] ==0 && map[i-1][j-1][0] ==0) {//대각
					map[i][j][3]+= map[i-1][j-1][3] + map[i-1][j-1][2] + map[i-1][j-1][1];
				}
			}
		}
		int result =  map[N-1][N-1][1]+map[N-1][N-1][2]+map[N-1][N-1][3];
		System.out.println(result);
	}
	
}
