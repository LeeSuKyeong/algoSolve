import java.util.HashSet;
import java.util.Set;

class Programers_네트워크 {

	public int solution(int n, int[][] computers) {
        
        int[] parent = new int[n];
        init(parent);
        for(int i=0;i<computers.length;i++) {
        	for(int j=0;j<i;j++) {
        		if(computers[i][j] == 1) {
        			union(i,j,parent);
        		}
        	}
        }
        for(int i=0;i<parent.length;i++) {
        	parent[i] = find(i,parent);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<parent.length;i++) {
        	set.add(parent[i]);
        }
        return set.size();
    }
	static int find(int x,int[] parent) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x]=find(parent[x],parent);
	}
	static void init(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i] = i;
		}
	}
	static void union(int x, int y,int[] parent) {
		int py = find(y,parent);
		int px = find(x,parent);
		if(px != py) {
			parent[px] = py;
		}
	}

}
