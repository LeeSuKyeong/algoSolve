import java.util.Arrays;

class Programers_hindex {

	 public int solution(int[] citations) {
		 int len = citations.length;
	       int answer = 0;
	        Arrays.sort(citations);
	        
	        for(int i=0;i<len;i++) { //len-i =h
	        	if(citations[i]>=len-i) {
	        		answer = len-i;
	        		break;
	        	}
	        }
	        return answer;
	    }
	

}
