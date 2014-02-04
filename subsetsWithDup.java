public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        subsetsWithDup(num, 0, new ArrayList<Integer>(), res);
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    public void subsetsWithDup(int[] num, int index, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res){
        for(int i=index;i<num.length;i++){
            cur.add(num[i]);
            res.add(new ArrayList<Integer>(cur));
            subsetsWithDup(num, i+1, cur, res);
            cur.remove(cur.size()-1);
            while(i<num.length-1&&num[i+1]==num[i])
                i++;
        }
    }
}
