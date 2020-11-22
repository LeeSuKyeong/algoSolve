import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =1;
		for(int i=0;i<3;i++) {			
			n *= Integer.parseInt(br.readLine());
		}
		
		int[] num = new int[10];
		while(n!=0) {
			num[n%10]++;
			n/=10;
		}
		
		for(int i=0;i<10;i++) {
			System.out.println(num[i]);
		}
	}
}
