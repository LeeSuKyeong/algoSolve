import java.io.IOException;
import java.util.Scanner;

public class Programers_문자열압축 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc =new Scanner(System.in);
		System.out.println(solution(sc.nextLine()));
	}
	
	public static int solution(String s) {
		int answer=s.length();
		
	
		for(int i=1;i<=s.length()/2;i++) {//자를크기
			String o =s.substring(0,i); //제일 첫 부분문자열
			int cnt =1;
			int len = 0;
			for(int j=i;j+i<=s.length();j+=i) {//idx
				
				if(o.equals(s.substring(j,j+i))){
					//같으면 다음
					cnt++;
				}else {
					//다르면누적
					len += cnt==1?o.length():o.length()+String.valueOf(cnt).length();
					cnt=1;
					o=s.substring(j,j+i);
				}
				
			}

			//마지막 cnt한거 더하기
			len += cnt==1?o.length():o.length()+String.valueOf(cnt).length();

			if(s.length()%i !=0) {
				len+=s.substring(s.length()-s.length()%i).length();
			}
			answer = answer>len?len:answer;
		}

		return answer;
	}
}
