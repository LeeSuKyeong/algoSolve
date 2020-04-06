import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			int min = 1000000;
			int max = 0;
			st = new StringTokenizer(br.readLine());
			String num;
			int sum;
			for(int i=0;i<10;i++) {
				num = st.nextToken();
				sum = 0;
				for(int j=0;j<num.length();j++) {
					sum += num.charAt(j) -'0';
				}
				min = min<sum?min:sum;
				max =max>sum?max:sum;
			}
			sb.append(max).append(" ").append(min).append("\n");
			
		}
		System.out.println(sb);
		
		
	}

}
