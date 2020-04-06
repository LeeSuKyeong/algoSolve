class Programers_다음큰숫자 {

	public int solution(int n) {
		int answer =0;
		
		int cnt = 0;
		for(int i=n;i>0;i=i>>1) {
			cnt += (i&1);
		}
		
		n++;
		while(n<=1000000) {
			int cnt1 = 0;
			for(int i=n;i>0;i=i>>1) {
				cnt1 += (i&1);
			}
			
			if(cnt == cnt1) {				
				break;
			}
			
			n++;
		}
		return n;
	}

}
