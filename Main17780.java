import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main17780 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		horseMap = new ArrayList[N][N];

		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				horseMap[i][j] = new ArrayList<>();
			}
		}
		
		horse = new Info[K];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			
			horse[i] = new Info(x,y,d);
			horseMap[x][y].add(i);
		}
		
		int turn = 0;
		label: while(turn<1000) {
			turn++;
			for(int i=0;i<K;i++) {
				if(horseMap[horse[i].x][horse[i].y].get(0) == i) {					
					move(horse[i]);
					if(flag) {
						break label;
					}
				}
			}
		}
		
		System.out.println(turn==1000?-1:turn);
		
	}
	static int[][] map;
	static Info[] horse;
	static ArrayList<Integer>[][] horseMap;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int N;
	static boolean flag = false;
	static void move(Info info) {
		
		int x = info.x;
		int y = info.y;
		int d = info.d;
		
		int nx = x+dx[d];
		int ny = y+dy[d];
		if(nx>=0 && nx<N && ny>=0 && ny<N) {
			
			if(map[nx][ny] == 0) {
				//흰
				int size = horseMap[x][y].size();
				int[] tmp = new int[size];
				for(int i=0;i<size;i++) {
					tmp[i] = horseMap[x][y].get(i);
				}
				for(int i=0;i<size;i++) {
					int idx = tmp[i];
					horse[idx].x=nx;
					horse[idx].y=ny;
					
					horseMap[nx][ny].add(idx);
					if(horseMap[nx][ny].size()>=4) {
						flag = true;
						return;
					}
				}
				horseMap[x][y] = new ArrayList<>();
			}else if(map[nx][ny] ==1) {
				//빨
				int size = horseMap[x][y].size();
				int[] tmp = new int[size];
				
				for(int i=0;i<size;i++) {
					tmp[i] = horseMap[x][y].get(i);
				}
				
				for(int i=size-1;i>=0;i--) {
					int idx = tmp[i];
					horse[idx].x=nx;
					horse[idx].y=ny;
					
					horseMap[nx][ny].add(idx);
					if(horseMap[nx][ny].size()>=4) {
						flag = true;
						return;
					}
				}
				horseMap[x][y] = new ArrayList<>();
			}else {
				//파
				if(info.d %2==0) info.d=info.d+1;
				else info.d=info.d-1;
				d= info.d;
				int nnx = x+dx[d];
				int nny = y+dy[d];
				
				if(nnx>=0 && nny>=0 && nnx<N && nny<N && (map[nnx][nny]==0 || map[nnx][nny] ==1)) {
					move(info); //이동가능하면 이동
				}
			}
			
		}else {
			//바깥으로 나간경우
			if(info.d %2==0) info.d+=1;
			else info.d-=1;
			d= info.d;
			int nnx = x+dx[d];
			int nny = y+dy[d];
			
			if(nnx>=0 && nny>=0 && nnx<N && nny<N && (map[nnx][nny]==0 || map[nnx][nny] ==1)) {
				move(info);
			}
		}
	}
	
	static class Info{
		int x,y,d;

		public Info(int x, int y, int d) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
		}		
		
	}

	
}
