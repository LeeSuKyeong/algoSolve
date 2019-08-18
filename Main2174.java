import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2174 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());	
		int B = Integer.parseInt(st.nextToken());	
		int[][] map = new int[B][A];
		for(int i=0;i<map.length;i++) {
			Arrays.fill(map[i], -1);			
		}
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());	
		
		int temp;
		int[][] robot = new int[N][3];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			robot[i][1] = Integer.parseInt(st.nextToken())-1; 
			robot[i][0] = Integer.parseInt(st.nextToken())-1; 
			map[robot[i][0]][robot[i][1]]=i; 
			temp = st.nextToken().charAt(0);
			if(temp=='N') {
				robot[i][2] = 0;
			}else if(temp =='E') {
				robot[i][2] = 1;
			}else if(temp =='S') {
				robot[i][2] = 2;
			}else {
				robot[i][2] = 3;
			}
		}
		
		int r = 0,r2=0,n;
		char c,result = 0;
		label:for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			r= Integer.parseInt(st.nextToken())-1;
			c = st.nextToken().charAt(0);
			n = Integer.parseInt(st.nextToken());
			
			if(c=='L') {
				robot[r][2] = (robot[r][2] + 3*n)%4;
			}else if(c=='R') {
				robot[r][2] = (robot[r][2] + n)%4;
			}else {
				if(robot[r][2] ==0) {//N
					for(int j=1;j<=n;j++) {
						if(robot[r][0]+j >=B) {
							result ='w';
							break label;
						}
						if(map[robot[r][0]+j][robot[r][1]] !=-1) {
							//다른로봇있는경우
							result='r';
							r2=map[robot[r][0]+j][robot[r][1]];
							break label;
						}
					}
					map[robot[r][0]+n][robot[r][1]]=r;
					map[robot[r][0]][robot[r][1]]=-1;
					robot[r][0] +=n;
				}else if(robot[r][2] ==1) {//E
					for(int j=1;j<=n;j++) {
						if(robot[r][1]+j >=A) {
							result ='w';
							break label;
						}
						if(map[robot[r][0]][robot[r][1]+j] !=-1) {
							//다른로봇있는경우
							result='r';
							r2=map[robot[r][0]][robot[r][1]+j];
							break label;
						}
					}
					map[robot[r][0]][robot[r][1]+n]=r;
					map[robot[r][0]][robot[r][1]]=-1;
					robot[r][1] +=n;
				}else if(robot[r][2] ==2) {//S
					for(int j=1;j<=n;j++) {
						if(robot[r][0]-j <0) {
							result ='w';
							break label;
						}
						if(map[robot[r][0]-j][robot[r][1]] !=-1) {
							//다른로봇있는경우
							result='r';
							r2=map[robot[r][0]-j][robot[r][1]] ;
							break label;
						}
					}
					map[robot[r][0]-n][robot[r][1]]=r;
					map[robot[r][0]][robot[r][1]]=-1;
					robot[r][0] -=n;
				}else if(robot[r][2] ==3) {//W
					for(int j=1;j<=n;j++) {
						if(robot[r][1]-j <0) {
							result ='w';
							break label;
						}
						if(map[robot[r][0]][robot[r][1]-j] !=-1) {
							//다른로봇있는경우
							r2=map[robot[r][0]][robot[r][1]-j] ;
							result='r';
							break label;
						}
					}
					map[robot[r][0]][robot[r][1]-n]=r;
					map[robot[r][0]][robot[r][1]]=-1;
					robot[r][1] -=n;
				}
				
			}
		}
		
		if(result == 'r') {
			System.out.println("Robot "+(r+1)+" crashes into robot "+(r2+1));
		}else if(result =='w') {
			System.out.println("Robot "+(r+1)+" crashes into the wall");
		}else {
			System.out.println("OK");
		}
	}
		

}
