import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10799 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int cnt =0;
		int answer =0;
		int len = s.length();
		for(int i=0;i<len;i++) {
			if(s.charAt(i) =='(') {
				cnt++;
			}else if(s.charAt(i) ==')') {
				cnt--;
				if(s.charAt(i-1)=='(') {
					//레이저
					answer+=cnt;
					
				}else {
					answer+=1;
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
