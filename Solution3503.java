import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1;tc<=T;tc++) {
			int result = 0;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			ArrayList<Integer> afterArray = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			afterArray.add(arr[arr.length-1]);
			for(int i=arr.length-2;i>=0;i-=2) {
				afterArray.add(arr[i]);
				if(afterArray.get(afterArray.size()-2) - afterArray.get(afterArray.size()-1)>result) {
					result = afterArray.get(afterArray.size()-2) - afterArray.get(afterArray.size()-1);
				}
				
				if(i-1 >= 0) {
					afterArray.add(0, arr[i-1]);
					if(afterArray.get(1) - afterArray.get(0)>result) {
						result = afterArray.get(1) - afterArray.get(0);
					}
				}
			}
			
			if(Math.abs(afterArray.get(0) - afterArray.get(1))>result){
				result = Math.abs(afterArray.get(0) - afterArray.get(1));
			}
			
			System.out.println("#" + tc + " " + result);
		}
		
	}

}
