import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		Iterator<String> keys = map.keySet().iterator();
		
		String mKey = null;
		int max = 0;
		while(keys.hasNext()) {
			String key = keys.next();
			if(max<map.get(key)) {
				max = map.get(key);
				mKey = key;
			}else if(max == map.get(key)) {
				if(mKey.compareTo(key)>0) {
					mKey = key;
				}
			}
		}
		
		System.out.println(mKey);
	}
	
}
