import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1110 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		
		boolean[] v =new boolean[100];
		v[N] = true;
		int tmp = N;
		int cycle = 0;
		while(true) {
			cycle++;
			int sum = (tmp % 10) + (tmp/10);
			tmp =(tmp%10)*10 + (sum % 10);
			if(v[tmp]) break;
			v[tmp]=true;
		}
		
		System.out.println(cycle);
	}
	
}
