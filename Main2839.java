import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2839 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int tmp = N/5;
		int cnt5 =0,cnt3=0;
		for(int i=tmp;i>=0;i--) {
			if((N-5*i)%3 !=0) {
				continue;
			}
			cnt5 = i;
			cnt3 = (N-5*i)/3;
			break;
		}
		
		System.out.println(cnt5==0 && cnt3==0?-1:(cnt5+cnt3));
	}
}
