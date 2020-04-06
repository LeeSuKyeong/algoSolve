import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17140 {
	static int r,c,k,result=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		int[][] map = new int[3][3];
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(r-1<3 && c-1<3 && map[r-1][c-1] ==k) {
			System.out.println(0);
		}else {
			solve(map,1,3,3);
			System.out.println(result);
		}

		
		PriorityQueue<Node> pq = new PriorityQueue<>();
	
	
	}
	static void solve(int[][] map,int idx,int rCnt,int cCnt) {
		if(idx>100) {
			result = -1;
			return;
		}
		
		int[][] newMap = new int[100][100];
		if(rCnt>=cCnt) {
			//r
			int cnt=0;
			for(int i=0;i<rCnt;i++) {
				PriorityQueue<Node> pq = new PriorityQueue<>();
				HashMap<Integer,Integer> hm = new HashMap<>();
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j] == 0) {
						continue;
					}
					
					if(hm.containsKey(map[i][j])) {
						hm.put(map[i][j],hm.get(map[i][j])+1);
					}else {
						hm.put(map[i][j], 1);						
					}
				}
				
				for(int temp : hm.keySet()) {
					pq.offer(new Node(temp,hm.get(temp)));
				}
				
				int j=0;
				while(!pq.isEmpty()) {
					Node n = pq.poll();
					newMap[i][j]=n.n;
					newMap[i][j+1]=n.c;
					
					j+=2;
					if(j>100) {
						j=100;
						break;
					}
				}
				
				cnt = cnt>j?cnt:j;
			}
			cCnt = cnt;
		}else {
			//c
			int cnt = 0;
			
			for(int i=0;i<cCnt;i++) {
				PriorityQueue<Node> pq = new PriorityQueue<>();
				HashMap<Integer,Integer> hm = new HashMap<>();
				for(int j=0;j<rCnt;j++) {
					if(map[j][i] == 0) {
						continue;
					}
					
					if(hm.containsKey(map[j][i])) {
						hm.put(map[j][i],hm.get(map[j][i])+1);
					}else {
						hm.put(map[j][i], 1);						
					}
				}
				
				for(int temp : hm.keySet()) {
					pq.offer(new Node(temp,hm.get(temp)));
				}
				
				int j=0;
				while(!pq.isEmpty()) {
					Node n = pq.poll();
					newMap[j][i]=n.n;
					newMap[j+1][i]=n.c;
					j+=2;
					if(j>100) {
						j=100;
						break;
					}
				}
				
				cnt = cnt>j?cnt:j;
			}
			
			rCnt = cnt;
		}
		
		if(newMap[r-1][c-1] ==k ) {
			result = idx;
		}else {
			solve(newMap,idx+1,rCnt,cCnt);
		}
	}
	
	static class Node implements Comparable<Node>{
		
		int n;
		int c;
		
		public Node(int n, int c) {
			super();
			this.n = n;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return this.c==o.c?this.n-o.n:this.c-o.c;
		}
		
	}
}
