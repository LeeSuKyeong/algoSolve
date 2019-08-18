import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main7682 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String s;
		char[][] map = new char[3][3];
		int cntX,cntO;
		
		while(!"end".equals(s=br.readLine())) {
			cntX=0;
			cntO=0;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					map[i][j]=s.charAt(3*i+j);
					if(map[i][j] =='X') {
						cntX++;
					}else if(map[i][j]=='O') {
						cntO++;
					}
					
				}
			}
			if(cntX==0) {
				System.out.println("invalid");
			}else if(Math.abs(cntX-cntO)>1) {
				System.out.println("invalid");
			}else if(cntX<cntO) { //O가 X보다 많은경우
				System.out.println("invalid");
			}else {
				int checkX = check(map,'X');
				int checkO = check(map,'O');
				if((cntX+cntO) <9 && checkO ==0 && checkX==0) {//돌을 다 채우지 않았는데 완성한게 없는 경우
					System.out.println("invalid");
				}else if(checkO ==1 && cntX>cntO) {//3개이어진경우에도 더 진행한경우
					System.out.println("invalid");
				}else if(checkX ==1 && cntX<=cntO) {//3개이어진경우에도 더 진행한경우
					System.out.println("invalid");
				}else if(checkO>1) {//완성된게 1개보다 많은경우
					System.out.println("invalid");
				}else if(checkX>1) {//완성된게 1개보다 많은경우
					if(cntX ==5 && cntO == 4) {
						System.out.println("valid");
					}else {
						System.out.println("invalid");
					}
				}else {
					System.out.println("valid");
				}
			}
		}
	}

	static int check(char[][] map,char c) {
		int cnt = 0;
		int numR =0,numC= 0;
		//가로,세로
		for(int i=0;i<3;i++) {
			numR = 0;
			numC =0;
			for(int j=0;j<3;j++) {
				if(map[i][j] == c) {
					numR++;
				}
				if(map[j][i] ==c) {
					numC++;
				}
			}
			cnt= numR==3?cnt+1:cnt;
			cnt= numC==3?cnt+1:cnt;
		}

		//대각선
		numR =0;
		numC = 0;
		for(int i=0;i<3;i++) {
			if(map[i][i] ==c) {
				numR++;
			}
			if(map[i][2-i]==c) {
				numC++;
			}
		}
		cnt = numR ==3? cnt+1:cnt;
		cnt = numC ==3? cnt+1:cnt;
		
		return cnt;
	}

}
