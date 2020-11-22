import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main10816 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if(map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp)+1);
			}else {				
				map.put(tmp, 1);
			}
		}
		
		StringBuilder sb =new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int tmp = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(tmp)) {
				sb.append(map.get(tmp));
			}else {
				sb.append(0);
			}
			sb.append(' ');
		}
		
		sb.deleteCharAt(sb.length()-1);
		System.out.println(sb);
		
	}
}
