import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14891 {
	static char[][] wheel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		wheel = new char[4+1][8];
	
		for(int i=1;i<=4;i++) {
			wheel[i] = br.readLine().toCharArray();
		}

		int K = Integer.parseInt(br.readLine());
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			check(num, dir);

		}
		
		int cnt =0;
		int score =1;
		for(int i=1;i<=4;i++) {
			if(wheel[i][0]=='1') {//s
				cnt+=score;
			}
			score*=2;
		}
		
		System.out.println(cnt);
	}
	
	static void check(int num, int dir) {
		char[][] temp = new char[4+1][8]; //회전전 복사
		int[] d = new int[4+1];
		d[num]=dir;
		copy(wheel,temp);
		//해당 바퀴
		move(num,dir);
		
		for(int i=num+1;i<=4;i++) {
			//해당번호에서 오른쪽부분
			if(temp[i-1][2] != temp[i][6]) {
				//다른극 ->회전
				d[i] = d[i-1]*-1;
				if(d[i] != 0) {
					move(i,d[i]);
				}
			}
		}
		
		for(int i=num-1;i>=1;i--) {
			//해당번호의 왼쪽부분
			if(temp[i][2] != temp[i+1][6]) {
				d[i] = d[i+1]*-1;
				if(d[i] != 0) {
					move(i,d[i]);
				}
			}
		}
		
	}
	static void move(int num, int dir) {
		if(dir == 1) {
			char c = wheel[num][7];
			for(int i=8-1;i>=1;i--) {
				wheel[num][i] = wheel[num][i-1];
			}
			wheel[num][0] = c;
		}else {
			char c = wheel[num][0];
			for(int i=0;i<8-1;i++) {
				wheel[num][i] = wheel[num][i+1];
			}
			wheel[num][7] = c;
		}
	}
	static void copy(char[][] farr,char[][] tarr) {
		for(int i=1;i<=4;i++) {
			for(int j=0;j<8;j++) {
				tarr[i][j] = farr[i][j];
			}
		}
	}
}
