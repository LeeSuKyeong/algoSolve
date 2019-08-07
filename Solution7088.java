import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7088 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int Q = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+1];
			int num;
			int start,end ;
			int[][] count= new int[3+1][N+1];
			StringBuilder sb = new StringBuilder("#");
			sb.append(tc);
			sb.append("\n");
			
			for(int i=1;i<=N;i++) {				
				//dp
				num = Integer.parseInt(br.readLine());
				for(int j=1;j<=3;j++) {
					if(num == j) {						
						count[j][i]=count[j][i-1]+1;
					}else {
						count[j][i]= count[j][i-1];
					}
				}
				
			}
			for(int j=0;j<Q;j++) {
				st = new StringTokenizer(br.readLine());
				start = Integer.parseInt(st.nextToken());
				end = Integer.parseInt(st.nextToken());
				
				for(int k=1;k<=3;k++) {						
					sb.append(count[k][end] - count[k][start-1]);
					sb.append(" ");
				}
				sb.replace(sb.length()-1, sb.length(), "\n");
			}
			
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb.toString());
			
		}
	}

}
