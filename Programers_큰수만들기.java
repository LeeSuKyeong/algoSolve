class Programers_큰수만들기 {
   public String solution(String number, int k) {

        StringBuilder sb= new StringBuilder();
       int idx = 0;
       for(int i=0;i<number.length()-k;i++) {
    	   char max = '0';
    	   
    	   for(int j=i;j<=i+k;j++) {
    		   if(number.charAt(j)>max) {
        		   max = number.charAt(j);
        		   idx = j;
        	   }    		   
    	   }

           k-= idx-i;
           sb.append(max);
           i=idx;

           if(k==0){
               for(int j=idx+1;j<number.length();j++){
                   sb.append(number.charAt(j));
               }
               break;
           }
       }
        return sb.toString();
    }

}
