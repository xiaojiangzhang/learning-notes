package leetcode.leetcode.editor.cn;

public class FindStartingandTarget {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        int target = 1;
        int left = 6;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;

            } else if (nums[mid] < target) {
                left = mid + 1;

            } else {
                break;
            }
        }
        System.out.println(mid);
    }
}
