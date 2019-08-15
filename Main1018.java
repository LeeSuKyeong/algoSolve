import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1018 {
	static char[][] map;
	static int N,M;
	static int count = 64;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0;i<=N-8;i++) {
			for(int j=0;j<=M-8;j++) {
				check(i,j);
			}
		}
		
		System.out.println(count);
	}
	
	static void check(int sx,int sy) {
		char temp = map[sx][sy]; //시작 좌표 색
		int cnt =0;
		for(int i=sx;i<sx+8;i++) {
			for(int j=sy;j<sy+8;j++) {//8*8 체스판에서 대각선에있는 것이 같은색 => (i+j)% 2== 0 인게 대각선
				if((i+j) % 2== 0) { 
					cnt += temp==map[i][j]?0:1; //다른색일때 카운트
				}else {
					cnt += temp==map[i][j]?1:0;//대각선아닌좌표에서 같은색이면 카운트
				}
			}
		}
		cnt = cnt<64-cnt?cnt:64-cnt; //64개중 cnt한 개수와 나머지개수 비교해서 더적은거 칠하기
		count = cnt<count?cnt:count;
	}

}
