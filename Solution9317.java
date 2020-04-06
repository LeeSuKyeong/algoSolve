import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9317 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			String s1 = br.readLine();
			String s2 = br.readLine();
			
			int answer =0;
			for(int i=0;i<N;i++) {
				if(s1.charAt(i) == s2.charAt(i)) {
					answer++;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
		
	}

}
