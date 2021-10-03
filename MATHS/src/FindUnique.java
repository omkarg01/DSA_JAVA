
public class FindUnique {
    public static void main(String[] args) throws Exception {
        int[] arr = { 5, 5, 8, 3, 3, 3, 8, 5, 1, 2, 1, 1, 8 };
        System.out.println(findExtra(arr, 3));
    }

    private static int findExtra(int[] arr, int n) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum % 3;
    }

    private static int ans(int[] arr) {
        int unique = 0;
        for (int i : arr) {
            unique ^= i;
            System.out.println(unique);
        }
        return unique;
    }

}
