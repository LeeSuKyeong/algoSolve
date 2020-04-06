import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1222 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			
			String s = br.readLine();
			int num =0;
			for(int i=0;i<len;i++) {
				if(s.charAt(i)>='0' && s.charAt(i)<='9') {
					num+=s.charAt(i)-'0';
				}
			}
			
			System.out.println("#" + tc + " " +num);
		}
		
	}

}
