import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17136_2 {
	static int[][] map;
	static boolean[][] visit;
	static int[] count;
	static int use=0,answer=Integer.MAX_VALUE,cnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		visit = new boolean[10][10];
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		count = new int[5];
		for(int i=0;i<5;i++) {
			count[i] = 5;
		}
		dfs(0,0);
		
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	static boolean check(int x,int y,int s) {
		for(int i=x;i<x+s;i++) {
			for(int j=y;j<y+s;j++) {
				if(visit[i][j] || map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	static void attach(int x,int y,int s) {
		for(int i=x;i<x+s;i++) {
			for(int j=y;j<y+s;j++) {
				visit[i][j] = true;
				cnt--;
			}
		}
	}
	static void detach(int x,int y,int s) {
		for(int i=x;i<x+s;i++) {
			for(int j=y;j<y+s;j++) {
				visit[i][j] = false;
				cnt++;
			}
		}
	}
	static void dfs(int sx,int sy) {
		if(answer<=use) {//memoization
			return;
		}
		if(cnt ==0) {//모든곳에 색종이붙임
			answer = answer<use?answer:use;
			return;
		}
		for(int i=sx;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j] ==1 && !visit[i][j]) { //색종이붙여야하는곳
					for(int k=5;k>=1;k--) {//붙일색종이크기
						if(count[k-1]>0 && i+k<=10 && j+k<=10 && check(i,j,k)) {
							attach(i,j,k);
							count[k-1]--;
							use++;
							dfs(i,j);
							detach(i,j,k);
							count[k-1]++;
							use--;
						}
					}
					return; //색종이붙여야하는데 못붙인경우
					
				}
			}
		}

	}
}
