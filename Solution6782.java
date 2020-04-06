import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6782 {
	static long count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			int result = 0;
			while(true) {
				if(N==1) {
					result+=1;
					break;
				}else if(N==2) {
					break;
				}else {
					long temp =(long) Math.sqrt(N);
					if(temp * temp==N) {
						result++;
						N = temp;
					}else {
						result += (temp+1)*(temp+1) -N;
						result++;
						N = temp+1;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}

}
