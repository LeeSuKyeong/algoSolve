import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main8911 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			String comm = br.readLine();
			int len = comm.length();
			int miny=0,minx=0,maxy=0,maxx=0;
			int d = 0;
			int cx=0,cy=0;
			for(int i=0;i<len;i++) {
				
				char c= comm.charAt(i);
				if(c=='F') {
					cx +=dx[d];
					cy +=dy[d];
				}else if(c=='B') {
					cx -=dx[d];
					cy -=dy[d];
				}else if(c=='L') {
					d=(d-1+4)%4;
				}else if(c=='R') {
					d=(d+1)%4;
				}
				minx = cx<minx?cx:minx;
				miny = cy<miny?cy:miny;
				maxx = cx>maxx?cx:maxx;
				maxy = cy>maxy?cy:maxy;
			}
			sb.append((maxx-minx)*(maxy-miny)).append('\n');
		}
		System.out.println(sb);
	}
}
