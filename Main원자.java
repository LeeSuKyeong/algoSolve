import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main원자 {
	static int count,S;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visit = new boolean[1000*2+1][1000*2+1];
		bfs();
		System.out.println(count);
	}
	
	static void bfs() {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(1,0,0));
		visit[1][0] =true;
		while(!q.isEmpty()) {
			Info info = q.poll();
			if(info.cnt -1 == S || info.cnt +info.clipboard == S) {
				count = info.time + 1;
				return;
			}
			
			if(info.clipboard==0) {
				visit[info.cnt][info.cnt] = true;
				q.offer(new Info(info.cnt,info.cnt,info.time+1));
				continue;
			}
			if(info.clipboard != info.cnt) {
				visit[info.cnt][info.cnt] = true;
				q.offer(new Info(info.cnt,info.cnt,info.time+1));
			}
			if(info.cnt >1 && !visit[info.cnt-1][info.clipboard]) {
				visit[info.cnt-1][info.clipboard]=true;
				q.offer(new Info(info.cnt-1,info.clipboard,info.time+1));
			}
			if(info.cnt != 0 && !visit[info.cnt + info.clipboard][info.clipboard]) {
				visit[info.cnt +info.clipboard][info.clipboard] = true;
				q.offer(new Info(info.cnt +info.clipboard,info.clipboard,info.time+1));
			}
			
			
		}
	}
	static class Info{
		int cnt;
		int clipboard;
		int time;
		public Info(int cnt, int clipboard,int time) {
			super();
			this.cnt = cnt;
			this.clipboard = clipboard;
			this.time=time;
		}
		
	}
}
