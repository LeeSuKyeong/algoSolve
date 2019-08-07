import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Solution7701 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

		
			Set<String> dict2 = new HashSet<>();
			for (int i = 0; i < N; i++) {
				String temp = br.readLine();
				dict2.add(temp);
			}
			ArrayList<String> dict = new ArrayList<>(dict2);
			Collections.sort(dict, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					if(o1.length() != o2.length()) {
						return o1.length() - o2.length();
					}else {
						return o1.compareTo(o2);
					}
				}
			});
			
			System.out.println("#" + tc);
			for(String s : dict) {
				System.out.println(s);
			}
		}
	}

}
