import java.util.ArrayList;
import java.util.Collections;

class Programers_뉴스클러스터링 {

	public int solution(String str1, String str2) {
	      int answer = 0;
	      ArrayList<String> arr1 = new ArrayList<>();
	      ArrayList<String> arr2 = new ArrayList<>();
	      StringBuilder sb = new StringBuilder();
	      for(int i=0;i<str1.length();i++){
	          int cnt =0;
	          char c =Character.toUpperCase(str1.charAt(i));
	          if(c>='A'&& c<='Z'){
	              sb.append(c);
	          }else{
	              sb = new StringBuilder();
	          }
	          
	          if(sb.length()==2){
	              arr1.add(sb.toString());
	              sb.deleteCharAt(0);
	          }
	      }
	      sb = new StringBuilder();
	      for(int i=0;i<str2.length();i++){
	          int cnt =0;
	          char c =Character.toUpperCase(str2.charAt(i));
	          if(c>='A'&& c<='Z'){
	              sb.append(c);
	          }else{
	              sb = new StringBuilder();
	          }
	          
	          if(sb.length()==2){
	              arr2.add(sb.toString());
	              sb.deleteCharAt(0);
	          }
	      }
	      Collections.sort(arr1);
	      Collections.sort(arr2);
	      
	      int A=0,B=0;

	      while(arr1.size()!=0 && arr2.size()!=0){
	          if(arr1.get(0).compareTo(arr2.get(0))==0){
	              arr1.remove(0);
	              arr2.remove(0);
	              A++;
	              B++;
	          }else if(arr1.get(0).compareTo(arr2.get(0))<0){
	              arr1.remove(0);
	              B++;
	          }else{
	              arr2.remove(0);
	              B++;
	          }
	      }
	      B+=arr1.size()+arr2.size();
	      answer = (A==0&&B==0)?65536:(65536 * A)/B;
	      return answer;
	  }


}
