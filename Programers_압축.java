import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Programers_압축 {

	public int[] solution(String msg) {
		int[] answer = {};
		ArrayList<Integer> arr = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		
		for (int i = 1; i <= 26; i++) {
			map.put("" + (char) ('A' + i - 1), i);
		}
		int idx = 27;
		
		LinkedList<Character> msgs = new LinkedList<>();
		for(int i=0;i<msg.length();i++) {
			msgs.add(msg.charAt(i));
		}
		while(msgs.size()!=0) {
			
			int e = find(msgs,map);
			StringBuilder sb = new StringBuilder();
			if(0<=e) {
				for(int i=0;i<=e;i++) {
					sb.append(msgs.get(0));
					msgs.remove(0);
				}
				String tmp = sb.toString();
				arr.add(map.get(tmp));
			}
			
			if(msgs.size() >0) {
				sb.append(msgs.get(0));
				map.put(sb.toString(), idx++);
			}
			
		}
		
		answer = new int[arr.size()];
		for (int j = 0; j < arr.size(); j++) {
			answer[j] = arr.get(j);
		}
		return answer;
	}
	
	static int find(LinkedList<Character> msgs,HashMap<String,Integer> map) {
		int e =0;
		StringBuilder sb = new StringBuilder();
		boolean flag =false;
		for(int i=0;i<msgs.size();i++) {
			sb.append(msgs.get(i));
			if(!map.containsKey(sb.toString())) {
				e = i-1;
				flag = true;
				break;
			}
		}
		
		if(!flag) {//문자열의 끝일때
			e= msgs.size()-1;
		}
		return e;
	}
}
