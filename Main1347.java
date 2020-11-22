import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1347 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[][] map = new boolean[3*N][3*N];
		String move = br.readLine();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int x =N, y=N, d = 2;
		int mix =N,miy = N, maxx=N,maxy=N;
		map[x][y] = true;
		for(int i=0;i<N;i++) {
			switch(move.charAt(i)) {
			case 'R':
				d= (d+1)%4;
				break;
			case 'L':
				d= (d-1+4)%4;
				break;
			case 'F':
				x+=dx[d];
				y+=dy[d];
				
				map[x][y] = true;
				if(x>maxx) maxx = x;
				else if(x<mix) mix = x;
				
				if(y>maxy) maxy = y;
				else if(y<miy) miy = y;
				break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=mix;i<=maxx;i++) {
			for(int j=miy;j<=maxy;j++) {
				sb.append(map[i][j]?'.':'#');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
