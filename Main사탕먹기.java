import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main사탕먹기 {
	static int[] candy;
	static ArrayList<Integer>[] follower;
	static boolean[] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		candy = new int[N];
		visit = new boolean[N];
		
		follower = new ArrayList[N];
		for(int i=0;i<N;i++) {
			follower[i] = new ArrayList<>();
		}
		
		int idx = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			idx = (idx+1)%N;
			String card = st.nextToken();
			if("A".equals(card)) {
				candy[idx]++;
				//팔로워사탕
				visit = new boolean[N];
				for(int i=0;i<follower[idx].size();i++) {					
					dfs(follower[idx].get(i));
				}
			}else if("J".equals(card)) {
				candy[(idx+1)%N]++;
				candy[(idx+N-1)%N]++;
				//팔로워사탕
				visit = new boolean[N];
				for(int i=0;i<follower[(idx+1)%N].size();i++) {					
					dfs(follower[(idx+1)%N].get(i));
				}
				for(int i=0;i<follower[(idx+N-1)%N].size();i++) {					
					dfs(follower[(idx+N-1)%N].get(i));
				}
			}else if("Q".equals(card)) {
				for(int i=0;i<candy.length;i++) {
					candy[i]++; 
				}
			}else if("K".equals(card)) {
				//팔로워지정
				follower[idx].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		
		for(int i=0;i<N;i++) {
			sb.append(candy[i]).append(" ");
		}
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if(visit[idx]) {
			return;
		}
		
		visit[idx] = true;
		candy[idx]++;
		
		for(int i=0;i<follower[idx].size();i++) {
			dfs(follower[idx].get(i));
		}
	}
}
