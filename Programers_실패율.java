import java.util.Collections;
import java.util.LinkedList;

class Programers_실패율 {

	public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int len = stages.length;
        
        int[] count = new int[N+1+1];
        for(int i=0;i<len;i++) {
        	count[stages[i]]++;
        }

        int[] countT = new int[N+1+1];
        countT[N+1] = count[N+1];
        for(int i=N;i>0;i--) {
        	countT[i] = count[i] +countT[i+1];
        }
        
        LinkedList<Info> arr =new LinkedList<>();
        
        for(int i=1;i<N+1;i++) {
        	if(countT[i] ==0) {
        		arr.add(new Info(i,0));
        	}else {
        		arr.add(new Info(i,count[i]/(double)countT[i]));
        	}
        }
        
        Collections.sort(arr);
        
        for(int i=0;i<N;i++) {
        	answer[i] = arr.get(i).idx;
        }
        
        return answer;
    }
	
	static class Info implements Comparable<Info>{
		int idx;
		double fail;
		
		public Info(int idx,double fail){
			this.idx = idx;
			this.fail = fail;
		}

		public int compareTo(Info o) {
			if(o.fail == this.fail) {
				return this.idx - o.idx;
			}else if(this.fail > o.fail){
				return -1;
			}else {
				return 1;
			}
		}
	}

}
