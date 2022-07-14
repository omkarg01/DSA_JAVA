public class CeilInSorted {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 8, 10, 10, 19 };
        int target = -5;

        int ans = bs(arr, target, arr.length);
        System.out.println(ans);
    }

    private static int bs(int[] arr, int target, int length) {
        if (arr[0] > target) {
            return 0;
        }
        int s = 0;
        int e = length - 1;

        int ans = -1;
        while (s <= e) {
            int mid = s + (e-s)/2;

            if (arr[mid] == target){
                ans = mid;
                return ans;
            }else if(arr[mid] < target){
                ans = mid;
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        return ans;
    }
}
