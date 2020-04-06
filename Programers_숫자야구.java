class Programmers {

	public int solution(int[][] baseball) {
		int answer =0;
		
		boolean flag = false;
		int[] num = new int[3],cNum = new int[3];
		for(int i=123;i<=987;i++) {
			//0이 들어가는 숫자인지 체크 , 중복숫자인지체크
			int tmp = i;
			flag = false;
			for(int j=2;j>=0;j--) {
				if(tmp % 10 ==0) {
					flag = true;
					break;
				}
				num[j] = tmp%10;
				for(int k=j+1;k<3;k++) {
					if(num[k] == num[j]) {
						flag = true;
						break;
					}
				}
				tmp/=10;
			}
			
			if(!flag) {//숫자에 0이없으면 야구게임
				boolean chk = false;
				for(int j=0;j<baseball.length;j++) {
					tmp = baseball[j][0];
					int s =0,b=0;
					for(int k=2;k>=0;k--) {
						cNum[k] = tmp%10;
						tmp/=10;
					}
					
					for(int k=0;k<3;k++) {
						for(int w = 0;w<3;w++) {
							if(cNum[k]==num[w]) {
								if(k==w) {
									s++;
								}else {
									b++;
								}
							}
						}
					}
					
					if(!(s==baseball[j][1] && b==baseball[j][2])) {
						chk = true;
						break;
					}
					
				}
				if(!chk) {
					answer++;
				}
			}
			
		}
		
		return answer;
	}

}
