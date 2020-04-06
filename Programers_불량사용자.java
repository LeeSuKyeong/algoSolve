import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Programers_불량사용자 {
	static Set<Integer> set;
	public int solution(String[] user_id, String[] banned_id) {
		set = new HashSet<>();
		boolean[] visit = new boolean[user_id.length];
        dfs(0,user_id,banned_id,visit);
        return cnt;
    }
	
	static int cnt = 0;
	static boolean check(int bannedIdx,int userIdx,String[] user_id, String[] banned_id) {

		if(user_id[userIdx].length()!= banned_id[bannedIdx].length()) return false;
		
		for(int i=0;i<banned_id[bannedIdx].length();i++) {
			if(banned_id[bannedIdx].charAt(i) =='*') continue;
			if(user_id[userIdx].charAt(i) != banned_id[bannedIdx].charAt(i)){
				return false;
			}
		}
		return true;
	}
	static void dfs(int idx,String[] user_id, String[] banned_id,boolean[] visit) {
		if(banned_id.length==idx) {
			
			int tmp = 0;
			for(int i=0;i<user_id.length;i++) {
				if(visit[i]) {
					tmp|=(1<<i);
				}
			}
			if(!set.contains(tmp)) {
				set.add(tmp);
				cnt++;
			}
			return;
		}
		
		for(int i=0;i<user_id.length;i++) {
			if(!visit[i] && check(idx,i,user_id,banned_id)) {
				visit[i] = true;
				dfs(idx+1,user_id,banned_id,visit);
				visit[i] = false;
			}
		}
	}
	
}
