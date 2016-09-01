public class CountCompleteTreeNodes_NO222 {

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int countNodes2(TreeNode root) {
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
        int h = height(root);
        int nodes = 0;
        while(root != null){
            if (height(root.right) == h-1)
            {
                nodes += (1<<h-1);
                root = root.right;
            }else{
                nodes += (1<<(h-2));
                root = root.left;
            }
            --h;
        }
        return nodes;
    }
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