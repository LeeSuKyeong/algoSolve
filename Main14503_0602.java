import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14503_0602 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int[] dx = { -1,0,1,0};
		int[] dy = {0,1,0,-1};
		//play
		while(true) {
			if(map[r][c]==0) {
				map[r][c] = 2;
				cnt++;				
			}
			
			boolean flag = false;
			for(int i=0;i<4;i++) {
				int nd = (d-1+4)%4;
				int nx = r+dx[nd];
				int ny = c+dy[nd];
				if(map[nx][ny] ==0) {
					d = nd;
					r = nx;
					c = ny;
					flag = true;
					break;
				}
				d = nd;
			}
			
			if(!flag) {
				int tx = r-dx[d%4];
				int ty = c-dy[d%4];
				
				if(map[tx][ty] == 1) {
					break;
				}else {
					r = tx;
					c = ty;
				}
			}
		}

		System.out.println(cnt);
	}

}
