import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13459 {
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };//nwse
	static int N, M,result;
	static char[][] map;
	static int count = 0;
	static boolean rs,bs;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int rx = 0,ry=0,bx=0,by=0;
		map = new char[N][M];
		result = 0;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by =j;
				}
			}
		}
		rs=false;
		bs=false;
		dfs(0,rx,ry,bx,by);
		System.out.println(result);
	}

	static void dfs(int time,int rx,int ry,int bx,int by) {
		
		if(time == 10) {
			return;
		}
	
		if(result == 1) { //R이 O에 들어간적있으면
			return;
		}
		
		for(int i=0;i<4;i++) {
			int rnx = rx+dx[i];
			int rny = ry+dy[i];
			int bnx = bx+dx[i];
			int bny = by+dy[i];
			
			while(map[rnx][rny] !='#') {
				if(map[rnx][rny] == 'O') {
					rs = true;
					break;
				}
				rnx +=dx[i];
				rny+=dy[i];
			}
			if(map[rnx][rny] == '#') {
				rnx-=dx[i];
				rny-=dy[i];
			}
			while(map[bnx][bny] !='#') {
				if(map[bnx][bny] == 'O') {
					bs = true;
					break;
				}
				bnx +=dx[i];
				bny+=dy[i];
			}
			if(map[bnx][bny] == '#') {
				bnx-=dx[i];
				bny-=dy[i];
			}
			
			if(bnx==rnx && bny==rny && map[bnx][bny]!='O') {//nwse//겹칠때
				if(i==0) {//n
					if(rx<bx) {
						bnx+=1;
					}else {
						rnx+=1;
					}
				}else if(i==1) {//w
					if(ry<by) {
						bny+=1;
					}else {
						rny+=1;
					}
				}else if(i==2) {//s
					if(rx<bx) {
						rnx-=1;
					}else {
						bnx-=1;
					}
				}else {//e
					if(ry<by) {
						rny-=1;
					}else {
						bny-=1;
					}
				}
			}
			
			if(rnx==rx && rny==ry && bnx==bx && bny==by) {//위치가 그대로면 dfs 그만하고 다른방향으로dfs
				continue;
			}
			
			if(!rs && !bs) {
				dfs(time+1,rnx,rny,bnx,bny);
			}else if(rs && !bs) {
				result = 1;
				return;
			}
			rs = false;
			bs = false;
		}
		
	}


}
