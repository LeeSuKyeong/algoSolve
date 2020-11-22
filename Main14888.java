import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numArr= new int[N];
		for(int i=0;i<N;i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] operCnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			operCnt[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(numArr[0],0,numArr,operCnt,N);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static int max = -1_000_000_000;
	static int min = 1_000_000_000;
	static void dfs(int num,int idx,int[] numArr, int[] operCnt,int N) {
		
		if(idx==N-1) {
			max = max>num?max:num;
			min = min<num?min:num;
			return;
		}
		
		for(int i=0;i<4;i++) {
			if(operCnt[i]>0) {
				operCnt[i]--;
				switch(i) {
				case 0:
					dfs(num+numArr[idx+1],idx+1,numArr,operCnt,N);
					break;
				case 1:
					dfs(num-numArr[idx+1],idx+1,numArr,operCnt,N);
					break;
				case 2:
					dfs(num*numArr[idx+1],idx+1,numArr,operCnt,N);
					break;
				case 3:
					dfs(num/numArr[idx+1],idx+1,numArr,operCnt,N);
					break;
				}
				operCnt[i]++;
			}
		}
		
	}

}
