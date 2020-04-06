import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main17281 {
	
	static int[][] arr;
	static boolean[] visit;
	static int N,cnt;
	static HashSet<Integer> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		cnt = 0;
		N = Integer.parseInt(br.readLine());
		int[] order = new int[9+1];
		visit= new boolean[9+1];
		order[4] = 1;

		arr = new int[N][9+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=9;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		
		perm(1,order);
		
		System.out.println(cnt);
	}
	
	static void perm(int idx,int[] order) {
		if(idx==10) {
			cal(order);
			return;
		}
		if(idx == 4) {
			perm(idx+1,order);
			return;
		}
		
		for(int i=2;i<=9;i++) {
			if(!visit[i]) {
				order[idx] = i;
				visit[i] = true;
				perm(idx+1,order);
				visit[i] = false;
			}
		}
	}
	
	static void cal(int[] order) {
		int idx = 0;
		boolean[] ground = new boolean[3];
		int inning = 0;
		int out = 0;
		int score = 0;
		
		while(true) {
			idx++;
			if(idx==10) {
				idx=1;
			}
			
			if(arr[inning][order[idx]]==1) { //안타
				if(ground[2] == true) {
					score++;
				}

				ground[2] = ground[1];
				ground[1] = ground[0];
				ground[0] = true;
				
			}else if(arr[inning][order[idx]] == 2) {//2루타
				if(ground[2] == true) {
					score++;
				}
				if(ground[1] ==true) {
					score++;
				}
				ground[2] = ground[0];
				ground[1] = true;
				ground[0] = false;
			}else if(arr[inning][order[idx]] == 3) {//3루타
				for(int i=0;i<3;i++) {
					if(ground[i] == true) {
						score++;
					}
					ground[i] = false;
				}
				ground[2] = true;
			}else if(arr[inning][order[idx]] == 4) {//홈런
				for(int i=0;i<3;i++) {
					if(ground[i] == true) {
						score++;
					}
					ground[i] = false;
				}
				score++;
			}else {
				out++;
			}
			
			if(out==3) {
				inning++;
				out = 0;
				Arrays.fill(ground, false);
			}
			
			if(inning==N) {
				break;
			}
		}
		
		cnt = score>cnt?score:cnt;
	}

}
