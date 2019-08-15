import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3987 {
	static int N,M;
	static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];

		for(int i=0;i<N;i++) {
			map[i]=br.readLine().toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		int time = -1;
		int count,d = 0;
		char[] dir = {'U','R','D','L'};
		for(int i=0;i<4;i++) {
			count = play(sx-1,sy-1,dir[i]);
			
			if(time<count) {
				d=i;
				time = count;
				if(time == Integer.MAX_VALUE) {
					break;
				}
			}
		}
		
		System.out.println(dir[d]);
		System.out.println(time==Integer.MAX_VALUE?"Voyager":time);
		
	}
	static int play(int x,int y, char dir) {
		int count = 0;
		boolean[][][] visit = new boolean[N][M][4]; //urdl 0123
		while(true) {
			count++;
			if(dir=='U') {
				x--;
				if(x<0 || map[x][y] == 'C') {
					break;
				}
				if(map[x][y] =='/') {
					if(visit[x][y][0]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][0] =true;
					dir = 'R';
				}else if(map[x][y] =='\\') {
					if(visit[x][y][0]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][0] =true;
					
					dir = 'L';
				}
			}else if(dir =='D') {
				x++;
				if(x==N || map[x][y] == 'C') {
					break;
				}
				if(map[x][y] =='/') {
					if(visit[x][y][2]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][2] =true;
					dir = 'L';
				}else if(map[x][y] =='\\') {
					if(visit[x][y][2]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][2] =true;
					dir = 'R';
				}
			}else if(dir=='L') {
				y--;
				if(y<0 || map[x][y] == 'C') {
					break;
				}
				if(map[x][y] =='/') {
					if(visit[x][y][3]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][3] =true;
					
					dir = 'D';
				}else if(map[x][y] =='\\') {
					if(visit[x][y][3]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][3] =true;
					
					dir = 'U';
				}
			}else if(dir =='R') {
				y++;
				if(y==M || map[x][y] == 'C') {
					break;
				}
				if(map[x][y] =='/') {
					if(visit[x][y][1]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][1] =true;
					dir = 'U';
				}else if(map[x][y] =='\\') {
					if(visit[x][y][1]) {
						return Integer.MAX_VALUE;
					}
					visit[x][y][1] =true;
					dir = 'D';
				}
			}
			
		}
		return count;
	}

}
