package Assignments;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTargetSumWays {
    public static void main(String[] args) {
        int i = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(i);
    }

    private static int[] removeFirst(int[] arr) {

        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            newArr[i] = arr[i + 1];
        }

        return newArr;
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int count = recursive(nums, target, 0);
        return count;
    }

    private static int recursive(int[] nums, int target, int result) {
        if (result == target && nums.length == 0) {
            return 1;
        }

        if (nums.length == 0) {
            return 0;
        }

        int count = 0;
        int firstElem = nums[0];
        int[] modified = removeFirst(nums);
        int left = count + recursive(modified, target, result + firstElem);
        int right = count + recursive(modified, target, result - firstElem);

        return left + right; 
    }
    int ans;
    void solve(int[] nums, int target, int currSum, int index) {
        if(index == nums.length) {
            if(currSum == target) {
                ans++;
            }
            return;
        }
        
        solve(nums, target, currSum + nums[index], index+1);
        solve(nums, target, currSum - nums[index], index+1);
    }
}
