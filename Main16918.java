import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16918 {
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R =Integer.parseInt(st.nextToken());
		int C =Integer.parseInt(st.nextToken());
		int N =Integer.parseInt(st.nextToken());

		int[][] map = new int[R][C];
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = temp.charAt(j)=='O'?0:2;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		if(N==1) {
			//N == 1 ==>초기상태
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j] != 0) {
						sb.append('.');
					}else {
						sb.append('O');
					}
				}
				sb.append("\n");
			}
			
		}else if(N==2 || N==4){
			//모두 o
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
						sb.append('O');
				}
				sb.append("\n");
			}
			
		}else {
			int time = 3;
			loop:while(true) {
				//3초전 폭탄 터뜨리기
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(time-map[i][j] ==3) {
							int temp = map[i][j];
							map[i][j] = -1;
							for(int k=0;k<4;k++) {
								int nx = i+dx[k];
								int ny = j+dy[k];
								if(nx>=0 && ny>=0 && nx<R && ny<C) {
									if(map[nx][ny] != temp && map[nx][ny] !=-1) {
										map[nx][ny] = -1;
									}
								}
							}
						}
					}
				}
				
				//n초면 스톱
				if(time==N) {
					break loop;
				}
				
				time++;
				//v폭탄없는 곳 설치
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(map[i][j] ==-1) {
							map[i][j] =time;
						}
					}
				}
				if(time==N) {
					break;
				}
				time++;
			}
			
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map[i][j] == -1) {
						sb.append('.');
					}else {
						sb.append('O');
					}
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());
		
		
	}


}
