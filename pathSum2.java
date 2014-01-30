public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return res;
		ArrayList<ArrayList<Integer>> cur = hasPathSum(root);
		for (ArrayList<Integer> a : cur) {
		    int cur_sum = 0;
			for(int b : a){
			    cur_sum+=b;
			}
			if(cur_sum == sum)
			    res.add(a);
		}
		return res;
	}

	public ArrayList<ArrayList<Integer>> hasPathSum(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root.left == null && root.right == null) {
		    ArrayList<Integer> cur = new ArrayList<Integer>();
		    cur.add(root.val);
			res.add(cur);
			return res;
		}
		if (root.left != null) {
			res.addAll(hasPathSum(root.left));
		}
		if (root.right != null) {
			res.addAll(hasPathSum(root.right));
		}
		for (ArrayList<Integer> a : res) {
			a.add(0, root.val);
		}
		return res;
	}
}
