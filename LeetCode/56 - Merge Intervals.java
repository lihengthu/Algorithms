Analysis: 
    1. 

Solutions:

1. // Java 8 lambda comparator and for-each loop 
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        List<Interval> result = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end)
                end = Math.max(end, interval.end);
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
2. // Similar idea
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        Collections.sort(intervals,new Comparator<Interval>() {
           public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;       
           } 
        });
        int i = 0;
        while(i < intervals.size()-1) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i+1);
            if(next.start <= current.end) {
                int max = Math.max(next.end, current.end);
                current.end = max;
                intervals.remove(i+1);
            } else {
                i++;
            }
        }
        return intervals;
    }
}
3. // 使用ListIterator，效率并不高
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        ListIterator<Interval> it = intervals.listIterator();
        Interval cur = it.next();
        while (it.hasNext()) {
            Interval next = it.next();
            if (cur.end < next.start) {
                cur = next;
                continue;
            } else {
                cur.end = Math.max(cur.end, next.end);
                it.remove();
            }
        }
        return intervals;
    }
}
4. // fastest
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}