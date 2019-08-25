import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution7699 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static char[][] map ;
	static int R,C,max=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			max = 1;
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			for(int i=0;i<R;i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			boolean[] en = new boolean[26];//최대 길이 =알바펫수
			dfs(0,0,0,en);
			
			System.out.println("#" + tc+" " + max);
		}
	}
	
	static void dfs(int x,int y,int cnt,boolean[] en) {
		if(max == 26) {
			return;
		}
		
		if(en[map[x][y]-'A']) {
			if(max <cnt) {
				max = cnt;
			}
			return;
		}
		
		en[map[x][y]-'A'] = true;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<R && ny<C) {
				dfs(nx,ny,cnt+1,en);
				
			}
		}
		en[map[x][y]-'A']=false;
	}

}
