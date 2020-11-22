import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(rplay(N,L,map)+cplay(N, L, map));
		
	}
	static int cplay(int N, int L,int[][] map) {
		int cnt =0;
		Step : for(int i=0;i<N;i++) {
			int h = map[0][i];
			boolean[] visit= new boolean[N];
			
			for(int j=0;j<N;j++) {

				if(h== map[j][i] + 1) { // 내려가는 경사로
					if(j+L >N) continue Step;

					boolean flag = false;
					for(int k= j;k<j+L;k++) {
						if(visit[k] || map[k][i]+1 !=h) {
							flag = true;
							
							for(int w=k;w>=j;w--) {
								visit[k] = false;
							}
							
							break;
						}
						visit[k] = true;
					}
					
					if(flag) continue Step;
					
					j=j+L-1;
					h--;
					
				}else if(h+1 == map[j][i]) { //올라가는경사로
					if(j-L<0) continue Step;
					
					boolean flag = false;
					for(int k=j-1;k>=j-L;k--) {
						if(visit[k] || map[k][i] != h) {
							flag = true;
							
							for(int w=k;w<=j-1;w++) {
								visit[k] = false;
							}
							
							break;
						}
						visit[k] = true;
					}
					
					if(flag) continue Step;
					
					h++;
				}else if(map[j][i]!=h) {
					continue Step;
				}
			}
			cnt++;
		}
		
		return cnt;
	}
	static int rplay(int N, int L,int[][] map) {
		int cnt =0;
		Step : for(int i=0;i<N;i++) {
			int h = map[i][0];
			boolean[] visit= new boolean[N];
			
			for(int j=0;j<N;j++) {
				
				if(h== map[i][j] + 1) { // 내려가는 경사로
					if(j+L >N) continue Step;
					
					boolean flag = false;
					for(int k= j;k<j+L;k++) {
						if(visit[k] || map[i][k]+1 !=h) {
							flag = true;
							
							for(int w=k;w>=j;w--) {
								visit[k] = false;
							}
							
							break;
						}
						visit[k] = true;
					}
					
					if(flag) continue Step;
					
					j=j+L-1;
					h--;
				}else if(h+1 == map[i][j]) { //올라가는경사로
					if(j-L<0) continue Step;
					boolean flag = false;
					for(int k=j-1;k>=j-L;k--) {
						if(visit[k] || map[i][k] != h) {
							flag = true;
							
							for(int w=k;w<=j-1;w++) {
								visit[k] = false;
							}
							
							break;
						}
						visit[k] = true;
					}
					
					if(flag) continue Step;
					
					h++;
				}else if(map[i][j]!=h) {
					continue Step;
				}
				
			}
			cnt++;
		}
		
		return cnt;
	}

}
