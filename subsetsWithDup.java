public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res=subsetsWithDup(num, 0, new ArrayList<Integer>());
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int index, ArrayList<Integer> cur){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int i=index;i<num.length;i++){
            cur.add(num[i]);
            res.add(new ArrayList<Integer>(cur));
            res.addAll(subsetsWithDup(num, i+1, cur));
            cur.remove(cur.size()-1);
            while(i<num.length-1&&num[i+1]==num[i])
                i++;
        }
        return res;
    }
}
