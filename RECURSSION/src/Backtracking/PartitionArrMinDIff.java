package Backtracking;

public class PartitionArrMinDIff {
    public static void main(String[] args) {
        int[] nums = { -7016943, 0, 2205243, -794066, -6795006, 5322408, 9699476, 6544247, 6992622, 7272161, 5469637,
                4806999, -8562708, -5242263, 9037593, -2746735, 8072395, -1386148, 4745179, 3801334, -4086041, 0,
                555427, -9249908, 5045948, -7943170, 1665466, 9514306, 7960606, -142676 };
        minimumDifference(nums);
        System.out.println(min);
    }

    public static int minimumDifference(int[] nums) {
        solve(nums, 0, 0, 0, 0, 0);
        return min;
    }

    static int min = Integer.MAX_VALUE;

    public static void solve(int[] nums, int setSum1, int setSum2, int index, int set1length, int set2length) {
        if (index == nums.length) {
            int diff = Math.abs(setSum1 - setSum2);
            if (diff < min) {
                min = diff;
            }
            return;
        }
        // set1[set1.length] = nums[index];
        if (set1length < (nums.length + 1) / 2) {
            solve(nums, setSum1 + nums[index], setSum2, index + 1, set1length + 1, set2length);
        }
        // set1
        if (set2length < (nums.length + 1) / 2) {
            solve(nums, setSum1, setSum2 + nums[index], index + 1, set1length, set2length + 1);
        }

    }

}

