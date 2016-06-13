import java.util.LinkedList;
import java.util.List;

/**
 * Created by Admin on 2016/6/13.
 */
public class BinaryTreePaths2 {
    private void findPath(List<String> res, String s, TreeNode T){
        if(T==null)
            return ;
        if(T.left == null && T.right == null)
        {
            res.add(s+T.val);
        }
        findPath(res,s+T.val+"->",T.left);
        findPath(res,s+T.val+"->",T.right);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        findPath(res,"",root);
        return  res;
    }
}
class TreeNode {
    int val;
    com.leet_code.TreeNode left;
    com.leet_code.TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}