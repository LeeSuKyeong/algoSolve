import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main3048 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		String team1 = br.readLine();
		String team2 = br.readLine();
		StringBuilder sb = new StringBuilder(team1);
		sb.reverse();
		sb.append(team2);
		
		ArrayList<Character> dir = new ArrayList<>();
		for(int i=0;i<team1.length();i++) {
			dir.add('R');
		}
		for(int i=0;i<team2.length();i++) {
			dir.add('L');
		}
		
		int T =Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			for(int j=0;j<sb.length()-1;j++) {
				if(dir.get(j)=='R' && dir.get(j+1)=='L') {
					dir.set(j, 'L');
					dir.set(j+1, 'R');
					char temp =sb.charAt(j);
					sb.setCharAt(j, sb.charAt(j+1));
					sb.setCharAt(j+1, temp);
					j++;
				}
			}
		}
		
		System.out.println(sb);
		
	}
}
