import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1780 {

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
		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}
	static int[] dx = {0,1,2,0,1,2,0,1,2};
	static int[] dy = {0,0,0,1,1,1,2,2,2};
	static int cnt1=0,cnt2=0,cnt3=0;
	static void dfs(int x, int y, int s,int[][] map) {
		if(chk(x,y,s,map)) {
			if(map[x][y] ==-1) {
				cnt1++;
			}else if(map[x][y] ==0) {
				cnt2++;
			}else {
				cnt3++;
			}
			return;
		}else {
			for(int i=0;i<9;i++) {
				int nx = x+s*dx[i]/3;
				int ny = y+s*dy[i]/3;
				dfs(nx,ny,s/3,map);
			}
		}
	}
	
	static boolean chk(int x,int y,int s,int[][] map) {
		int c = map[x][y];
		for(int i=x;i<x+s;i++) {
			for(int j=y;j<y+s;j++) {
				if(map[i][j] !=c) {
					return false;
				}
			}
		}
		
		return true;
	}
}
