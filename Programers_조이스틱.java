import java.util.Arrays;

class Programers_조이스틱 {

	 public int solution(String name) {
	        int answer = 0;
	        
	        char[] arr = new char[name.length()];
	        Arrays.fill(arr,'A');
	        int idx=0;
	        int len = name.length();
	        while(!name.equals(String.valueOf(arr))){
	            
	            
	            int left=idx,right=idx;
	            //왼쪽 탐색
	            for(int i=0;i<len;i++){
	                if(name.charAt((idx-i+len)%len)!='A' && name.charAt((idx-i+len)%len)!=arr[(idx-i+len)%len]){
	                    left = i;
	                    break;
	                }
	            }
	            //오른쪽 탐색
	            for(int i=0;i<len;i++){
	                if(name.charAt((i+idx)%len)!='A' && name.charAt((i+idx)%len)!=arr[(i+idx)%len]){
	                    right = i;
	                    break;
	                }
	            }
	            if(right<=left){
	                answer += right;
	                idx = (right+idx)%len;
	            }else{
	                answer +=left;
	                idx = (idx-left+len)%len;
	            }
	            
	            if(name.charAt(idx)!='A' && name.charAt(idx)!=arr[idx]){
	                answer+=name.charAt(idx)-'A'<26+'A'-name.charAt(idx)?name.charAt(idx)-'A':26+'A'-name.charAt(idx);
	                arr[idx] = name.charAt(idx);
	            }
	        }
	        return answer;
	    }

}
