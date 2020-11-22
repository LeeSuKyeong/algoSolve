import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main5600 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[a+b+c+1];
		Arrays.fill(arr, 2);
		
		int N = Integer.parseInt(br.readLine());
		int[][] result = new int[N][4];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++) {
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(result,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[3]-o1[3];
			}
		});
		
		for(int i=0;i<N;i++) {
			int[] tmp = result[i];
			if(tmp[3] ==1) {
				for(int j=0;j<3;j++) {					
					arr[tmp[j]] =1;				
				}
			}else {
				
				if(arr[tmp[0]] == 1 && arr[tmp[1]] ==1) {
					arr[tmp[2]] = 0;
				}else if(arr[tmp[1]] ==1 && arr[tmp[2]] ==1) {
					arr[tmp[0]] = 0;
				}else if(arr[tmp[2]] ==1 && arr[tmp[0]] ==1){
					arr[tmp[1]] = 0;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<arr.length;i++) {
			sb.append(arr[i]).append('\n');
		}
		System.out.println(sb.toString());
	}

}
