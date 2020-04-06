import java.util.HashMap;

class Programers_호텔방배정 {

	public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
      
    
        for(int i=0;i<room_number.length;i++) {
        	
        	long wantRoom = room_number[i];
        	
        	if(!map.containsKey(wantRoom)) {
        		answer[i] = wantRoom;
        		map.put(wantRoom, wantRoom+1);
        	}else {
        		long tmp = find(wantRoom);
        		answer[i] = tmp;
        		map.put(tmp, tmp+1);
        	}
        	
        }

        return answer;
    }
    static HashMap<Long, Long> map = new HashMap<>();
	static long find(long n) {
		if(!map.containsKey(n)) {
			map.put(n, n+1);
			return n;
		}
		
		long tmp = find(map.get(n));
		map.put(n, tmp);
		return tmp; 
	}

}
