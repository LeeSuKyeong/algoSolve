import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1965_bs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int size = 0;
		for(int i=0;i<N;i++) {
			int n = Integer.parseInt(st.nextToken());
			if(size == 0) {
				arr[0]=n;
				size++;
			}else if(arr[size-1]<n){
				arr[size++] = n;
			}else {
				search(arr,size,n);
			}
		}
		
		System.out.println(size);
	}
	
	static void search(int[] arr, int size, int n) {
		
		int f = 0;
		int e = size-1;
		while(f<=e) {
			
			int mid = (f+e)/2;
			
			if(arr[mid]<n) {
				f= mid+1;
			}else if(arr[mid]==n){
				return;
			}else {
				e= mid-1;
			}
		}
		arr[f] = n;
	}
}
