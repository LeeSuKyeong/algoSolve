import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1120 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int temp,min = A.length();
		for(int i=0;i<=B.length()-A.length();i++) {
			temp =0;
			for(int j =0;j<A.length();j++) {
				if(A.charAt(j) !=B.charAt(j+i)) {
					temp++;
				}
			}
			min = min<temp?min:temp;
		}

		System.out.println(min);
	}

}
