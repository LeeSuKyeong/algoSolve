import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main5373 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			init(); // 주사위 초기화
			for (int j = 0; j < n; j++) {
				String comm = st.nextToken();
				if (comm.charAt(1) == '+') {
					rotate(comm.charAt(0));
				} else {
					for (int k = 0; k < 3; k++) {
						rotate(comm.charAt(0));
					}
				}
			}

			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					sb.append(dice[1][j][k]);
				}
				sb.append('\n');
			}
		}

		System.out.println(sb.toString());
	}

	static char[][][] dice;

	static void init() {
		char[] c = { 'o', 'w', 'r', 'y', 'g', 'b' }; // 0:뒤 1:위 2:앞 3:아래 4:왼 5:오

		dice = new char[6][3][3];
		for (int k = 0; k < 6; k++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[k][i][j] = c[k];
				}
			}
		}
	}

	static void rotate(char plane) {
		char[] tmp = null;
		char[][] tmpP = new char[3][3];

		switch (plane) {
		case 'L':
			// 면
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmpP[i][j] = dice[4][i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[4][i][j] = tmpP[2-j][i];
				}
			}

			// 주변
			tmp = new char[] { dice[3][0][0], dice[3][1][0], dice[3][2][0] };

			for (int i = 3; i >= 1; i--) {
				for (int j = 0; j < 3; j++) {
					dice[i][j][0] = dice[i - 1][j][0];
				}
			}

			for (int i = 0; i < 3; i++) {
				dice[0][i][0] = tmp[i];
			}

			break;
		case 'R':
			// 면
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmpP[i][j] = dice[5][i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[5][i][j] = tmpP[2-j][i];
				}
			}
			// 주변
			tmp = new char[] { dice[0][0][2], dice[0][1][2], dice[0][2][2] };

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[i][j][2] = dice[i + 1][j][2];
				}
			}

			for (int i = 0; i < 3; i++) {
				dice[3][i][2] = tmp[i];
			}

			break;
		case 'U':
			// 면
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmpP[i][j] = dice[1][i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[1][i][j] = tmpP[2-j][i];
				}
			}
		
			// 주변
			tmp = new char[] { dice[0][2][0], dice[0][2][1], dice[0][2][2] };

			dice[0][2][0] = dice[4][2][2];
			dice[0][2][1] = dice[4][1][2];
			dice[0][2][2] = dice[4][0][2];

			dice[4][2][2] = dice[2][0][2];
			dice[4][1][2] = dice[2][0][1];
			dice[4][0][2] = dice[2][0][0];

			dice[2][0][0] = dice[5][2][0];
			dice[2][0][1] = dice[5][1][0];
			dice[2][0][2] = dice[5][0][0];

			dice[5][0][0] = tmp[0];
			dice[5][1][0] = tmp[1];
			dice[5][2][0] = tmp[2];
			
			break;
		case 'D': // 뒷면은 면회전이 반대이므로 3번반복
			// 면
			
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						tmpP[i][j] = dice[3][i][j];
					}
				}

				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						dice[3][i][j] = tmpP[2-j][i];
					}
				}
				
				//주변

				tmp = new char[] { dice[0][0][0], dice[0][0][1], dice[0][0][2] };
				dice[0][0][0] = dice[5][0][2];
				dice[0][0][1] = dice[5][1][2];
				dice[0][0][2] = dice[5][2][2];
				
				dice[5][0][2] =dice[2][2][2];
				dice[5][1][2] =dice[2][2][1];
				dice[5][2][2] =dice[2][2][0];
				
				dice[2][2][2] =dice[4][2][0];
				dice[2][2][1] =dice[4][1][0];
				dice[2][2][0] =dice[4][0][0];
				
				dice[4][2][0] = tmp[0];
				dice[4][1][0] = tmp[1];
				dice[4][0][0] = tmp[2];
			
			break;
		case 'F':
			// 면
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmpP[i][j] = dice[2][i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[2][i][j] = tmpP[2-j][i];
				}
			}
			
			//주변
			tmp = new char[] { dice[3][0][2], dice[3][0][1], dice[3][0][0] };
			
			dice[3][0][2] = dice[5][2][0];
			dice[3][0][1] = dice[5][2][1];
			dice[3][0][0] = dice[5][2][2];
			
			dice[5][2][0] = dice[1][2][0];
			dice[5][2][1] = dice[1][2][1];
			dice[5][2][2] = dice[1][2][2];
			
			dice[1][2][0] = dice[4][2][0];
			dice[1][2][1] = dice[4][2][1];
			dice[1][2][2] = dice[4][2][2];
			
			dice[4][2][0] = tmp[0];
			dice[4][2][1] = tmp[1];
			dice[4][2][2] = tmp[2];
			break;
		case 'B':
			// 면
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					tmpP[i][j] = dice[0][i][j];
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					dice[0][i][j] = tmpP[2-j][i];
				}
			}
			
			//주변
			tmp = new char[] { dice[4][0][0], dice[4][0][1], dice[4][0][2] };
			
			dice[4][0][0] = dice[1][0][0];
			dice[4][0][1] = dice[1][0][1];
			dice[4][0][2] = dice[1][0][2];
			
			dice[1][0][0] = dice[5][0][0];
			dice[1][0][1] = dice[5][0][1];
			dice[1][0][2] = dice[5][0][2];
			
			dice[5][0][0] = dice[3][2][2];
			dice[5][0][1] = dice[3][2][1];
			dice[5][0][2] = dice[3][2][0];
			
			
			dice[3][2][2] = tmp[0];
			dice[3][2][1] = tmp[1];
			dice[3][2][0] = tmp[2];
			break;
		}
		
		
	}

}
