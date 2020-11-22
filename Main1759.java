import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1759 {
	static int L,C;
	static char[] arr ;
	static boolean[] visit;
	static LinkedList<String> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr= new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		visit = new boolean[C];
		char[] perm = new char[L];
		list = new LinkedList<>();
		dfs(0,perm);
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	static boolean chk(char[] perm) {
		boolean flag = false;
		int cnt1=0,cnt2=0;

		for(int i=0;i<perm.length;i++) {
			
			if(perm[i]=='a' || perm[i]=='i' || perm[i]=='o' ||perm[i]=='u' || perm[i]=='e') {
				cnt1++;
			}else cnt2++;
		}
		
		if(cnt1>=1 && cnt2>=2) {
			flag = true;
		}
		
		return flag;
	}
	static void dfs(int cnt,char[] perm) {
		
		if(cnt>=L) {
			if(chk(perm)) {
				StringBuilder sb = new StringBuilder();
				for(int i=0;i<perm.length;i++) {
					sb.append(perm[i]);
				}
				list.add(sb.toString());
			}
			return;
		}
		
		for(int  i=0;i<C;i++) {
			if(!visit[i]) {
				
				if(cnt!=0 && (arr[i]-perm[cnt-1]<0)) {
					continue;
				}
				
				visit[i] = true;
				perm[cnt] = arr[i];
				dfs(cnt+1,perm);
				perm[cnt] = '\u0000';
				visit[i] = false;
			}
		}
		
		
	}
}
