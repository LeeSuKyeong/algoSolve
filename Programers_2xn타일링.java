class Programers_2xn타일링 {

	 public int solution(int n) {
	      int mod = 1000000007;
	      int[] arr = new int[n+1];
	      arr[1] = 1;
	      arr[2] = 2;
	      for(int i=3;i<=n;i++){
	          arr[i]= (arr[i-1]%mod + arr[i-2]%mod)%mod;
	      }

	      return arr[n];
	  }


}
