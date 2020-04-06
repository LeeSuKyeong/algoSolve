import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution6855 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
	
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int val = Integer.parseInt(st.nextToken());
			for(int i=1;i<N;i++) {
				int temp = Integer.parseInt(st.nextToken());
				pq.offer(Math.abs(val-temp));
				val =temp;
			}
			
			int sum = 0;
			for(int i=0;i<N-K;i++) {
				sum+=pq.poll();
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	
}
