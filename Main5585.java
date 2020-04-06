import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5585 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int rem = 1000-Integer.parseInt(br.readLine());
		int[] money = {500,100,50,10,5,1};
		
		System.out.println(dfs(money,rem,0,0));
	}
	
	static int dfs(int[] money,int rem,int idx,int cnt) {
		
		if(rem==0) {
			return cnt;
		}
		
		return dfs(money,rem%money[idx],idx+1,cnt+rem/money[idx]);
	}
}
