import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> q = new LinkedList<>();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			q.offer(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
