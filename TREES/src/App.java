import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
    }


    public void levelOrder(TreeNode root) {
        if (root == null){
            return;
        }
        
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while (!q.isEmpty()){
            TreeNode removedNode = q.remove();
            System.out.println(removedNode);
            if (removedNode.left != null)
        	     q.add(removedNode.left);
            
            if (removedNode.right != null)
                 q.add(removedNode.right);
        }
        
    }
}
