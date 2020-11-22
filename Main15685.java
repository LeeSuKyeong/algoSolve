import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main15685 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[100+1][100+1];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			
			attach(map,dList(d,g),x,y);
		}
		
		int cnt = 0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

	static int[] dy = {0,-1,0,1};
	static int[] dx = {1,0,-1,0};
	static void attach(boolean[][] map, int[] arr, int x, int y) {
		int len = arr.length;
		
		map[y][x] = true;
		for(int i=0;i<len;i++) {
			int d = arr[i];
			y+=dy[d];
			x+=dx[d];
			map[y][x] =true;
		}
		
	}
	static int[] dList(int d,int g) {
		int[] arr = new int[(int)Math.pow(2, g)];
		
		int idx= 1;
		arr[0] = d;
		for(int i=0;i<g;i++) {
			for(int j=idx-1;j>=0;j--) {
				arr[idx++] = (arr[j]+1)%4;
			}
		}
		return arr;
	}
}
