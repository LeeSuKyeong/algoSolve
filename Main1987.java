import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1987 {
	static char[][] map;
	static boolean[] en = new boolean[26];
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int R,C,max = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
			
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int x = 0;
		int y = 0;
		en[map[x][y]-'A'] = true;
		dfs(x,y,1);
		System.out.println(max);
	}
	
	static void dfs(int x, int y ,int cnt) {
		if(max==R*C) {
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >=0 && ny>=0 && nx<R && ny<C) {
				if(!en[map[nx][ny] -'A']) {
					en[map[nx][ny]-'A']=true;
					dfs(nx,ny,cnt+1);
					en[map[nx][ny] -'A'] =false;
				}
			}
		}
		max = cnt>max? cnt :max;
	}

}
