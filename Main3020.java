import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3020 {
// 장애물 0~n

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[] top = new int[H];
		int[] bottom = new int[H];
		
		int tmp ;
		for(int i=0;i<N;i++) {
			tmp = Integer.parseInt(br.readLine())-1;
			if(i%2==0) {
				bottom[tmp]++;
			}else {
				top[tmp]++;
			}
		}
		for(int i=H-2;i>=0;i--) {
			bottom[i]+=bottom[i+1];
			top[i]+=top[i+1];
		}

		int min = N;
		int cnt = 0;
		tmp=0;
		for(int i=0;i<H;i++) {
			tmp = bottom[i] + top[H-1-i];
			if(tmp==min) {
				cnt++;
			}else if(tmp<min) {
				cnt=1;
				min = tmp;
			}
			
		}
		
		System.out.println(min + " " +cnt);
	}
}
