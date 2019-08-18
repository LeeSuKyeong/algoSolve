import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17406 {
	static int N,M,K;
	static int[][] rotate,oArr;
	static int min =Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		oArr = new int[N][M];
		//원본 배열
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				oArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//회전용
		rotate = new int[K][3];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			rotate[i][0] = Integer.parseInt(st.nextToken())-1;
			rotate[i][1] = Integer.parseInt(st.nextToken())-1;
			rotate[i][2] = Integer.parseInt(st.nextToken());
		}
		dfs(0,rotate);

		System.out.println(min);
	}
	
	static void swap(int[] a ,int[] b) {
		int[] temp = new int[3];

		temp[0] = a[0];
		temp[1] = a[1];
		temp[2] = a[2];

		a[0] = b[0];
		a[1] = b[1];
		a[2] = b[2];

		b[0] = temp[0];
		b[1] = temp[1];
		b[2] = temp[2];
	}
	
	static void dfs(int idx,int[][] rotate) {//rotate 순서 맞추는 용도
		if(K== idx) {
			rMatrix(rotate);
			return;
		}
		for(int i = idx ; i<K;i++) {
			swap(rotate[i],rotate[idx]);
			dfs(idx+1,rotate);
			swap(rotate[i],rotate[idx]);
		}

	}
	
	static void rMatrix(int[][] rotate) {//회전연산 차례대로
		int[][] arr =new int[N][M];
		copy(arr);
		int sx, sy,ex,ey;
		for(int idx=0;idx<K;idx++) {
			sx = rotate[idx][0]-rotate[idx][2];
			sy = rotate[idx][1]-rotate[idx][2];
			ex = rotate[idx][0]+rotate[idx][2];
			ey = rotate[idx][1]+rotate[idx][2];

			for(int i=sx;i<rotate[idx][0];i++) {
				int temp = arr[sx][sy];
				for(int j=sx;j<ex;j++) {//왼
					arr[j][sy] = arr[j+1][sy];
				}
				for(int j=sy;j<ey;j++) {//아
					arr[ex][j] = arr[ex][j+1];
				}
				for(int j=ex;j>sx;j--) {//오
					arr[j][ey] = arr[j-1][ey];
				}
				for(int j=ey;j>sy;j--) {//위
					arr[sx][j] = arr[sx][j-1];			
				}
				arr[sx][sy+1]= temp;
				sx++;
				sy++;
				ex--;
				ey--;
			}

		}
		minValue(arr);
	}
	static void copy(int[][] arr) { //deepcopy
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] = oArr[i][j];
			}
		}
	}
	static void minValue(int[][] arr) {//배열 최소값구하기
		int cnt = 0;
		for(int i=0;i<N;i++) {
			cnt = 0;
			for(int j=0;j<M;j++) {
				cnt += arr[i][j];
			}
			min= cnt<min ? cnt:min;
		}
	}

}
