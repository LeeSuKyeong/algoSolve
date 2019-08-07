import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1259 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int num = Integer.parseInt(br.readLine());
			int[][] info = new int[num+1][4]; //수,암,앞에올나사index,뒤에올나사index

			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=num;i++) {
				info[i][0] = Integer.parseInt(st.nextToken());
				info[i][1] = Integer.parseInt(st.nextToken());
				
				if(i != 1) {
					for(int j=1;j<=num;j++) {
						if(info[j][0]==info[i][1]) {
							info[j][2] = i;
							info[i][3] = j;
						}else if(info[j][1] == info[i][0]) {
							info[j][3] = i;
							info[i][2] = j;
						}
					}
				}
				
			}
			
			int start=0;
			for(int i=1;i<=num;i++) {
				if(info[i][2] ==0) {
					start =i;
					break;
				}
			}
			System.out.print("#" + tc);
			while(start !=0) {
				System.out.print(" " + info[start][0] + " " + info[start][1]);
				start = info[start][3];
			}
			System.out.println();
		}
	}

}
