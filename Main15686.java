import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		

		ArrayList<int[]> store = new ArrayList<>();
		ArrayList<int[]> house = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int v= Integer.parseInt(st.nextToken());
				if(v == 2) store.add(new int[] {i,j});
				else if(v==1) house.add(new int[] {i,j});
			}
		}
		
		combination(M, store, house);
		System.out.println(min);
	}
	static int min = Integer.MAX_VALUE;
	static void combination(int M,ArrayList<int[]> store,ArrayList<int[]> house) {
		int size = store.size();
		for(int i=0;i<(1<<size);i++) {
			
			if(Integer.bitCount(i)==M) {
				cal(i,store,house);
			}
		}
	}
	
	static void cal(int visit, ArrayList<int[]> store,ArrayList<int[]> house) {
		int totalDist = 0;
		for(int[] h :house) {
			int mindist = Integer.MAX_VALUE;
			int v = visit;
			int idx = 0;
			while(v!=0) {
				if( (v & 1) ==1) {
					int[] s = store.get(idx);
					int dist = Math.abs(s[0]-h[0])+Math.abs(s[1]-h[1]);
					
					mindist = dist<mindist?dist:mindist;
				}
				idx++;
				v= v>>1;
			}
			
			totalDist+= mindist;
			if(min<=totalDist) return;
		}
		
		min = totalDist;
	}
}
