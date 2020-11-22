import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main3954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sm = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int si = Integer.parseInt(st.nextToken());
			
			char[] program = br.readLine().toCharArray();
			String input = br.readLine();
			
			//[]쌍 idx hash 만들기
			HashMap<Integer, Integer> pair = new HashMap<>();
			Stack<Integer> stack = new Stack<>();
			for(int i=0;i<program.length;i++) {
				if(program[i] =='[') {
					stack.add(i);
				}else if(program[i] ==']') {
					int tmp = stack.pop();
					pair.put(tmp, i);
					pair.put(i, tmp);
				}
			}
			
			Brainf b = new Brainf(sm,input);
			
			int idx =0;
			int loopIdx = -1;
			for(int ex =0;ex<50000000;ex++) {
				
				if(idx==program.length) {
					break;
				}
				
				switch(program[idx]) {
				case '-':
					b.arr[b.pointer]=b.arr[b.pointer] ==0?255:b.arr[b.pointer]-1;
					break;
				case '+':
					b.arr[b.pointer]=b.arr[b.pointer] ==255?0:b.arr[b.pointer]+1;
					break;
				case '<':
					b.pointer=b.pointer==0?sm-1:b.pointer-1;
					break;
				case '>':
					b.pointer=b.pointer==sm-1?0:b.pointer+1;
					break;
				case '[':
					if(b.arr[b.pointer]==0) {
						idx =pair.get(idx)-1;
					}
					break;
				case ']':
					if(b.arr[b.pointer] !=0) {
						loopIdx = loopIdx<idx?idx:loopIdx;
						idx = pair.get(idx)-1;
					}
					break;
				case '.':
					//print
					break;
				case ',':
					if(b.inputPointer >= si) {
						b.arr[b.pointer] = 255;
					}else {						
						char c = b.input.charAt(b.inputPointer++);
						b.arr[b.pointer] = (int)c;
					}
					
					break;
				}
				
				idx++;
			}
			
			if(idx == program.length) {
				sb.append("Terminates").append('\n');
			}else {
				sb.append("Loops ").append(pair.get(loopIdx)).append(" ").append(loopIdx).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static class Brainf{
		int pointer =0,inputPointer = 0;
		int[] arr;
		String input;
		
		public Brainf(int sm,String input) {
			super();
			this.arr = new int[sm];
			this.input = input;
		}
		
	}
}
