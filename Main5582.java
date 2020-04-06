import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main5582 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder str1 = new StringBuilder(br.readLine());
		StringBuilder str2 = new StringBuilder(br.readLine());
		
		int[][] map = new int[str1.length()+1][str2.length()+1];
		int max = 0;
		for(int i=0;i<str1.length();i++) {
			for(int j=0;j<str2.length();j++) {
				if(str1.charAt(i)==str2.charAt(j)) {
					map[i+1][j+1] = map[i][j] +1;
					max= max>map[i+1][j+1]?max:map[i+1][j+1];
				}
			}
		}
		
		System.out.println(max);
	}
	
}
