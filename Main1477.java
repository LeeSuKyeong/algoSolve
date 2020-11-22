import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1477 {
/*
 * 한구간안에 여러개의 기둥 세우기 가능 
 * mid = 구간 사이의 새로운 휴게소들의 거리
 * dist에 세울수 있는 만큼 세우고 m개인지 확인
 * */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+2];
		arr[0] = 0;
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		arr[N+1] = L;
		Arrays.sort(arr);
		System.out.println(bs(arr,M,L));
	}
	
	static int bs(int[] arr,int M,int L) {
		int f = 1;
		int e = L-1;
		int mid,cnt;
		int len = arr.length;
		
		while(f<=e) {
			mid=(f+e)/2;
			cnt=0;
			for(int i=len-1;i>0;i--) {
				int tmp = arr[i]- arr[i-1];
				if(tmp>mid) {
					cnt+= tmp/mid;
					if(tmp%mid==0) {
						cnt--;
					}
				}
				
				if(cnt > M) {
					break;
				}
			}
			
			if(cnt<=M) {
				e=mid-1;
			}else{
				f = mid+1;
			}
			
		}
		return f;
	}
}
