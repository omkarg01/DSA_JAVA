public class MinNumPages {
    public static void main(String[] args) {
        int[] A = { 1, 2, 3, 1, 1 };
        int N = A.length;
        int M = 4;
        int min = findPages(A, N, M);
        System.out.println(min);

    }

    public static int findPages(int[] A, int N, int M) {
        if (N < M) {
            return -1;
        }
        // Your code here
        int start = A[N - 1];
        int end = 0;
        for (int each : A) {
            end += each;
        }
        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(A, N, M, mid)) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }

    public static boolean isValid(int[] A, int N, int M, int mx) {
        int stud = 1;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            if (sum > mx) {
                stud++;
                sum = A[i];
            }
            if (stud > M) {
                return false;
            }
        }
        return true;
    }
}
