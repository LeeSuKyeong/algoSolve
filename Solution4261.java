import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4261 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//휴대폰번호
		int[] phone = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			int cnt = 0;
			for(int i=0;i<N;i++) {
				String word = st.nextToken();
				StringBuilder sb = new StringBuilder();
				for(int j=0;j<word.length();j++) {
					sb.append(phone[word.charAt(j)-'a']);
				}
				if(s.equals(sb.toString())){
					cnt++;
				}
			}
			
			System.out.println("#"+tc+" " + cnt);
		}
		
	}

}
