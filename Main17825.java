import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main17825 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//주사위
		int[] dice = new int[10];
		for(int i=0;i<10;i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		map = new LinkedList<>();
		makeMap();
		
		int[] horse = new int[4];
		
		dfs(0,horse,dice,0);
		System.out.println(max);
	}
	
	static int max = 0;
	static LinkedList<int[]> map;
	static void makeMap() {
		//start
				map.add(new int[] {1,-1,0});
				for(int i=1;i<=20;i++) { //외곽
					map.add(new int[] {i+1,-1,2*i});//ridx,bidx,점수
				}
				//21번 도착
				map.add(new int[] {-1,-1,0});
				
				map.get(5)[1] = 22; //10번
				map.get(10)[1] = 26; //20번
				map.get(15)[1] = 28; //30번
				
				//13~19 -> idx 22~24
				int idx = 23;
				for(int i=13;i<=19;i+=3) {
					map.add(new int[] {idx++,-1,i});
				}
				//val 25인 idx = 25
				map.add(new int[] {31,-1,25});
				
				idx = 27;
				//22,24 ->idx =26 27
				for(int i=22;i<=24;i+=2) {
					map.add(new int[] {idx++,-1,i});
				}
				map.get(27)[0] = 25;
				
				//28~26 -> idx= 28~30
				for(int i=28;i>=26;i--) {
					map.add(new int[] {idx++,-1,i});
				}
				map.get(30)[0] = 25;
				
				//idx 31~32
				for(int i=30;i<40;i+=5) {
					map.add(new int[] {idx++,-1,i});
				}
				map.get(32)[0] = 20;
				
		
	}
	
	static int nextPos(int[] horse, int idx,int move) {
		int pos = horse[idx];
		
		if(pos == 5 || pos == 10 || pos ==15) {
			pos = map.get(pos)[1];
			for(int i=1;i<move;i++) {
				if(map.get(pos)[0] !=-1) {			
					pos=map.get(pos)[0];
				}
			}
		}else {
			for(int i=0;i<move;i++) {
				if(map.get(pos)[0] !=-1) {					
					pos = map.get(pos)[0];
				}
			}	
		}
		
		
		return pos;
	}
	static void dfs(int sum,int[] horse,int[] dice, int idx) {
		if(idx==10) {
			max=max<sum?sum:max;
			return;
		}
		
		for(int i=0;i<4;i++) {
			int pos = horse[i];
			if(pos != 21) {//도착아니고
				int tmp = nextPos(horse,i,dice[idx]);
				boolean flag = false;
				
				for(int j=0;j<4;j++) {
					if(i!=j && tmp!=21 && tmp==horse[j]) {
						//다음이동할값에 말이 있으면 이동 x
						flag = true;
						break;
					}
				}
				
				if(!flag) {
					int val = map.get(tmp)[2];
					horse[i] = tmp;
					dfs(sum+val,horse,dice,idx+1);
					horse[i] = pos;
				}
			}
		}
	}
}
