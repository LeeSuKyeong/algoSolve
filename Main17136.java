import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17136 {
	static int[][] map;
	static boolean[][] visit;
	static int result = Integer.MAX_VALUE,oneNum=0;
	static int[] count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int sx = -1,sy = -1;
		map = new int[10][10];
		visit= new boolean[10][10];
		count = new int[5+1];
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(sx==-1 && sy == -1 && map[i][j] == 1) {
					sx = i;
					sy = j;
				}

			}
		}
			
		if(sx==-1 && sy ==-1) {
			result = 0;
		}else {
			dfs(sx,sy,0);
			if(result == Integer.MAX_VALUE) {
				result = -1;
			}

		}
		
		System.out.println(result);
	}
	static void dfs(int x, int y,int cnt) {
		if(result <= cnt) {//메모이제이션
			return;
		}

		for(int len=5;len>=1;len--) {
			if(count[len]>=5) {//len size 색종이가 5개이상 사용했으면 continue
				continue;
			}
			if(x+len<=10 && y+len <=10 && check(x,y,len)) {
				count[len]++;
				boolean[][] temp = new boolean[10][10];
				copy(visit, temp); //원본 복사
				checkVisit(x, y, len);//붙인곳 표시
				boolean flag = false; //더 붙일 곳이있는지 체크하는 변수
				label:for(int i=x;i<10;i++) {//붙인 색종이 다음
					for(int j=0;j<10;j++) {
						if(map[i][j] ==1 && !visit[i][j]) {
							//안붙인 구역
							flag = true;
							dfs(i,j,cnt+1);
							break label;
						}
					}
				}
				if(!flag) {//더이상 붙일 곳이 없는경우
					result = result>cnt+1? cnt+1:result;
				}
				count[len]--;
				copy(temp,visit);//원래대로
			}
		}
	}
	
	static boolean check(int x, int y,int len) { //색종이 붙일 수 있는지 확인
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(map[i][j] == 0 || visit[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	static void copy(boolean[][] a,boolean[][] b) {//방문 복구
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				b[i][j] = a[i][j];
			}
		}	
	}
	static void checkVisit(int x,int y,int len) {//색종이 붙이기
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				visit[i][j] = true;
			}
		}		

	}
}
