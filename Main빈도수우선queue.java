import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main빈도수우선queue {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<>();
		int[] count = new int[100+1];
		
		int N =Integer.parseInt(st.nextToken());
		
		int num =0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			if(st.countTokens() != 1) {
				//en
				st.nextToken();
				num = Integer.parseInt(st.nextToken());
				arr.add(num);
				count[num]++;
//				System.out.println(Arrays.toString(count));
			}else {
				//de
				if(arr.size()==0) {
					sb.append(-1).append(" ");
					continue;
				}
				
				int maxNum = 0;
				int max = 0;
				for(int j=1;j<=100;j++) {
					if(max<count[j]) {
						max = count[j];
						maxNum = j;
					}
				}
				
				for(int j=0;j<arr.size();j++) {
					if(arr.get(j)== maxNum) {
						sb.append(maxNum).append(" ");
						count[maxNum]--;
						arr.remove(j);
						break;
					}
				}
			}
		}
		System.out.println(sb.toString());
		
	}

}
