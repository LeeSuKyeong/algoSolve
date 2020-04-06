import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1107 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		boolean[] broken = new boolean[10];
		Arrays.fill(broken, true);
		if(m!=0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<m;i++) {
				broken[Integer.parseInt(st.nextToken())]  = false;
			}
		}
		
		//1. +/-만으로 가는경우
		int cnt =Math.abs(n-100);
		//2. 숫자버튼만으로 이동가능한 경우
		int tmp = n;
		int len = 0;
		if(tmp==0) {
			if(broken[0]) {
				len=1;
			}else {
				len=500000;
			}
		}
		while(tmp>0) {
			if(!broken[tmp%10]) {
				len = 500000;
				break;
			}
			tmp/=10;
			len++;
		}
		cnt = cnt<len?cnt:len;
		//3. 1+2
		int tlen;
		for(int i=0;i<=1000000;i++) {
			len = 0;
			tmp = i;
			if(tmp==0) {
				if(!broken[0]) {
					len = 500000;
				
				}else {
				len++;
				}
			}
			while(tmp>0) {
				if(!broken[tmp%10]) {
					len = 500000;
					break;
				}
				len++;
				tmp/=10;
			}
			
			tlen = len+Math.abs(n-i);
			cnt = cnt<tlen?cnt:tlen;
		}

		System.out.println(cnt);
	
	}

}
