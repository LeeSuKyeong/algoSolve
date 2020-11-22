import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16959 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		boolean w = false;
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j] == '.'){
					map[i][j] = 'D';
				}
			}
		}
		
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,-1,0,1};
		boolean flag = true;
		label:for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] == 'W') {		
					
					for(int k=0;k<4;k++) {
						int nx = i+dx[k];
						int ny = j+dy[k];
						if(nx>=0 && ny>=0 && nx<R && ny<C) {							
							if(map[nx][ny] == 'S') {
								flag = false;
								break label;
							}
						}
					}
				}
				
			}
		}
		
		System.out.println(flag ?1:0);
		if(flag) {			
			StringBuilder sb =new StringBuilder();
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {				
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			
			System.out.println(sb.toString());
		}
		
	}
	
}
