import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main10866 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> list = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String comm = st.nextToken();
			int n=0;
			if(st.hasMoreTokens()) {				
				n = Integer.parseInt(st.nextToken());
			}
			
			switch(comm) {
			case "push_front":
				list.add(0, n);
				break;
			case "push_back":
				list.add(n);
				break;
			case "pop_front":
				if(list.size()==0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(list.get(0)).append('\n');
					list.remove(0);
				}
				break;
			case "pop_back":
				if(list.size()==0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(list.getLast()).append('\n');
					list.removeLast();
				}
				break;
			case "size":
				sb.append(list.size()).append('\n');
				break;
			case "empty":
				sb.append(list.isEmpty()?1:0).append('\n');
				break;
			case "front":
				if(list.size()==0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(list.get(0)).append('\n');
				}
				break;
			case "back":
				if(list.size()==0) {
					sb.append(-1).append('\n');
				}else {
					sb.append(list.getLast()).append('\n');
				}
				break;
			}
			
		}
		
		System.out.println(sb);
	}
	
}
