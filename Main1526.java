import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1526 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int N = Integer.parseInt(s=br.readLine());
		dfs(N,s.length(),0);
		
		System.out.println(ans);
	}
	
	static int ans=0;
	static void dfs(int N,int len,int num) {
		if(num>N) {
			return;
		}
		
		ans = ans<num?num:ans;
		
		dfs(N,len-1,num*10+7);
		dfs(N,len-1,num*10+4);
	}
}
