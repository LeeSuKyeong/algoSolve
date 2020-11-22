import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3055 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];
		Pos s = null;
		ArrayList<Pos> w = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j] =='*') {
					w.add(new Pos(i, j));
				}else if(map[i][j] == 'S') {
					map[i][j] = '.';
					s = new Pos(i, j);
				}
			}
			
		}
		

		int time = simul(s,w,map,R,C);

		System.out.println(time==0?"KAKTUS":time);
	}
	
	static int simul(Pos ss, ArrayList<Pos> sw, char[][] map,int R,int C) {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		
		boolean[][] visitS = new boolean[R][C];
		boolean[][] visitW = new boolean[R][C];
		Queue<Pos> s = new LinkedList<>();
		Queue<Pos> w = new LinkedList<>();
		
		s.offer(ss);
		visitS[ss.x][ss.y] =true;

		for(int i=0;i<sw.size();i++) {			
			w.offer(sw.get(i));
			visitW[sw.get(i).x][sw.get(i).y] =true;
		}
		
		int time =0;
		boolean flag = false;
		label:
		while(!s.isEmpty()) {
			time++;
			//물
			int wsize = w.size();
			for(int i=0;i<wsize;i++) {
				Pos p = w.poll();
				
				for(int j=0;j<4;j++) {
					int nx = p.x+dx[j];
					int ny = p.y+dy[j];
					
					if(nx>=0 && ny>=0 && nx<R && ny<C && !visitW[nx][ny]) {
						if( map[nx][ny] == '.') {					
							visitW[nx][ny] = true;
							w.offer(new Pos(nx,ny));
						}
					}
				}
			}
			//고슴도치
			int ssize = s.size();
			for(int i=0;i<ssize;i++) {
				Pos p = s.poll();
				
				for(int j=0;j<4;j++) {
					int nx = p.x+dx[j];
					int ny = p.y+dy[j];
					
					if(nx>=0 && ny>=0 && nx<R && ny<C && !visitS[nx][ny] && !visitW[nx][ny]) {
						if(map[nx][ny] == 'D') {
							flag = true;
							break label;
						}
						if(map[nx][ny] !='X') {					
							visitS[nx][ny] = true;
							s.offer(new Pos(nx,ny));
						}
					}
				}
			}
			
		}
		
		if(!flag && s.isEmpty()) {
			time = 0;
		}
		return time;
	}
	static class Pos {
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
