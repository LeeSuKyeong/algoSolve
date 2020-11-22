import java.util.Collections;
import java.util.PriorityQueue;

class Programers_라면공장 {

	public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int i=0;i<k;i++){
            if(idx<dates.length && dates[idx] == i){
                pq.offer(supplies[idx]);
                idx++;
            }
            
            if(stock==0){
                stock+=pq.poll();
                answer++;
            }
            stock--;
        }
        return answer;
    }


}
