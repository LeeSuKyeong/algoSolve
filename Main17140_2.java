import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main17140_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[100][100];
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rLen = 3,cLen = 3;
		int time = 0;
		
		while(arr[r][c] !=k && time<=100) {
			int mLen=0;
			time++;
			if(rLen>=cLen) {
				//행연산
				for(int i=0;i<rLen;i++) {
					int[][] tmp = new int[100+1][2];
					for(int j=0;j<=100;j++) {
						tmp[j][0] = j;
					}
					//count
					for(int j=0;j<100;j++) {
						if(arr[i][j] !=0) tmp[arr[i][j]][1]++;
					}
					Arrays.sort(tmp,new Comparator<int[]>() {

						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[1]==o2[1]?o1[0]-o2[0] :o1[1]-o2[1];
						}
					});
					
					int idx = 0;
					for(int j=0;j<101;j++) {
						if(tmp[j][1] !=0) {
							arr[i][idx++] = tmp[j][0];
							arr[i][idx++] =tmp[j][1];
						}
					}
					for(int j=idx;j<100;j++) {
						arr[i][j] =0;
					}
					if(mLen<idx) mLen = idx;
				}
				if(cLen<mLen) cLen = mLen;
			}else {
				//열연산
				for(int i=0;i<cLen;i++) {
					int[][] tmp = new int[100+1][2];
					for(int j=0;j<=100;j++) {
						tmp[j][0] = j;
					}
					
					//count
					for(int j=0;j<100;j++) {
						if(arr[j][i] !=0) tmp[arr[j][i]][1]++;
					}
					
					Arrays.sort(tmp,new Comparator<int[]>() {

						@Override
						public int compare(int[] o1, int[] o2) {
							return o1[1]==o2[1]?o1[0]-o2[0] :o1[1]-o2[1];
						}
					});
					
					int idx = 0;
					for(int j=0;j<101;j++) {
						if(tmp[j][1] !=0) {
							arr[idx++][i] = tmp[j][0];
							arr[idx++][i] =tmp[j][1];
						}
					}
					for(int j=idx;j<100;j++) {
						arr[j][i] =0;
					}
					if(mLen<idx) mLen = idx;
				}
				if(rLen<mLen) rLen = mLen;
			}
			
			
		}
		
		System.out.println(time>100?-1:time);
	}

}
