class Programers_징검다리건너기 {

	public int solution(int[] stones, int k) {
       
        int max = 0;
        int min = 2000000000;
        for(int i=0;i<stones.length;i++) {
        	if(min>stones[i]) {
        		min = stones[i];
        	}
        	if(max<stones[i]) {
        		max = stones[i];
        	}
        }
        
        return k==max?k-1:bSearch(stones,max,min,k);
    }

	static boolean chk(int[] stones,long n,int k) {
		int count = 0;
		for(int i=0;i<stones.length;i++) {
			if(stones[i]<=n) {
				count++;
			}else {
				count = 0;
			}
			
			if(count >=k) return true;
		}
		return false;
	}
	static int bSearch(int[] stones,int max,int min,int k) {
		int e = max;
		int  f = min;
		int m;
		while(f<=e) {
			m = (e+f)/2;
			if(chk(stones, m, k)) {
				e=m-1;
			}else {
				f=m+1;
			}
			
		}
		return f;
	}

}
