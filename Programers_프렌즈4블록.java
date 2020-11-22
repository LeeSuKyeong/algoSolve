import java.util.*;
class Programers_프렌즈4블록 {
  public int solution(int m, int n, String[] board) {
      int answer = 0;
      char[][] boards = new char[m][n];
      for(int i=0;i<m;i++) {
    	  boards[i] = board[i].toCharArray();
      }
      Queue<Integer> x = new LinkedList<>();
      Queue<Integer> y = new LinkedList<>();
      boolean flag = false;
      while(!flag){
          flag = true;
          for(int i=0;i<m-1;i++){
              for(int j=0;j<n-1;j++){
            	  if(boards[i][j] =='\u0000') continue;
                  if(boards[i][j] == boards[i+1][j] && boards[i][j] ==boards[i][j+1] && boards[i][j] == boards[i+1][j+1]){
                      for(int k=0;k<2;k++){
                          for(int w=0;w<2;w++){
                              x.offer(i+k);
                              y.offer(j+w);
                          }
                      }
                      flag = false;
                  }       
              }
          }
          while(!x.isEmpty()){
              int nx = x.poll();
              int ny = y.poll();
              if(boards[nx][ny] !='\u0000'){
                  boards[nx][ny] = '\u0000';
                  answer++;
              }
          }
    
          for(int i=0;i<n;i++){
            for(int j=m-1;j>=1;j--){
                if(boards[j][i] =='\u0000') {
                	
                	int idx = j;
                	for(int k=idx-1;k>=0;k--) {
                		if(boards[k][i] !='\u0000') {
                			boards[idx++][i]= boards[k][i];
                			boards[k][i] ='\u0000';
                			break;
                		}
                	}
                }

              }
          }
      }
      
      return answer;
  }
}