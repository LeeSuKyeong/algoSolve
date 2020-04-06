class Programers_숫자의표현 {

	public int solution(int n) {
		int answer = 1;

		for(int i=1;i<=n/2;i++) {
			int sum =0;
			for(int j=i;sum<n;j++) {
				if(n==j+sum) {
					answer++;
					break;
				}
				
				sum+=j;
			}
		}
		return answer;
	}

}
