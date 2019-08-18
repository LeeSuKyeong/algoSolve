import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main10814 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Info> arr = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			arr.add(new Info(Integer.parseInt(st.nextToken()),st.nextToken()));
			
		}
		
		Collections.sort(arr,new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				return o1.age<o2.age?-1:o1.age>o2.age?1:0;
			}
		});
		for(int i=0;i<N;i++) {
			System.out.println(arr.get(i).age + " " + arr.get(i).name);
		}
		
	}
	
	static class Info {
		int age;
		String name;
		public Info(int age, String name) {
			this.age = age;
			this.name = name;
		}
	
	}

}
