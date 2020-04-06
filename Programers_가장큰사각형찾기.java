class Programers_가장큰사각형찾기 {

	 public int solution(int [][]board){
	        int answer = 0;
	        if(board.length<=2 || board[0].length<=2){
	            label : for(int i=0;i<board.length;i++){
	                for(int j=0;j<board[0].length;j++){
	                    
	                    if(board[i][j]==1){
	                        answer = 1;
	                        break label;
	                    }
	                  
	                }
	            }
	        }
	    
	        for(int i=1;i<board.length;i++){

	            for(int j=1;j<board[i].length;j++){
	                if(board[i][j] !=0){
	                    board[i][j] = 1+ Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1]);
	                    answer = answer<board[i][j]? board[i][j]:answer;
	                   
	                }
	                
	            }
	        }
	        
	        return answer*answer;
	    }
}
