import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9517 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine())-1;
		int N = Integer.parseInt(br.readLine());
		int time =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time +=Integer.parseInt(st.nextToken());
			if(time>=210) {
				break;
			}
			if("T".equals(st.nextToken())) {
				K=(K+1)%8;				
			}
		}
		K++;
		
		System.out.println(K);
		
	}

}
