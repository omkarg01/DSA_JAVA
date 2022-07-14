import java.util.ArrayList;
import java.util.List;

public class InorederTraversal {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(null);
        arr.add(2);
        arr.add(3);
        
        node.val = 1;
        TreeNode temp = new TreeNode(2);
        node.right = temp;
        temp.left = new TreeNode(3);

        List<Integer> root = bt(node);
        System.out.println(root);
    }

    private static List<Integer> bt(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        
        List<Integer> arr = new ArrayList<>();
        List<Integer> left = bt(root.left);
        arr.addAll(left);
        arr.add(root.val);
        List<Integer> right = bt(root.left);
        arr.addAll(right);
        
        return arr;
    }

}
