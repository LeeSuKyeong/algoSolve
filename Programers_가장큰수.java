import java.util.Comparator;
import java.util.PriorityQueue;

class Programers_가장큰수 {

	public String solution(int[] numbers) {
        String answer = "";
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				sb1.append(o1).append(o2);
				sb2.append(o2).append(o1);
				return (-1)*sb1.toString().compareTo(sb2.toString());
			}
		});
        
        for(int i=0;i<numbers.length;i++) {
        	pq.offer(numbers[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
        	if("0".equals(sb.toString()) && pq.peek()==0) {
        		pq.poll();
        	}else {        		
        		sb.append(pq.poll());
        	}
        }
        
        return sb.toString();
    }


}
