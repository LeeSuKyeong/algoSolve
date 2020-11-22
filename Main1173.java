import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1173 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());//운동시간
		int m = Integer.parseInt(st.nextToken());//최소맥박
		int M = Integer.parseInt(st.nextToken());//최대맥박
		int T = Integer.parseInt(st.nextToken());//증가하는 맥박수
		int R = Integer.parseInt(st.nextToken());//감소하는맥박수
		
		int time = 0;
		int cnt = 0;
		int cur = m;
		if(cur+T>M) {
			time = -1;
		}else {
			while(cnt<N) {
				time++;
				
				if(cur+T<=M) {
					cnt++;
					cur+=T;
				}else {
					cur=cur-R<m?m:cur-R;
				}
			}
		}
		System.out.println(time);
	}
}
