import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution1223 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			int len = Integer.parseInt(br.readLine());
			
			char[] s = br.readLine().toCharArray();
			int num =0;
			
			//곱셈 후위
			for(int i=0;i<s.length;i++) {
				if(s[i]=='*') {
					s[i]=s[i+1];
					s[i+1]='*';
					i++;
				}
			}
			//덧셈 후위
			for(int i=0;i<s.length;i++) {
				if(s[i]=='+') {
					
					for(int j=i+1;j<s.length;j++) {
						if(s[j]!='+') {
							s[j-1]=s[j];
							s[j]='+';
						}else {
							i=j-1;
							break;
						}
					}

				}
			}
			//후위연산
			Stack<Integer> stack = new Stack<>();
			for(int i=0;i<s.length;i++) {
				if(s[i]>='0' && s[i]<='9') {
					stack.push(s[i]-'0');
				}else if(s[i]=='*') {
					stack.push(stack.pop()*stack.pop());
				}else {
					stack.push(stack.pop()+stack.pop());
				}
			}
			num = stack.pop();
		
			System.out.println("#" + tc + " " +num);
		}
		
	}

}
