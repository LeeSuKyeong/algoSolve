import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main11053 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(arr.size()==0) {
				arr.add(temp);				
			}else {
				if(arr.get(arr.size()-1)<temp) {
					arr.add(temp);
	
				}else if(arr.get(arr.size()-1)>temp){
					find(arr,temp);
				}
			}
			
		}
		System.out.println(arr.size());
	}

	static void find(ArrayList<Integer> arr, int temp) {
		int f=0;
		int e=arr.size()-1;
		int mid=0;
		while(f<e) {
			mid = (f+e)/2;
			if(arr.get(mid)<temp) {
				f=mid+1;
			}else{
				e=mid;
			}
		}
		arr.set(e, temp);

	}
		
}
