package ArraysPrac.Searching;

/**
 * KthMissing   
 */
public class KthMissing {

    public static void main(String[] args) {
        int[] arr = { 4, 8, 9 };
        int k = 4;
        int ans = findKthPositive(arr, k);
        System.out.println(ans);
    }

    public static int findKthPositive(int[] arr, int k) {
        int start=0, end=arr.length-1;
        
        while (start<end) {
            int mid = start + (end-start)/2;
            if (arr[mid]-(mid+1)>=k) {
                end=mid-1;
            } else {
                start=mid;
                if (arr[end]-(end+1)>=k) end--;
                else start++;
            }
        }
        
        if (arr[start]-(start+1)>=k) {
            return k;
        } else {
            return start+1+k;
        }
    }
}