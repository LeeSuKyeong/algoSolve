import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15683 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		int[][] map =new int[N][M];
		ArrayList<int[]> cctv = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >=1 && map[i][j] <=5) cctv.add(new int[] {i,j});
			}
		}
		
		search(0,cctv,map);
		System.out.println(min);
	}

	static int N,M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static int min=Integer.MAX_VALUE;
	
	static void copy(int[][] map,int[][] cmap){
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				cmap[i][j] = map[i][j];
			}
		}
	}
	
	static void cal(int[][] map) {
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] ==0) {
					cnt++;
				}
			}
		}
		
		min = min<cnt?min:cnt;
	}
	static void search(int idx,ArrayList<int[]> cctv,int[][] map) {
		if(idx == cctv.size()) {
			
			cal(map);
			return;
		}
		
		int[] c = cctv.get(idx);
		int[][] cmap =new int[N][M];
		copy(map,cmap);
		
		switch(map[c[0]][c[1]]) {
		case 1:
			for(int i=0;i<4;i++) {
				bfs(c,i%4,map);
				search(idx+1,cctv,map);
				copy(cmap,map);
			}
			break;
		case 2:
			for(int i=0;i<2;i++) {
				bfs(c,i%4,map);
				bfs(c,(i+2)%4,map);
				search(idx+1,cctv,map);
				copy(cmap,map);
			}
			break;
		case 3:
			for(int i=0;i<4;i++) {
				bfs(c,i%4,map);
				bfs(c,(i+1)%4,map);
				search(idx+1,cctv,map);
				copy(cmap,map);
			}
			break;
		case 4:
			for(int i=0;i<4;i++) {
				for(int j=0;j<3;j++) {
					bfs(c,(i+j)%4,map);
				}
				search(idx+1,cctv,map);
				copy(cmap,map);
			}
			break;
		case 5:
			for(int i=0;i<4;i++) {				
				bfs(c,i%4,map);
			}
			search(idx+1,cctv,map);
			break;
		}
	}

	static void bfs(int[] s,int d,int[][] map) { //한방향에서의 감시공간
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(s);
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int nx = p[0] +dx[d];
			int ny = p[1] +dy[d];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				if(map[nx][ny] ==6) return;
				
				q.offer(new int[] {nx,ny});
				if(map[nx][ny] ==0) {
					map[nx][ny] =-1;
				}
			}
		}
	}
	
}
