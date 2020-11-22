class Programers_소수만들기 {

public int solution(int[] nums) {
        
        prime = new boolean[3000+1];
        prime[0] = true;
        prime[1] = true;
        for(int i=2;i<=Math.sqrt(3000);i++){
            if(!prime[i]){
               for(int j=i*2;j<=3000;j+=i){
                   prime[j] = true;
               } 
            }
        }
        
        boolean[] visit = new boolean[nums.length];
        dfs(0,0,nums,visit);
        

        return result;
    }
    static int result = 0;
    static boolean[] prime;
    static void dfs(int idx,int cnt,int[] nums,boolean[] visit){
        if(cnt==3){
            int num = 0;
            for(int i=0;i<visit.length;i++){
                if(visit[i]){
                    num+=nums[i];
                }
            }
            if(!prime[num]){
                result++;
            }
            return;
        }
        
        for(int i=idx;i<nums.length;i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(i,cnt+1,nums,visit);
                visit[i] = false;
            }
        }
    }


}
