import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main10166 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int D1 = Integer.parseInt(st.nextToken());
		int D2 = Integer.parseInt(st.nextToken());
		
		int cnt =0;
		boolean[][] map = new boolean[D2+1][D2+1];
		for(int i=D1;i<=D2;i++) {
			for(int j=1;j<=i;j++) {
				int g = gcd(i,j);
				if(!map[i/g][j/g]) {
					cnt++;
					map[i/g][j/g] =true;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static int gcd(int a,int b) {
		while(b!=0) {
			int temp = a%b;
			a=b;
			b =temp;
		}
		return a;
	}
	
}
