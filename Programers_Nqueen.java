import java.util.Arrays;

class Programers_Nqueen {

	public int solution(int n) {
        
        int[] arr = new int[n];
        Arrays.fill(arr, n);
        dfs(0,arr,n);
        return answer;
    }
	static int answer =0;
	static void dfs(int idx,int[] arr,int n) {
		
		if(idx == n) {
			answer++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!chk(i,arr,idx)) {
				arr[idx] = i;
				dfs(idx+1,arr,n);
				arr[idx] = n;
			}
		}
	}
	
	static boolean chk(int num,int[] arr,int idx) {
		boolean flag = false;

		for(int i=0;i<idx;i++) {
			if(arr[i] ==num) {
				flag = true;
				break;
			}
			
			if(Math.abs(arr[i]-num) == Math.abs(i-idx)) {
				flag = true;
				break;
			}
		}
		
		
		return flag;
	}
	

}
