import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution7829 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int P = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int max=0; 
			int min=Integer.MAX_VALUE;
			for(int i=0;i<P;i++) {
				int temp = Integer.parseInt(st.nextToken());
				min = temp<min?temp:min;
				max = temp>max?temp:max;
			}
			
			System.out.println("#" + tc + " " + min*max);
			
		}
	}

}
