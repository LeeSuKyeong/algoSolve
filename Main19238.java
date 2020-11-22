import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main19238 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int cost = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		departMap = new int[N][N];
		destInfo = new int[M+1][2];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int tmpx = Integer.parseInt(st.nextToken())-1;
			int tmpy = Integer.parseInt(st.nextToken())-1;

			departMap[tmpx][tmpy] = i + 1;
			tmpx = Integer.parseInt(st.nextToken())-1;
			tmpy = Integer.parseInt(st.nextToken())-1;

			destInfo[i+1]= new int[] {tmpx, tmpy};
		}
		personCnt = M;
		boolean flag = false;
		while (personCnt > 0) {
			Pos depart = findPerson(x, y, cost, N);
			if (depart == null) {
				flag = true;
				break;
			}
			cost = depart.cost;
			Pos dest = go(depart,N);
			if(dest == null) {
				flag = true;
				break;
			}
		
			cost += (cost-dest.cost);
			
			personCnt--;
			x = dest.x;
			y = dest.y;
		}
		System.out.println(!flag?cost:-1);
	}

	static int personCnt;
	static int[][] map;
	static int[][] departMap;
	static int[][] destInfo;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static Pos go(Pos depart,int N) {
		boolean[][] visit = new boolean[N][N];

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(depart.x, depart.y, depart.cost));
		visit[depart.x][depart.y] = true;
		while(!q.isEmpty()) {
			
			Pos p = q.poll();
			if(p.cost ==0) continue;
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny]) {
					if(map[nx][ny] == 1) continue;
					
					if(destInfo[depart.personNum][0] == nx && destInfo[depart.personNum][1] == ny) {
						
						return new Pos(nx,ny,p.cost-1);
					}
					
					q.add(new Pos(nx,ny,p.cost-1));
					visit[nx][ny] = true;
				}
			}
		}
		
		return null;
	}

	static Pos findPerson(int x, int y, int cost, int N) {
		if (departMap[x][y] != 0) {
			int num = departMap[x][y];
			departMap[x][y] = 0;
			return new Pos(x, y, cost,num);
		}
		
		ArrayList<Pos> list = new ArrayList<Pos>();
		boolean[][] visit = new boolean[N][N];

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y, cost));
		visit[x][y] = true;

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();
				if (p.cost == 0)
					continue;

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny]) {

						if (map[nx][ny] == 1) continue;
						visit[nx][ny] = true;
						q.add(new Pos(nx, ny, p.cost - 1));
						if (departMap[nx][ny] != 0) {
							list.add(new Pos(nx, ny, p.cost - 1,departMap[nx][ny]));
						}
					}
				}
			} // n번째에 갈수 있는 경로 끝

			if (list.size() > 0) {
				list.sort(new Comparator<Pos>() {

					@Override
					public int compare(Pos o1, Pos o2) {
						return o1.x == o2.x ? o1.y - o2.y : o1.x - o2.x;
					}
				});
				Pos tmp = list.get(0);
				departMap[tmp.x][tmp.y]= 0; 
				return tmp;
			}
		}
		return null;
	}

	static class Pos {
		int x, y, cost, personNum;

		public Pos(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		public Pos(int x, int y, int cost, int personNum) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.personNum = personNum;
		}
	}

}
