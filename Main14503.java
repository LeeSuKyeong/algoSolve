import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int cnt =0;
		while(true) {

			//1.현재칸 청소
			if(map[x][y] ==0) {
				cnt++;
				map[x][y] = 2;
			}
			
			//2.탐색
			boolean flag = false;
			for(int i=1;i<=4;i++) {
				int dir = (d-i+4)%4; //다음 청소할곳
				
				int nx = x+dx[dir];
				int ny = y+dy[dir];
				
				//벽인경우
				if(map[nx][ny] == 1) continue; //벽
				
				if(map[nx][ny] ==0) {//2.a
					flag = true;
					d = dir;
					x= nx;
					y= ny;
					break;
				}
				
			}
			//2.c
			if(!flag) {
				x-=dx[d];
				y-=dy[d];
				
				if(map[x][y] ==1) {
					break;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
