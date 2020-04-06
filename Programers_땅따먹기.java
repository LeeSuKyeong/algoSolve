class Programers_땅따먹기 {

	int solution(int[][] land) {
        int answer = 0;

        for(int i=1;i<land.length;i++) {
        	for(int j=0;j<land[i].length;j++) {
        		int max = 0;
        		for(int k=0;k<land[i-1].length;k++) {
        			if(j==k) continue;
        			max = max<land[i-1][k]? land[i-1][k]:max;
        		}
        		
        		land[i][j] += max;
        	}
        }
        
        int N = land.length;
        for(int i=0;i<land[N-1].length;i++) {
        	answer = answer<land[N-1][i]?land[N-1][i]:answer;
        }
        return answer;
    }

}
