import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_form2 {

   static char[][][] arr;
   static boolean[][][] chk;

   static Queue<position> q;

   static int[] dx = { 1, -1, 0, 0, 0, 0 };
   static int[] dy = { 0, 0, 1, -1, 0, 0 };
   static int[] dz = { 0, 0, 0, 0, 1, -1 };

   static position start = null;
   static position end = null;

   static int L;
   static int R;
   static int C;

   static int count;

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);

      while (true) {
         L = sc.nextInt();
         R = sc.nextInt();
         C = sc.nextInt();
         count = 0;
         if (L==0 && R==0 && C==0 ) { // L==0 && R==0 && C==0 
            break;
         }

         arr = new char[L][R][C];
         chk = new boolean[L][R][C];
         q = new LinkedList<>();

         for (int i = 0; i < L; i++) {
             for (int j = 0; j < R; j++) {
                String s = sc.next();
                for (int k = 0; k < C; k++) {
                   arr[i][j][k] = s.charAt(k);
                   if (arr[i][j][k] == 'S') {
                      start = new position(j, k, i, count);
                   }
                   if (arr[i][j][k] == 'E') {
                      end = new position(j, k, i, count);
                   }
                } // for c
             } // for r
             sc.nextLine();
          } // for l

      
        
         bfs();
         if (count == 0) {
            System.out.println("Trapped!");
         } else {
            System.out.println("Escaped in " + count + " minute(s).");
         }

      } // while
   }// main
 
   static void bfs() {
      int nowZ = start.z;
      int nowX = start.x;
      int nowY = start.y;
      q.offer(new position(nowX, nowY, nowZ, count));
      chk[nowZ][nowX][nowY]=true;
      
      while (!q.isEmpty()) {
         position nowPos = q.poll();
         int x = nowPos.x;
         int y = nowPos.y;
         int z = nowPos.z;
         //if 문으로 E인가 확인
         if(arr[z][x][y] == 'E') {
        	 count=nowPos.dist;
        	 break;
         }

         for (int i = 0; i < dx.length; i++) {
            int nX = x + dx[i];
            int nY = y + dy[i];
            int nZ = z + dz[i];
            if (nX < 0 || nY < 0 || nZ < 0 || nX >= R || nY >= C || nZ >= L || chk[nZ][nX][nY] == true) {
               continue;
            }
            if (arr[nZ][nX][nY] == '#') {
               continue;
            }
            chk[nZ][nX][nY] = true;
            q.offer(new position( nX, nY,nZ,nowPos.dist+1));

         }
      } // while
   }// bfs
}

class position {
   int x;
   int y;
   int z;
   int dist;
//position 거리
   public position(int x, int y, int z, int dist) {
      super();
      this.x = x;
      this.y = y;
      this.z = z;
      this.dist = dist;
   }
}// class position