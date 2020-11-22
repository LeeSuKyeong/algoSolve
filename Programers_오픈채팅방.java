import java.util.ArrayList;
import java.util.HashMap;

class Programers_오픈채팅방 {

	public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String,String> hash = new HashMap<>();
        ArrayList<String> message =new ArrayList<>();
        ArrayList<Integer> status = new ArrayList<>();
        for(String s :record){
            String[] tmp = s.split(" ");
            
            if("Enter".equals(tmp[0])){
                hash.put(tmp[1],tmp[2]);
                message.add(tmp[1]);
                status.add(0);
            }else if("Leave".equals(tmp[0])){
                message.add(tmp[1]);
                status.add(1);
            }else{
                hash.put(tmp[1],tmp[2]);
            }
        }
        answer=new String[message.size()];
        for(int i=0;i<message.size();i++){
            answer[i] = hash.get(message.get(i)) + (status.get(i)==0?"님이 들어왔습니다.":"님이 나갔습니다.");
        }
 
        return answer;
    }


}
