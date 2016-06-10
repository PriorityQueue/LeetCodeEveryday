/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private Map<TreeNode, ArrayList<Stack<TreeNode>>> container;
    public List<String> binaryTreePaths(TreeNode root) {
        if(root ==null)
        return new ArrayList<String>();
        container = new HashMap<>();
        postorder(root);
        ArrayList<Stack<TreeNode>> result = container.get(root);
        ArrayList<String> realResult = new ArrayList<>();
        for (Stack<TreeNode> s:result)
        {
            StringBuilder sb=new StringBuilder();
            sb.append(Integer.toString(s.pop().val));
            while(!s.isEmpty())
            {
                sb.append("->");
                TreeNode t=s.pop();
                sb.append(Integer.toString(t.val));
            }
            realResult.add(sb.toString());
        }
        return realResult;
    }

    public void postorder(TreeNode t) {
        if (t != null) {
            postorder(t.left);
            postorder(t.right);
            if (t.left == null && t.right == null) {
                ArrayList<Stack<TreeNode>> arrayList = new ArrayList<>();
                Stack<TreeNode> s = new Stack<>();
                s.push(t);
                arrayList.add(s);
                container.put(t, arrayList);
            } else {
                if (t.left != null) upDate(t,t.left);
                if (t.right !=null) upDate(t,t.right);
            }
        }
    }

    private void upDate(TreeNode t,TreeNode child) {
        ArrayList<Stack<TreeNode>> a = container.get(child);
        if (a != null) {
            for (Stack<TreeNode> s : a) {
                s.push(t);
                if (!container.containsKey(t)) {
                    ArrayList<Stack<TreeNode>> a1 = new ArrayList<>();
                    a1.add(s);
                    container.put(t, a1);
                } else {
                    container.get(t).add(s);
                }
            }
        }
    }
}
