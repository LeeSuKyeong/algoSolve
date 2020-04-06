import java.util.HashMap;

class Programers_스킬트리 {

  public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<skill.length();i++) {
        	map.put(skill.charAt(i), i);
        }
        	
        for(String s : skill_trees) {
        	boolean flag = true;
        	int idx = -1;
        	for(int i=0;i<s.length();i++) {
        		if(map.containsKey(s.charAt(i))) {
        			if(map.get(s.charAt(i)) != idx+1) {
        				flag = false;
        				break;
        			}
        			idx = map.get(s.charAt(i));
        		}
        	}
        	
        	if(flag) {
        		answer++;
        	}
        }
        
        
        
        return answer;
    }


}
