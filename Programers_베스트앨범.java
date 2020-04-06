import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Programmers_베스트앨범 {

	public int[] solution(String[] genres, int[] plays) {
		int[] answer,order=new int[genres.length];
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < genres.length; i++) {
			if (map.containsKey(genres[i])) {
				map.put(genres[i], map.get(genres[i]) + plays[i]);
			} else {
				map.put(genres[i], plays[i]);
			}
		}

		ArrayList<String> arr = new ArrayList<>(map.keySet());

		Collections.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return map.get(o2) - map.get(o1);
			}

		});
		
		int idx=0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		for(String s : arr) {
			for(int i=0;i<genres.length;i++) {
				if(s.equals(genres[i])) {					
					pq.offer(new Info(plays[i],i));
				}
				
			}
			
			for(int i=0;i<2;i++) {
				if(pq.isEmpty()) break;
				
				Info tmp = pq.poll();
				order[idx++] = tmp.idx;
			}
			pq.clear();
		}
		
		answer = new int[idx];
		for(int i=0;i<idx;i++){
			answer[i]=order[i];
		}
		return answer;
	}

	static class Info implements Comparable<Info> {
		int play,idx;
		
		public Info(int play, int idx) {
			super();
			this.play = play;
			this.idx = idx;
		}

		@Override
		public int compareTo(Info o) {
			return this.play==o.play?this.idx-o.idx:o.play-this.play;
		}

	}
}
