public class ConvertSortArrToBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] arr = { -10, -3, 0, 5, 9 };
        TreeNode root = null;
        int mid = (arr.length - 1) / 2;
        root = bst(root, arr, 0, arr.length - 1, mid);

        inorder(root);
    }

    public static TreeNode bst(ConvertSortArrToBST.TreeNode root, int[] arr, int i, int j, int mid) {
        if (i > j) {
            return null;
        }

        root = new TreeNode(arr[mid]);
        int leftmid = (i + mid - 1) / 2;
        if (leftmid >= 0) {
            root.left = bst(root, arr, i, mid - 1, leftmid);
        }

        int rightmid = (mid + 1 + j) / 2;
        if (rightmid <= arr.length - 1) {
            root.right = bst(root, arr, mid + 1, j, rightmid);
        }

        return root;
    }

    private static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

    }
}
