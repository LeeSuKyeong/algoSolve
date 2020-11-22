class Programers_괄호변환 {

	public String solution(String p) {
        
        return balanceS(p).toString();
    }

	static StringBuilder balanceS(String p) {
		StringBuilder ans = new StringBuilder();
		if(p.equals("")) {
			ans.append("");
			return ans;
		}
		int num = 0;
		int idx = 0;
		for(int i=0;i<p.length();i++) {
			if(p.charAt(i)=='(') {
				num++;
			}else {
				num--;
			}
			
			if(num==0) {
				//균형잡힌 문자열
				idx = i;
				break;
			}
		}
		
		
		StringBuilder u = new StringBuilder();
		for(int i=0;i<=idx;i++) {
			u.append(p.charAt(i));
		}
		if(chk(u)) {
			//올바른 문자열
			ans.append(u.toString());
			ans.append(balanceS(p.substring(idx+1)));
		}else {
			ans.append('(').append(balanceS(p.substring(idx+1))).append(')');
			u.deleteCharAt(0);
			u.deleteCharAt(u.length()-1);
			ans.append(rightS(u));
		}
		return ans;
		
		
	}
	static String rightS(StringBuilder sb) {
		StringBuilder s = new StringBuilder();
		for(int i=0;i<sb.length();i++) {
			s.append(sb.charAt(i)==')'?'(':')');
		}
		return s.toString();
	}
	
	static boolean chk(StringBuilder sb) {
		boolean flag = true;
		int num =0;
		for(int i=0;i<sb.length();i++) {
			if(sb.charAt(i) =='(') {
				num++;
			}else {
				num--;
			}
			
			if(num<0) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}

}
