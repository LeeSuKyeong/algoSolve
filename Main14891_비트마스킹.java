import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14891_비트마스킹 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] wheel = new int[4];
		for(int i=0;i<4;i++) {
			String tmp = br.readLine();
			
			for(int j=0;j<8;j++) {
				int n = tmp.charAt(j)-'0';
				wheel[i] = wheel[i] | (n<<j); //톱니바퀴모양을 비트로 변환
			}
		}
		int mapping = 255; // 자리수 매핑할값 11111111
		
		int k= Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken());
			
			int[] tmpWheel = new int[4];//회전한 값을 임시저장할 배열
			for(int j=0;j<4;j++) {
				tmpWheel[j] = wheel[j];
			}
			
			//기준바퀴 오른쪽
			int dd = d*(-1); //기준바퀴 오른쪽 바퀴가 움직일방향
			for(int j=idx;j<4-1;j++) {
				if(((wheel[j]>>2) & 1) == ((wheel[j+1]>>6) &1)) { // 같은값이면 더이상 바퀴조작x
					break;
				}
				
				//move
				if(dd ==1) {
					int tmp = (wheel[j+1] >>7);
					tmpWheel[j+1] = tmp | ((wheel[j+1]<<1) & mapping); 
				}else {
					int tmp = wheel[j+1] & 1;
					tmpWheel[j+1] = (tmp<<7) | ((wheel[j+1]>>1) & mapping);
				}
				dd *=-1;
			}
			
			//기준바퀴 왼쪽
			dd = d*(-1); //기준바퀴 왼쪽 바퀴가 움직일방향
			for(int j=idx-1;j>=0;j--) {
				
				if(((wheel[j]>>2) & 1) == ((wheel[j+1]>>6) &1)) {// 같은값이면 더이상 바퀴조작x
					break;
				}
				
				//move
				if(dd ==1) {
					int tmp = (wheel[j] >>7);
					tmpWheel[j] = tmp | ((wheel[j]<<1) & mapping); 
				}else {
					int tmp = wheel[j] & 1;
					tmpWheel[j] = (tmp<<7) | ((wheel[j]>>1) & mapping);
				}
				
				dd *=-1;
			}
			//기준바퀴회전
			if(d==1) {
				int tmp = (wheel[idx] >>7);
				tmpWheel[idx] = tmp | ((wheel[idx]<<1) & mapping); 
			}else {
				int tmp = wheel[idx] & 1;
				tmpWheel[idx] = (tmp<<7) | ((wheel[idx]>>1) & mapping);
			}
			
			wheel = tmpWheel;
		}
		
		int sum = 0;
		for(int i=0;i<4;i++) {
			sum+=Math.pow(2, i) * (1 & wheel[i]);
		}
		System.out.println(sum);
	}

}
