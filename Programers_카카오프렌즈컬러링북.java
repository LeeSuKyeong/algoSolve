import java.util.LinkedList;
import java.util.Queue;

class Programers_카카오프렌즈컬러링북 {

	public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      boolean[][] visit = new boolean[m][n];
	      for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            if(picture[i][j] != 0 && !visit[i][j]){
	                numberOfArea++;
	                int tmp = bfs(i,j,m,n,visit,picture);
	                maxSizeOfOneArea=maxSizeOfOneArea<tmp?tmp:maxSizeOfOneArea;
	            }
	        }
	      }
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	  }
	    static int[] dx = {-1,0,1,0};
	    static int[] dy = {0,-1,0,1};
	    
	    static int bfs(int x,int y,int m,int n,boolean[][] visit,int[][] picture){
	        int cnt =1;
	        Queue<Pos> q= new LinkedList<>();
	        q.offer(new Pos(x,y));
	        visit[x][y] = true;
	        
	        while(!q.isEmpty()){
	            Pos p = q.poll();
	            
	            for(int i=0;i<4;i++){
	                int px = p.x+dx[i];
	                int py = p.y+dy[i];
	                
	                if(px>=0&& py>=0&& px<m&& py<n && !visit[px][py] && picture[x][y] == picture[px][py]){
	                    q.offer(new Pos(px,py));
	                    visit[px][py] = true;
	                    cnt++;
	                }
	            }       
	        }
	        
	        return cnt;
	    }
	    static class Pos{
	        int x, y;
	        
	        public Pos(int x,int y){
	            this.x = x;
	            this.y = y;
	        }
	    }
}
