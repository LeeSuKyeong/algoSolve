import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(br.readLine());
		char[][] map= new char[N][N];
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dfs(i,j);
			}
		}
		
	}

	static void dfs(int x,int y) {
		
	}
}
