import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17143 {
	static int[] dx = {0,-1,1,0,0};
	static int[] dy = {0,0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map= new int[R+1][C+1];
		int[][] shark= new int[M+1][5]; 
		for(int i=1;i<=M;i++) {//상어정보
			st = new StringTokenizer(br.readLine());
			int[] temp = new int[5];
			for(int j=0;j<5;j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());//rcsdz
			}
			map[shark[i][0]][shark[i][1]]=i;
			if(shark[i][3] == 1 || shark[i][3] == 2) {//NS
				shark[i][2] %= (2*R-2);//자기원래자리로 돌아옴
			}else if(shark[i][3] == 3 || shark[i][3]== 4  ) {//EW
				shark[i][2] %= (2*C-2);
			}
			
		}
		int man = 0;//사람 위치
		int catchSize=0;//잡은물고기 크기합
		for(int i=1;i<=C;i++) {
			//1사람이동
			man++;
			//2 잡음
			for(int j=1;j<=R;j++) {
				if(map[j][i] !=0) {
					catchSize+=shark[map[j][i]][4];
					shark[map[j][i]][0]=-1;
					shark[map[j][i]][1]=-1;//물고기 죽음
					map[j][i] = 0;
					break;
				}
			}
			int[][] tMap = new int[R+1][C+1];//상어이동 후를 저장할 임시맵
			//3 상어이동
			for(int j=1;j<=M;j++) {
				if(shark[j][0]==-1) {//잡은상어는 패스
					continue;
				}
				for(int k=0;k<shark[j][2];k++) {//s속도
					if(shark[j][3] ==1 || shark[j][3] == 2) {
						//위아래로 이동하는 상어
						if(shark[j][0] == 1) {
							//제일 위에 있을때 방향 바꿈
							shark[j][3] =2;//s
						}else if(shark[j][0]==R){
							//제일 아래에있을때 방향 바꿈
							shark[j][3] =1;//n
						}
						
						shark[j][0] += dx[shark[j][3]];//상어 이동
			
					}else {
						//좌우로 이동하는 상어
						if(shark[j][1] == 1) {
							//제일 위에 있을때 방향 바꿈
							
							shark[j][3] =3;//e
						}else if(shark[j][1]==C){
							//제일 아래에있을때 방향 바꿈
							shark[j][3] =4;//w
						}
						shark[j][1] += dy[shark[j][3]];//상어 이동
					
					}
				}
				if(tMap[shark[j][0]][shark[j][1]] ==0) {//같은칸상어
					tMap[shark[j][0]][shark[j][1]]=j;
				}else {
					int temp = tMap[shark[j][0]][shark[j][1]];
					if(shark[j][4]>shark[temp][4]) {
						shark[temp][0] =-1;
						shark[temp][1] =-1;//dead
						tMap[shark[j][0]][shark[j][1]] = j;
					}else {
						shark[j][0] =-1;
						shark[j][1]= -1;
					}
				}
			}
			
			//update map
			copy(map,tMap,R,C);

		}
		
		System.out.println(catchSize);
	}
	
	static void copy(int[][] map , int[][] tMap,int R,int C) {
		for(int i=1;i<=R;i++) {
			for(int j=1;j<=C;j++) {
				map[i][j] = tMap[i][j];
			}
		}
	}
}
