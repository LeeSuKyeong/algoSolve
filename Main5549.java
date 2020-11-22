import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * prefix sum(부분합)
 * ab
 * cd
 * 일때 탐사범위 d의 범위 합 = abcd전체구역-ab구역-ac구역+a구역
 * abcd의 누적합 구하기 = ab구역+ac구역-a+d
 */
public class Main5549 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[][][] map = new int[M+1][N+1][3];

		HashMap<Character, Integer> hash = new HashMap<>();
		hash.put('J', 0);
		hash.put('O', 1);
		hash.put('I', 2);

		for(int i=1;i<=M;i++) {
			String tmp = br.readLine();
			for(int j=1;j<=N;j++) {
				int c = hash.get(tmp.charAt(j-1));
				for(int k=0;k<3;k++) { // (i,j)까지의 직사각형 구역 누적합					
					map[i][j][k] = map[i-1][j][k] +map[i][j-1][k] -map[i-1][j-1][k];
				}
				map[i][j][c]++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			int[] cnt = new int[3];
			for(int j=0;j<3;j++) {
				cnt[j] = map[ex][ey][j] - map[ex][sy-1][j] -map[sx-1][ey][j] +map[sx-1][sy-1][j]; 
			}
			
			sb.append(cnt[0]).append(' ').append(cnt[1]).append(' ').append(cnt[2]).append('\n');
		}
		
		System.out.println(sb.toString());
	}

}
