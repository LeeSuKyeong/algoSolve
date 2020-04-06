import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17135 {
	static int[][] map,oMap;
	static int N,M,D,tm,m,result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		tm = 0;
		map = new int[N][M];
		oMap = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				oMap[i][j] = map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) tm++;
			}
		}
		int[] pos = {-1,-1,-1};
		comb(pos,0,0);
		
		System.out.println(result);
	}
	
	static void comb(int[] pos,int cnt,int idx) {
		if(cnt==3) {
			start(pos);
			return;
		}
		if(idx>=M) {
			return;
		}
		
		pos[cnt]=idx;
		comb(pos,cnt+1,idx+1);

		pos[cnt]=-1;
		comb(pos,cnt,idx+1);
	}
	
	static void init() {
		m = tm;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = oMap[i][j];
			}
		}
	}
	static void start(int[] pos) {
		int nx,ny;
		boolean flag;
		int c=0;
		init();
		int[][] choice;
		while(m>0) {
			choice=new int[3][2];
			for(int i=0;i<3;i++) {
				int p =pos[i];
				
				for(int j=1;j<=D;j++) {
					ny = p-j;
					nx = N;
					flag = false;
					while(ny<p) {
						if(nx>=0 && ny>=0&& nx<N && ny<M) {
							if(map[nx][ny]==1) {
								choice[i][0]=nx;
								choice[i][1]=ny;
								flag = true;
								break;
							}
						}
						nx--;
						ny++;
					}
					
					if(flag) break;
					
					flag = false;
					while(nx<N) {
						if(nx>=0 && ny>=0&& nx<N && ny<M) {
							if(map[nx][ny]==1) {
								choice[i][0]=nx;
								choice[i][1]=ny;
								flag = true;
								break;
							}
						}
						nx++;
						ny++;
					}
					if(flag) break;
					
				}
			}
			for(int i=0;i<3;i++) {
				if(map[choice[i][0]][choice[i][1]] ==1) {
					if(choice[i][0] == 0 && choice[i][1] ==0) continue; //아무것도못잡음
					m--;
					c++;
					map[choice[i][0]][choice[i][1]]=0;
				}
			}
			if(m<0) {
				break;
			}
			down();
		}
		
		result = result<c?c:result;
		

	}
	
	static void down() {
		for(int j=0;j<M;j++) {
			if(map[N-1][j]==1) {
				m--;
			}
		}
		for(int i=N-1;i>=1;i--) {
			for(int j=0;j<M;j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int j=0;j<M;j++) {
			map[0][j] = 0;
		}
		
	}
}
