import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Programers_파일명정렬 {

	public String[] solution(String[] files) {
	      String[] answer = {};
	      LinkedList<Info> list = new LinkedList<>();
	      for(int i=0;i<files.length;i++){
	          int he =0,ne=files[i].length()-1;
	          for(int j=0;j<files[i].length();j++){
	              if(files[i].charAt(j) >='0' && files[i].charAt(j)<='9'){
	                  he=j-1;
	                  break;
	              }
	          }
	          for(int j=he+1;j<files[i].length();j++){
	        	  if(files[i].charAt(j) <'0' || files[i].charAt(j)>'9'){
	                  ne=j-1;
	                  break;
	              }
	            }
	        list.add(new Info(files[i].substring(0,he+1),files[i].substring(he+1,ne+1),files[i].substring(ne+1)));        
	      }

	      Collections.sort(list,new Comparator<Info>(){
	          
	          public int compare(Info o1, Info o2){
	              String s1 = o1.head.toLowerCase();
	              String s2 = o2.head.toLowerCase();
	              return s1.equals(s2)?Integer.parseInt(o1.num)-Integer.parseInt(o2.num):s1.compareTo(s2);
	          }
	      });
	      
	      answer = new String[list.size()];
	      for(int i=0;i<list.size();i++){
	          StringBuilder sb= new StringBuilder();
	          sb.append(list.get(i).head).append(list.get(i).num).append(list.get(i).tail);
	          answer[i] = sb.toString();
	      }
	      return answer;
	  }
	    
	    static class Info{
	        String head,tail;
	        String num;
	        
	        public Info(String head, String num, String tail){
	            this.head = head;
	            this.num = num;
	            this.tail = tail;
	        }
	        
	    }
	
}
