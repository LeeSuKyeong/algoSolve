import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main곤충카드모으기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int n = st.countTokens();
		Map<String, Integer> map = new HashMap<String, Integer>();

		for(int i=0;i<n;i++) {
			String s = st.nextToken();
			if(map.containsKey(s)) {
				map.put(s,map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		Set<String> keys=map.keySet();
		
		int cnt = 0;
		int cardNum = 0;
		boolean flag = false;
		boolean answerYN = false; 
		int totalNum = 0;
		
		for(String key : keys){ 	
			totalNum += map.get(key);
			
			if(cardNum == 0 ) {
				cardNum = map.get(key);
				cnt++;
			}else if(cardNum == map.get(key)) {
				cnt++;
			}else {
				if(!flag && cardNum==map.get(key)+1) {
					cnt++;
					totalNum++;
					flag = true;
				}else if(!flag && cnt== 1 && cardNum == map.get(key)-1) {
					cnt++;
					totalNum++;
					flag = true;
					cardNum = map.get(key)-1;
				}else if(flag) {
					answerYN = true;
					break;
				}
			}
		}
		
		//카드비교덜했으면 못만드는경우
		if(cnt != map.size()) {
			answerYN = true;
		}
		
		if(answerYN) {
			System.out.println("N");
		}else {
			System.out.println("Y");
		}
		System.out.println(totalNum);
		System.out.println(map.size());
		
	}
}
