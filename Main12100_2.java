import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main12100_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] map =new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,map);
		System.out.println(max);
	}
	static int max = 0;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static void dfs(int cnt, int[][] map) {
		if(cnt==5) {
			find(map);
			return;
		}
		
		for(int i=0;i<4;i++) {
			int[][] nextMap = moveMap(map,i);
			dfs(cnt+1,nextMap);
		}
	}
	
	static void find(int[][] map) {
		int len =map.length;
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				max = map[i][j]<max?max:map[i][j];
			}
		}
		
	}
	static int[][] moveMap(int[][] map,int d){
		int len = map.length;
		int[][] nmap = new int[len][len];
		
		ArrayList<Integer> arr;
		switch(d) {
		case 0://위로 밀기
			for(int i=0;i<len;i++) {
				arr= new ArrayList<>();
				for(int j=0;j<len;j++) {
					if(map[j][i] !=0) arr.add(map[j][i]);
				}

				int idx =0;
				for(int j=0;j<arr.size();j++) {
					int tmp = arr.get(j);
					if(nmap[idx][i]==0) {
						nmap[idx][i] = tmp;
					}else if(nmap[idx][i] != tmp) {
						idx++;
						nmap[idx][i] = tmp;
					}else {
						nmap[idx][i]+=tmp;
						idx++;
					}
				}
			}
			
			break;
		case 1://오른쪽으로 밀기
			for(int i=0;i<len;i++) {
				arr= new ArrayList<>();
				for(int j=len-1;j>=0;j--) {
					if(map[i][j] !=0) arr.add(map[i][j]);
				}

				int idx =len-1;
				for(int j=0;j<arr.size();j++) {
					int tmp = arr.get(j);
					if(nmap[i][idx] ==0) {
						nmap[i][idx] = tmp;
					}else if(nmap[i][idx] != tmp) {
						idx--;
						nmap[i][idx] = tmp;
					}else {
						nmap[i][idx]+=tmp;
						idx--;
					}
				}
			}
			break;
		case 2://아래로 밀기
			for(int i=0;i<len;i++) {
				arr= new ArrayList<>();
				for(int j=len-1;j>=0;j--) {
					if(map[j][i] !=0) arr.add(map[j][i]);
				}

				int idx =len-1;
				for(int j=0;j<arr.size();j++) {
					int tmp = arr.get(j);
					if(nmap[idx][i]==0) {
						nmap[idx][i] = tmp;
					}else if(nmap[idx][i] != tmp) {
						idx--;
						nmap[idx][i] = tmp;
					}else {
						nmap[idx][i]+=tmp;
						idx--;
					}
				}
			}
			break;
		case 3://왼쪽으로 밀기
			for(int i=0;i<len;i++) {
				arr= new ArrayList<>();
				for(int j=0;j<len;j++) {
					if(map[i][j] !=0) arr.add(map[i][j]);
				}

				int idx =0;
				for(int j=0;j<arr.size();j++) {
					int tmp = arr.get(j);
					if(nmap[i][idx]==0) {
						nmap[i][idx] = tmp;
					}else if(nmap[i][idx] != tmp) {
						idx++;
						nmap[i][idx] = tmp;
					}else {
						nmap[i][idx]+=tmp;
						idx++;
					}
				}
			}
			break;
		}
		
		return nmap;
	}

}
