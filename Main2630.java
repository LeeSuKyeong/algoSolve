import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2630 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,N,map);
		
		System.out.println(w);
		System.out.println(b);
	}
	static int w=0,b=0;
	static void dfs(int x,int y, int N,int[][] map) {
		if(chk(x,y,N,map)) {
			if(map[x][y] == 1) {
				b++;
			}else {
				w++;
			}
		}else {
			dfs(x,y,N/2,map);
			dfs(x,y+N/2,N/2,map);
			dfs(x+N/2,y,N/2,map);
			dfs(x+N/2,y+N/2,N/2,map);
		}
	}
	static boolean chk(int x, int y, int s,int[][] map) {
		int c = map[x][y];
		for(int i=x;i<x+s;i++) {
			for(int j=y;j<y+s;j++) {
				if(map[i][j] != c) {
					return false;
				}
			}
		}
		
		return true;
	}

}
