import java.util.HashSet;
import java.util.Set;

class Programers_영어끝말잇기 {

	public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        int turn=0;
        Set<String> set = new HashSet();
        boolean flag = false;
        char pre = words[0].charAt(0);
        while(!flag && turn*n <words.length){
            turn++;
            for(int i=0;i<n && i+n*(turn-1)<words.length;i++){
                String now = words[i+n*(turn-1)];
                if(pre!=now.charAt(0) || set.contains(now)){
                    answer[0] = i+1;
                    answer[1] = turn;
                    flag = true;
                    break;
                }
                pre=now.charAt(now.length()-1);
                set.add(now);
            }
            
        }

        return answer;
    }

}
