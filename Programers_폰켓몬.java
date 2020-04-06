import java.util.Arrays;

class Programers_폰켓몬 {

	public int solution(int[] nums) {

		Arrays.sort(nums);
		int idx = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i])
				continue;
			idx++;
		}

		return nums.length / 2 >= idx ? idx : nums.length / 2;
	}
}
