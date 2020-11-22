import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main14499 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		int[] dice= new int[6+1];
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {			
			
			if(play(Integer.parseInt(st.nextToken()),N,M,map,dice)) {				
				sb.append(dice[1]).append('\n');
			}
		}
		System.out.println(sb.toString());
	}
	
	static int x, y;
	static int[] dx= {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	static boolean play(int comm,int N, int M,int[][] map, int[] dice) {
		
		int nx = x + dx[comm];
		int ny = y + dy[comm];
		
		//맵밖
		if(nx<0 || ny<0 || nx>=N || ny>=M) {
			return false;
		}
		
		x = nx;
		y = ny;
		
		int tmp;
		//주사위이동
		switch(comm) {
		case 1://E
			tmp = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = tmp;
			break;
		case 2://W
			tmp = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = tmp;
			
			break;
		case 3://N
			tmp = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = tmp;
			break;
		case 4://S
			tmp = dice[1];
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = tmp;
			break;
		}
		
		if(map[x][y] == 0) {
			map[x][y] = dice[6];
		}else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}

		return true;
	}

}
