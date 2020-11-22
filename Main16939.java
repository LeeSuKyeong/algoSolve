import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main16939 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] oarr = new int[25];
		for(int i=1;i<25;i++) {
			oarr[i] = Integer.parseInt(st.nextToken());
		}
		int[] arr = new int[25];
		boolean flag = false;
		Label: for(int i=1;i<=6;i++) {
			for(int j=0;j<2;j++) {
				init(arr,oarr);

				rotate(arr,i,j);

				if(chk(arr)) {
					flag = true;
					break Label;
				}
			}
		}
		System.out.println(flag?1:0);
	}
	
	static boolean chk(int[] arr) {
		boolean flag = true;
		
		for(int i=1;i<=21;i+=4) {
			int c = arr[i];
			int cnt = 1;
			for(int j=1;j<4;j++) {
				if(c == arr[i+j]) cnt++;
			}
			
			if(cnt !=4) {
				flag = false;
				break;
			}
		}

		return flag;
	}
	static void init(int[] arr,int[] oarr) {
		for(int i=0;i<oarr.length;i++) {
			arr[i] = oarr[i];
		}
	}

	static void rotate(int[] arr,int plane,int d) {
		if(d == 1) {
			//left rotate
			for(int i=0;i<3;i++) {				
				rotate(arr,plane,0);
			}
		}else {
			//right rotate
			
			switch(plane) {
			case 1:
				int tmp1 = arr[1];
				arr[1] = arr[3];
				arr[3] = arr[4];
				arr[4] = arr[2];
				arr[2] = tmp1;
				
				int tmp22 = arr[22];
				int tmp21 = arr[21];
				arr[22] = arr[14];
				arr[21] = arr[13];
				
				arr[13] = arr[5];
				arr[14] = arr[6];
				
				arr[5] = arr[17];
				arr[6] = arr[18];
				
				arr[18] = tmp22;
				arr[17] = tmp21;
				
				break;
			case 2:
				int tmp5 = arr[5];
				arr[5] = arr[7];
				arr[7] = arr[8];
				arr[8]=arr[6];
				arr[6] = tmp5;
				
				int tmp3 = arr[3];
				int tmp4 = arr[4];
				arr[3] = arr[16];
				arr[4] = arr[14];
				
				arr[14] = arr[9];
				arr[16] = arr[10];
				
				arr[9] = arr[19];
				arr[10] = arr[17];
				
				arr[17] = tmp3;
				arr[19] = tmp4;
				break;
			case 3:
				int tmp9 = arr[9];
				arr[9] = arr[11];
				arr[11] = arr[12];
				arr[12]=arr[10];
				arr[10] = tmp9;
				
				int tmp7 = arr[7];
				int tmp8 = arr[8];
				arr[8] = arr[16];
				arr[7] = arr[15];
				
				arr[15] = arr[23];
				arr[16] = arr[24];
				
				arr[23] = arr[19];
				arr[24] = arr[20];
				
				arr[20] = tmp8;
				arr[19] = tmp7;
				break;
			case 4:
				int tmp13 = arr[13];
				arr[13] = arr[15];
				arr[15] = arr[16];
				arr[16]=arr[14];
				arr[14] = tmp13;
				
				tmp3 = arr[3];
				tmp1 = arr[1];
				arr[3] = arr[22];
				arr[1] = arr[24];
				
				arr[22] = arr[11];
				arr[24] = arr[9];
				
				arr[11] = arr[7];
				arr[9] = arr[5];
				
				arr[7] = tmp3;
				arr[5] = tmp1;
				break;
			case 5:
				int tmp17 = arr[17];
				arr[17] = arr[19];
				arr[19] = arr[20];
				arr[20]=arr[18];
				arr[18] = tmp17;
				
				int tmp2 = arr[2];
				tmp4 = arr[4];
				arr[4] = arr[8];
				arr[2] = arr[6];
				
				arr[8] = arr[12];
				arr[6] = arr[10];
				
				arr[12] = arr[21];
				arr[10] = arr[23];
				
				arr[23] = tmp2;
				arr[21] = tmp4;
				break;
			case 6:
				tmp21 = arr[21];
				arr[21] = arr[23];
				arr[23] = arr[24];
				arr[24]=arr[22];
				arr[22] = tmp21;
				
				tmp2 = arr[2];
				tmp1 = arr[1];
				arr[2] = arr[20];
				arr[1] = arr[18];
				
				arr[18] = arr[12];
				arr[20] = arr[11];
				
				arr[12] = arr[15];
				arr[11] = arr[13];
				
				arr[15] = tmp1;
				arr[13] = tmp2;
				break;
			}
			
		}
	}
}
