import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3085 {
	static int N,maxCnt;
	static char[][] map;
	static int[][] d = {{0,1},{1,0}};
	static int RIGHT = 0;
	static int DOWN = 1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map= new char[N][N];
		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//사탕 좌우교환
				if(j!= N-1 && map[i][j] != map[i][j+1]) {
					swap(i,j,i,j+1);
					countCandy(N);
					swap(i,j,i,j+1);
				}
				//사탕 상하교환
				if(i!= N-1 && map[i][j] != map[i+1][j]) {
					swap(i,j,i+1,j);
					countCandy(N);
					swap(i,j,i+1,j);
				}
				
			}
		}
	
		System.out.println(maxCnt);
	}
	static void swap(int x1,int y1,int x2,int y2) {
		char temp = map[x1][y1];
		map[x1][y1] = map[x2][y2];
		map[x2][y2] = temp;
	}
	static void countCandy(int N) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dfs(i,j,1,RIGHT);
				dfs(i,j,1,DOWN);
			}
		}
	}
	static void dfs(int x,int y,int cnt,int dir) {

		int nx = x+d[dir][0];
		int ny = y+d[dir][1];
		if(nx>=0 && nx<N && ny>=0 && ny<N) {
			if(map[nx][ny] == map[x][y]) {
				dfs(nx,ny,cnt+1,dir);
			}
		}
		
		maxCnt = maxCnt>cnt?maxCnt:cnt;
		
	}
}
