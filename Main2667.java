import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2667 {
	static int N ;
	static char[][] map;
	static boolean[][] visit;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] =='1' && !visit[i][j]) {
					arr.add(bfs(i,j));
				}
			}
		}
		
		Collections.sort(arr);
		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
	}

	static int bfs(int x,int y) {
		Pos p;
		int nx,ny,cnt=1;
		Queue<Pos> q = new LinkedList<Pos>();
		q.offer(new Pos(x,y));
		visit[x][y] = true;
		while(!q.isEmpty()) {
			p = q.poll();
			for(int i=0;i<4;i++) {
				nx = p.x+dx[i];
				ny = p.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny] =='1' && !visit[nx][ny]) {
					visit[nx][ny] = true;
					cnt++;
					q.offer(new Pos(nx,ny));
				}
			}
		}
		
		return cnt;
	}
	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
