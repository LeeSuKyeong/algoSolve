import java.util.LinkedList;
import java.util.Queue;

class Programers_캐시 {

	 public int solution(int cacheSize, String[] cities) {
	      int answer = 0;
	      
	      Queue<String> q = new LinkedList<>();
	      for(int i=0;i<cities.length;i++){
	          String s = cities[i].toUpperCase();
	          int size = q.size();
	          boolean match = false;
	          for(int j=0;j<size;j++){
	              String tmp  = q.poll();
	              if(s.equals(tmp)){
	                match = true;    
	              }else{
	                  q.offer(tmp);
	              }
	          }
	          
	          if(match){
	              q.offer(s);
	              answer+=1;
	          }else{
	              if(q.size()>=cacheSize){
	                 q.poll();
	              }
	              q.offer(s);
	              answer+=5;
	          }
	          
	          
	      }

	      return answer;
	  }


}
