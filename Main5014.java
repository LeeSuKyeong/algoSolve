import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5014 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		for(int i=0;i<5;i++) {
			arr[i] =Integer.parseInt(st.nextToken());
		}
		int F=arr[0],S=arr[1],G=arr[2],U=arr[3],D = arr[4];
		
		int[] floor = new int[F+1];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		floor[S] = 1;
		int p=0;
		boolean find = false;
		while(!q.isEmpty()) {
			
			p = q.poll();
			if(p==G) {
				find =true;
				break;
			}
			
			if(p+U<=F && floor[p+U]==0) {
				q.offer(p+U);
				floor[p+U] = floor[p]+1;
			}
			if(p-D>=1 && floor[p-D]==0) {
				q.offer(p-D);
				floor[p-D] = floor[p]+1;
			}
		}
		System.out.println(!find?"use the stairs":floor[p]-1);
	}
	
}
