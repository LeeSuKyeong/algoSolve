import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1062 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String[] words = new String[N];
		for(int i=0;i<N;i++) {
			words[i] = br.readLine();
		}
		
		if(K<5) {
			System.out.println(0);
		}else {
			
			boolean[] alpha = new boolean[26];
			alpha['a'-'a'] = true;
			alpha['n'-'a'] = true;
			alpha['t'-'a'] = true;
			alpha['i'-'a'] = true;
			alpha['c'-'a'] = true;
	
			boolean[] tmp = new boolean[26];
			tmp['a'-'a'] = true;
			tmp['n'-'a'] = true;
			tmp['t'-'a'] = true;
			tmp['i'-'a'] = true;
			tmp['c'-'a'] = true;
			
			ArrayList<Character> list =new ArrayList<>();
			for(int i=0;i<N;i++) {
				for(int j=4;j<words[i].length()-4;j++) {					
					char c = words[i].charAt(j);
					if(!tmp[c-'a']) {				
						tmp[c-'a']=true;
						list.add(c);
					}
				}
			}
			
			if(list.size()<=K-5) {//가르칠 알파벳수가 가르칠수있는 수보다 적으면
				System.out.println(N);
			}else {
				teach(words,alpha,list,0,K-5);
				System.out.println(max);
			}
		}
	}
	
	static int max = 0;
	static int read(boolean[] alpha,ArrayList<Character> list,String[] words) {
		int cnt =0;
		for(String word:words) {
			
			cnt++;
			for(int i=4;i<word.length()-4;i++) {
				if(!alpha[word.charAt(i)-'a']) {
					cnt--;
					break;
				}
			}
			
		}
		
		return cnt;
	}
	
	static void teach(String[] words,boolean[] alpha,ArrayList<Character> list,int idx,int cnt) {
		if(cnt==0) {
			int tmp = read(alpha,list,words);
			
			max = tmp<max?max:tmp;
		}
		
		for(int i=idx;i<list.size();i++) {
			char c= list.get(i);
			if(!alpha[c-'a']) {
				alpha[c-'a']=true;
				teach(words,alpha,list,i,cnt-1);
				alpha[c-'a']=false;
			}
		}
	}
}
