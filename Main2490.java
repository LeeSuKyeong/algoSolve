import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2490 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = {'E','A','B','C','D'};
		for(int i=0;i<3;i++) {			
			int cnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<4;j++) {				
				cnt+=Integer.parseInt(st.nextToken())==0?1:0;
			}
			
			System.out.println(arr[cnt]);
		}
		
		
	}
}
