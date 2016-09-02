public class CountCompleteTreeNodes_NO222 {

    public int countNodes(TreeNode root) {
        //树的递归遍历
        if (root == null)
            return 0;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes2(TreeNode root) {
        //树的层序遍历
        if(root == null)
            return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int layers = 0;
        int leaves = 0;
        TreeNode p = root;
        while (q.isEmpty() == false) {
            TreeNode t = q.removeFirst();
            if (t.left != null)
                q.add(t.left);
            if (t.right != null)
                q.add(t.right);
            if (t == p) {
                layers++;
                if(q.isEmpty() == false)
                    p =  q.getLast();
                TreeNode first = q.getFirst();
                if (first.right == null && first.left == null)
                    leaves = q.size();
            }
        }
        if(layers > 1)
            return  ((2<<(layers-1))-1 + leaves);
        else
            return 1;

    }
    public int countNodes3(TreeNode root){
        // 每次通过判断该点的右子树的高度是否与整个树的高度减一相等来判断左子树是否已满，
        //若右子树的高度与整棵树的高度相差为1，说明最底层的子节点从左子树一直排到了右子树，
        //则说明左子树为完全二叉树，高度已知可以算出其节点个数，而右子树的节点个数还是未知，继续递归右子树的右子树
        //若右字数的高度与整个树的高度相差大于1，(那么肯定是相差2),则可以知道右子树是一个高度为树高-2的完全2叉树，可以计算其节点数
        //而左子树未知，递归计算左字数的右子树的高度。
        int h = height(root);
        int nodes = 0;
        while(root != null){
            if (height(root.right) == h-1)
            {
                nodes += (1<<h-1);//不减一是因为要加上根结点
                root = root.right;
            }else{
                nodes += (1<<(h-2));//不减一是因为要加上根结点
                root = root.left;
            }
            --h;
        }
        return nodes;
    }


    //一颗完全二叉树的高度可以通过不断递归计算其右子树来获得。
    private int height(TreeNode t )
    {
        return t==null ? 0:1+height( t.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}