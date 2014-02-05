/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, IntervalComparator);
        ArrayList<Interval> res = new ArrayList<Interval>();
        int i=0;
        while(i<intervals.size()){
            int j=i+1;
            int end = intervals.get(i).end;
            while(j<intervals.size()&&intervals.get(j).start<=end){
                end=Math.max(end, intervals.get(j).end);
                j++;
            }
            res.add(new Interval(intervals.get(i).start, end));
            i=j;
        }
        return res;
    }
    
    public Comparator<Interval> IntervalComparator = new Comparator<Interval>(){
      public int compare(Interval i1, Interval i2){
          return (int)(i1.start - i2.start);
      }  
    };
}
