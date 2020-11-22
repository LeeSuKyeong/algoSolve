import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main16637 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		if(s.length()==1) {
			System.out.println(s);
		}else {			
			chk = new boolean[s.length()];
			dfs(s,0);
			System.out.println(max);
		}
	}
	
	static int max = Integer.MIN_VALUE;
	static boolean[] chk;

	static void cal(String s) {
	
		Queue<Integer> q = new LinkedList<>();
		Queue<Character> qOper = new LinkedList<>();

		//괄호먼저 계산
		for(int i=0;i<s.length();i++) {
		
			if(chk[i] && i!=s.length()-1) {
				int tmp = 0;
				if(s.charAt(i+1) =='+') {
					tmp = (s.charAt(i)-'0') + (s.charAt(i+2)-'0');
				}else if(s.charAt(i+1) =='-') {
					tmp = (s.charAt(i)-'0') - (s.charAt(i+2)-'0');
				}else {
					tmp = (s.charAt(i)-'0') * (s.charAt(i+2)-'0');
				}
				
				q.add(tmp);
				i+=2;
			}else {
				char c = s.charAt(i);
				if(Character.isDigit(c)) {					
					q.add(c-'0');
				}else {
					qOper.add(c);
				}
			}
		}
		
		int num = q.poll();
		while(!q.isEmpty() && !qOper.isEmpty()) {
			
			char op = qOper.poll();
			if(op =='+') {
				num+=q.poll();
			}else if(op=='-') {
				num -= q.poll();
			}else {
				num *=q.poll();
			}
			
		}
		max = max<num?num:max;
		
	}
	
	static void dfs(String s, int idx) {
		if(idx>=s.length()) {
			//cal
			cal(s);
		}
		
		for(int i=idx;i<s.length();i+=2) {
		
			if(!chk[i]) {
				chk[i] = true;
				dfs(s,i+4);
				chk[i] = false;
			}
		}
	}
}
