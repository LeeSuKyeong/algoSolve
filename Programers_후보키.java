import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        int answer = 0;
        int attribute = relation[0].length;
        int tuples = relation.length;
        
        LinkedList<Integer> arr = new LinkedList<>();
        for(int i=1;i<(1<<attribute);i++){
            if(chk(relation,tuples,attribute,i)){
                arr.add(i);
            }
        }
        Collections.sort(arr,new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return Integer.bitCount(o1) - Integer.bitCount(o2);
            }
        });
        
        while(arr.size()!=0){
            int idx = 0;
            int key = arr.get(0);
            arr.remove(idx);

            answer++;
            while(idx<arr.size()){
                int tmp = arr.get(idx);
                if((key & tmp)==key){
                   arr.remove(idx);
                 }else{
                    idx++;
                }
            }
        }

        return answer;
    }

    static boolean chk(String[][] relation,int tuples,int attribute,int choice){
        
        for(int i=0;i<tuples-1;i++){
            for(int j=i+1;j<tuples;j++){
                boolean flag = false;
                for(int k=0;k<attribute;k++){
                    if((choice & (1<<k))!=0){
                        if(!relation[i][k].equals(relation[j][k])){
                            flag = true;
                        }
                    }
                }
                if(!flag){
                    return false;
                }
            }
        }
        return true;
    }
}