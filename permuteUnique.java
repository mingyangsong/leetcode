public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        permuteUnique(num, new ArrayList<Integer>(), new boolean[num.length], res);
        return res;
    }
    
    public void permuteUnique(int[] num, ArrayList<Integer> cur, boolean[] visit, ArrayList<ArrayList<Integer>> res){
        if(cur.size()==num.length){
            ArrayList<Integer> temp = new ArrayList<Integer>(cur);
            res.add(temp);
            return;
        }
        
        for(int i=0;i<num.length;i++){
            if(!visit[i]){
                if(i>0&&num[i-1]==num[i]&&visit[i-1])
                    continue;
                visit[i]=true;
                cur.add(num[i]);
                permuteUnique(num, cur,visit, res);
                cur.remove(cur.size()-1);
                visit[i]=false;
            }
        }
    }
}
