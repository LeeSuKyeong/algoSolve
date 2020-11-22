import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 자기자신으로 돌아오려면 가로선이 짝수개여야아함
 * count배열로 i번째 새로선에 놓는 가로선 개수 체크
 * 가로선개수가 홀수개인 세로선이 3개이상이면 만들기 불가
 * 가로선을 넣을 수 있는 곳 중 최대 3개 까지 고르고 simul 후 min 갱신
 */
public class Main15684_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[][] radder= new int[H+1][N+2];
		int[] count = new int[N+2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			
			radder[a][b] = 1;
			radder[a][b+1] = 2;
			count[b]++;
		}
		
		int odd=0;
		for(int i=1;i<=N;i++) {
			odd+=count[i]%2==0?0:1;
		}
		
		if(odd<=3) {			
			dfs((1+1)+(N+1),radder,0);
		}
		
		System.out.println(min==4?-1:min);
	}

	static int min = 4;
	static int N,M,H;
	
	static boolean play(int[][] radder) {
		
		for(int i=1;i<=N;i++) {
			int y = i;
			int x = 1;
			
			while(x<=H) {
				if(radder[x][y] ==1) {
					y++;
				}else if(radder[x][y-1] ==1){
					y--;
				}
				x++;
			}
			
			if(y!=i) return false;
		}
		return true;
	}
	static void dfs(int idx,int[][] radder,int cnt) {
		
		if(cnt>= min) return;
		if(play(radder)) {
			min = cnt<min?cnt:min;
			return;
		}
		if(cnt==3) return;
		
		int maxIdx = (N+2)*(H+1);
		for(int i=idx;i<maxIdx;i++) {
			int y = i%(N+2);
			int x = i/(N+2);
			if(y==0 || y>=N) continue;
			
			if(radder[x][y] ==0 && radder[x][y+1]==0) {
				radder[x][y] = 1;
				radder[x][y+1] =2;
				dfs(idx+1,radder,cnt+1);
				radder[x][y] = 0;
				radder[x][y+1] =0;
			}
		}

	}
}
