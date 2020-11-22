import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3190 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] apple = new boolean[N][N];
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken())-1;
			int y =Integer.parseInt(st.nextToken())-1;
			apple[x][y] = true;
		}
		
		int L = Integer.parseInt(br.readLine());
		int[] rotateTime = new int[L];
		char[] rotateDir = new char[L];
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rotateTime[i] = Integer.parseInt(st.nextToken());
			rotateDir[i] = st.nextToken().charAt(0);
		}
		
		//play
		int ridx =0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int[][] map = new int[N][N];
		map[0][0] = 1;
		int[] snake = {0,0,0,1};//x,y,dir,size
		int time = 1;
		while(true) {
			time++;
			
			snake[0] += dx[snake[2]];
			snake[1] += dy[snake[2]];
			if(snake[0]<0 || snake[1]<0 || snake[0]>=N || snake[1]>=N) break;
			if(map[snake[0]][snake[1]]>= time-snake[3]) break;
			
			map[snake[0]][snake[1]] = time;
			
			if(apple[snake[0]][snake[1]]) {
				snake[3]++;
				apple[snake[0]][snake[1]]=false;
			}
			
			if(ridx<L && time-1 == rotateTime[ridx]) {
				snake[2] = rotateDir[ridx]=='D'?(snake[2]+1)%4:(snake[2]-1+4)%4;
				ridx++;
			}
		}
		
		System.out.println(time-1);
	}

}
