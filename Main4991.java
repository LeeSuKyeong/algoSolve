import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4991 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st ;
		while(true) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			if(w ==0 && h==0) break;
			
			char[][] map = new char[w][h];
			boolean flag = false;
			Pos robot =null;
			ArrayList<Pos> arr = new ArrayList<>();
			for(int i=0;i<w;i++) {
				map[i] = br.readLine().toCharArray();
				if(!flag) {					
					for(int j=0;j<h;j++) {
						if(map[i][j] == 'o') {
							robot = new Pos(i,j);
						}
						
						if(map[i][j] == '*') {
							arr.add(new Pos(i,j));
						}
					}
				}
			}
			//arr 0은 청소기
			arr.add(0, robot);
			
			//각각의 거리 테이블
			int size = arr.size();
			int[][] distTable = new int[arr.size()][arr.size()];
			for(int i=0;i<size;i++) {
				makeTable(distTable, map,arr, i, w, h);				
			}
			
			int[] visit = new int[arr.size()];
			for(int i=0;i<visit.length;i++) {
				visit[i] = i;
			}
			
			//청소기가 갈 순서
			perm(1,arr.size(),visit,distTable);
			sb.append(min==Integer.MAX_VALUE?-1:min).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int min = Integer.MAX_VALUE;
	static int[][] dist;
	
	static void makeTable(int[][] distTable,char[][] map, ArrayList<Pos> arr,int idx,int w,int h) {
		Pos sp = arr.get(idx);
		int size = arr.size();
		
		Queue<Pos> q = new LinkedList<>();
		int[][] visit= new int[w][h];
		q.offer(sp);
		visit[sp.x][sp.y]= 1; 
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0;i<4;i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<w && ny<h && visit[nx][ny] ==0 && map[nx][ny] !='x') {
					visit[nx][ny] = visit[p.x][p.y]+1;
					
					for(int j=idx;j<size;j++) {
						Pos tmp = arr.get(j);
						if(tmp.x == nx && tmp.y== ny) {
							distTable[idx][j] = visit[nx][ny]-1;
							distTable[j][idx] = visit[nx][ny]-1;
						}
					}
					
					q.offer(new Pos(nx,ny));
				}
			}
		}
	}
	static void init(int[] visit,int size) {
		for(int i=0;i<size;i++) {
			visit[i] = i;
		}
	}
	
	static void chk(int[] visit,int size,int[][] distTable) {
		
		int d = 0;
		for(int i=0;i<size-1;i++) {
			if(distTable[visit[i]][visit[i+1]] ==0) return;
			
			d+= distTable[visit[i]][visit[i+1]];
		}
		
		if(d<min) {
			min=d;
		}
	}
	
	static void perm(int idx, int size,int[] visit,int[][] distTable) {
		if(idx == size) {
			chk(visit,size,distTable);
			return;
		}
		
		for(int i=idx;i<size;i++) {
			swap(idx,i,visit);
			perm(idx+1,size,visit,distTable);
			swap(idx,i,visit);
		}
	}
	
	static void swap(int a,int b,int[] visit) {
		
		int tmp = visit[a];
		visit[a] = visit[b];
		visit[b] = tmp;
	}
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
}
