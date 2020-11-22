import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17779 {
	static int[][] map;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N =Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				//x,y
				find(i,j);
			}
		}
		
		System.out.println(result);
	}
	
	static int result = Integer.MAX_VALUE;
	static void devide(int x,int y, int x1,int y1,int x2, int y2, int x3,int y3) {
		int max = 0;
		int min = Integer.MAX_VALUE;
		int[][] visit = new int[N][N];
		//지역1
		int cnt1 = 0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<=y;j++) {
				cnt1+=map[i][j];
				visit[i][j] = 1;
			}
		}
		
		int tmp = y;
		for(int i=x;i<x1;i++) {
			for(int j=0;j<tmp;j++) {
				cnt1+= map[i][j];
				visit[i][j] = 1;
			}
			tmp--;
		}
		
		min = cnt1<min?cnt1:min;
		max = cnt1>max?cnt1:max;
		//지역2
		int cnt2 = 0;
		for(int i=0;i<x;i++) {
			for(int j=y+1;j<N;j++) {
				cnt2+=map[i][j];
				visit[i][j] = 2;
			}
		}
		tmp = y+1;
		for(int i=x;i<=x2;i++) {
			for(int j=tmp;j<N;j++) {
				cnt2+=map[i][j];
				visit[i][j] = 2;
			}
			tmp++;
		}
		min = cnt2<min?cnt2:min;
		max = cnt2>max?cnt2:max;
		
		//지역3
		int cnt3 = 0;

		tmp = y1;
		for(int i=x1;i<=x3;i++) {
			for(int j=0;j<tmp;j++) {
				cnt3+= map[i][j];
				visit[i][j] = 3;
			}
			tmp++;
		}
		
		for(int i=x3+1;i<N;i++) {
			for(int j=0;j<y3;j++) {
				cnt3+=map[i][j];
				visit[i][j] = 3;
			}
		}
		min = cnt3<min?cnt3:min;
		max = cnt3>max?cnt3:max;
		//지역4
		int cnt4 = 0;

		tmp = y2-1;
		for(int i=x2+1;i<=x3;i++) {
			for(int j=tmp+1;j<N;j++) {
				cnt4+= map[i][j];
				visit[i][j] = 4;
			}
			tmp--;
			if(tmp<0) tmp=0;
		}
		
		for(int i=x3+1;i<N;i++) {
			for(int j=y3;j<N;j++) {
				cnt4+=map[i][j];
				visit[i][j] = 4;
			}
		}
		min = cnt4<min?cnt4:min;
		max = cnt4>max?cnt4:max;
		
		//지역5
		int cnt5=0;
		int tmp1 = y;
		int tmp2 = y;
	
		for(int i=x;i<=x3;i++) {
			for(int j=tmp1;j<=tmp2;j++) {
				cnt5 += map[i][j];
				visit[i][j] = 5;
			}
			
			if(i>=x1) {
				tmp1++;
			}else {
				tmp1--;
			}
			
			if(i>=x2) {
				tmp2--;
			}else {
				tmp2++;
			}
			
			if(tmp1<0) tmp1 =  0;
			if(tmp2>=N) tmp2 = N-1;
		}
		min = cnt5<min?cnt5:min;
		max = cnt5>max?cnt5:max;
		
		result = result>max-min?max-min:result;
	}
	static void find(int x, int y) {
		
		for(int d1 = 1;d1<N;d1++) {
			int x1 = x+d1;
			int y1 = y-d1;
			if(x1<0 || x1>=N || y1<0 || y1>=N ) continue;
			
			for(int d2 = 1;d2<N;d2++) {
				int x2 = x+d2;
				int y2 = y+d2;
				if(x2<0 || x2>=N || y2<0 || y2>=N ) continue;
			
				//x3,y3
				int x3 = x+d1+d2;
				int y3 = y-d1+d2;
				
				if(x3<0 || x3>=N || y3<0 || y3>=N) continue;
				
				devide(x,y,x1,y1,x2,y2,x3,y3);
			}
		}
	}
}
