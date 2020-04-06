import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution원자 {
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int totalE = 0;
		int[][] map =new int[4001][4001];
		Queue<Info> q=new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			totalE = 0;
			for(int i=0;i<4001;i++) {
				Arrays.fill(map[i], 0);
			}
			int N = Integer.parseInt(br.readLine());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken())*2+2000;
				int y = Integer.parseInt(st.nextToken())*(-2)+2000;
				int dir = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				map[y][x] = e;
				q.offer(new Info(y,x,dir,e));
			}
			
			while(q.size()>1) {
				int size = q.size();
				for(int i=0;i<size;i++) {
					Info p = q.poll();
					map[p.y][p.x]-=p.e;
					int nx = p.x+dx[p.dir];
					int ny = p.y+dy[p.dir];
					
					if(nx<0 || ny<0 || nx>4000 || ny>4000) {
						continue;
					}
					map[ny][nx] +=p.e;
					q.offer(new Info(ny,nx,p.dir,p.e));
				}
				size = q.size();
				for(int i=0;i<size;i++) {
					Info p = q.poll();
					if(map[p.y][p.x]==0) {
						continue;
					}else if(map[p.y][p.x] !=p.e) { //충돌한 에너지 누적 && 이미 계산해서 해당위치 0인경우
						totalE += map[p.y][p.x];
						map[p.y][p.x]= 0; 
					}else {
						q.offer(p);
					}
				}
			}
			q.clear();
			sb.append("#").append(tc).append(" ").append(totalE).append("\n");
		}
		System.out.println(sb);
	}

	static class Info{
		int x,y,dir,e;
		public Info(int y, int x, int dir, int e) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}

	}
}
