package ArraysPrac.Searching;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 1;
        System.out.println(isValidSqaure(num));
    }

    private static boolean isValidSqaure(int num) {
        if (num < 1)
            return false;
        int start = 1;
        int end = num;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (num == mid * mid) {
                return true;
            } else if (mid > num / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }

}
