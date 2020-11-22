import java.util.*;
class Programers_방금그곡 {
  public String solution(String m, String[] musicinfos) {
      LinkedList<Info> arr = new LinkedList<>();
      
      m=m.replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");
      for(int i=0;i<musicinfos.length;i++){
          String[] tmp = musicinfos[i].split(",");
          tmp[3] =tmp[3].replace("C#","c").replace("D#","d").replace("F#","f").replace("G#","g").replace("A#","a");
          int sh = Integer.parseInt(tmp[0].substring(0,2));
          int eh = Integer.parseInt(tmp[1].substring(0,2));
          int sm = Integer.parseInt(tmp[0].substring(3));
          int em = Integer.parseInt(tmp[1].substring(3));
          int time = 60*eh+em - 60*sh-sm; 
          StringBuilder tsb = new StringBuilder();
          for(int j=0;j<time/(tmp[3].length());j++){
              tsb.append(tmp[3]);
          }
          tsb.append(tmp[3].substring(0,time%tmp[3].length()));
          if(tsb.indexOf(m) != -1){        
              arr.add(new Info(tmp[2],i,time));
          }
      }
      
      Collections.sort(arr,new Comparator<Info>(){
          
          public int compare(Info o1, Info o2){
              
              return o1.time==o2.time?o1.idx-o2.idx:o2.time-o1.time;
          }
      });
      
      return arr.size()==0?"(None)":arr.get(0).name;
  }
    
    static class Info{
        int idx;
        int time;
        String name;
        
        public Info(String name, int idx, int time){
            this.name = name;
            this.idx = idx;
            this.time = time;
        }
    }
}