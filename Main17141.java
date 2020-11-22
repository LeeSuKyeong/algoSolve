import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17141 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		arr =new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==2) {
					arr.add(new int[] {i,j});
				}
			}
		}
		boolean[] visit =new boolean[arr.size()];
		comb(arr.size(),M,0,visit);
		
		System.out.println(minTime==Integer.MAX_VALUE?-1:minTime);
	}
	static ArrayList<int[]> arr;
	static int[][] map;
	static int minTime = Integer.MAX_VALUE;
	
	static void bfs(boolean[] virus) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		int N= map.length;
		boolean[][] visit= new boolean[N][N];
		
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<virus.length;i++) {
			if(virus[i]) {			
				int[] tmp = arr.get(i);
				q.offer(tmp);
				visit[tmp[0]][tmp[1]]=true;
			}
		}
		
		int time = -1;
		while(!q.isEmpty()) {
			if(time>=minTime) {
				return;
			}
			int size = q.size();
			for(int s=0;s<size;s++) {
				int[] p = q.poll();
				
				for(int i=0;i<4;i++) {
					int nx = p[0] + dx[i];
					int ny = p[1] + dy[i];
					
					if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny] && map[nx][ny] !=1) {
						visit[nx][ny] = true;
						q.offer(new int[] {nx,ny});
					}
				}
			}
			time++;
		}

		boolean flag = false;
		label : for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] != 1 && !visit[i][j]) {
					flag = true;
					break label;
				}
			}
		}
		if(!flag) {			
			minTime= minTime<time?minTime:time;
		}
	}
	static void comb(int size, int m,int idx,boolean[] visit) {
		if(m==0) {
			bfs(visit);
			return;
		}
		
		for(int i=idx;i<visit.length;i++) {
			if(!visit[i]) {
				visit[i] = true;
				comb(size,m-1,i,visit);
				visit[i] = false;
			}
		}
		
	}
}
