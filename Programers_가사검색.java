import java.util.HashMap;

class Programers_가사검색 {
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		//make
		Trie tRoot = new Trie('\u0000');
		Trie rRoot = new Trie('\u0000');
		for(String word : words) {
			Trie ttmp = tRoot;
			Trie rtmp = rRoot;
			int len = word.length();
			for(int i=0;i<len;i++) {
				
				ttmp = ttmp.putChild(new Trie(word.charAt(i)), len);
				rtmp = rtmp.putChild(new Trie(word.charAt(len-1-i)), len);
			}
		}
		
		//find
		int index =0;
		for(String q :queries) {
			
			if(q.charAt(0) =='?') {
				//rRoot
				Trie rtmp = rRoot;

				int idx = q.length()-1;
				char c;
				boolean flag = false;
				while((c=q.charAt(idx--)) !='?') {
					if(!rtmp.next.containsKey(c)) {
						answer[index] = 0;
						flag = true;
						break;
					}
					if(rtmp.next ==null) {
						answer[index]= 0;
						flag = true;
						break;
					}
					rtmp = rtmp.next.get(c);
				}
				if(!flag) {
					answer[index] =rtmp.lenCount.containsKey(q.length())?rtmp.lenCount.get(q.length()):0; 
				}
				
			}else {
				//tRoot
				Trie ttmp = tRoot;

				int idx = 0;
				char c;
				boolean flag = false;
				while((c=q.charAt(idx++)) !='?') {
					if(!ttmp.next.containsKey(c)) {
						answer[index] = 0;
						flag = true;
						break;
					}
					
					if(ttmp.next ==null) {
						answer[index] = 0;
						flag = true;
						break;
					}
					
					ttmp = ttmp.next.get(c);
				}
				if(!flag) {
					answer[index] =ttmp.lenCount.containsKey(q.length())?ttmp.lenCount.get(q.length()):0; 
				}
			}
			
			index++;
		}
		
		return answer;

	}

	static class Trie{
        char c;
        HashMap<Character, Trie> next = new HashMap<>();
        HashMap<Integer, Integer> lenCount = new HashMap<>();
	
        public Trie(char c) {
			super();
			this.c = c;
		}
        
        public Trie putChild(Trie t, int len) {
        	if(!next.containsKey(t.c)) {
        		next.put(t.c, t);
        	}
        	
        	if(!lenCount.containsKey(len)) {
        		lenCount.put(len, 1);
        	}else {
        		lenCount.put(len,lenCount.get(len)+1);
        	}
        	
        	return next.get(t.c);
        	
        }
		
	}

}
