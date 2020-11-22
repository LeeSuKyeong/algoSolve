import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<int[]> v = new ArrayList<>();//init virus
		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					v.add(new int[] {i,j});
				}
			}
		}
		make(0, -1,map,v);// 벽세우기
		
		System.out.println(max);
	}

	static int N, M,max=0;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,-1,0,1};
	
	static void virus(int[][] map,ArrayList<int[]> v) {
		Queue<int[]> q = new LinkedList<int[]>();
		for(int[] n:v) {
			q.offer(n);
		}
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] == 0) {
					map[nx][ny] = 2;
					q.offer(new int[] {nx,ny});
				}
			}
		}
		
		region(map);
	}
	
	static void region(int[][] map) { //안전지대
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==0) {
					cnt++;
				}
			}
		}
		max = max<cnt?cnt:max;
	}
	static int[][] copy(int[][] map) {//맵 복사
		int[][] tmp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][j] = map[i][j];
			}
		}
		
		return tmp;
	}
	static void make(int cnt,int cur,int[][] map,ArrayList<int[]> v) {
		
		if(cnt==3) {
			virus(copy(map),v); //바이러스퍼뜨리기
			return;
		}
		
		for(int i=cur+1;i<N*M;i++) {
			if(map[i/M][i%M] ==0) {
				map[i/M][i%M] = 1;
				make(cnt+1,i,map,v);
				map[i/M][i%M] = 0;
			}
		}

	}

}
