Analysis: 
    1. 

Solutions:

1. 查重
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        backtrack(results, new ArrayList<>(), nums);
        return results;
    }

    private void backtrack(List<List<Integer>> results,
                           List<Integer> list,
                           int[] nums) {
        if (list.size() == nums.length) {
            results.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                backtrack(results, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}

2. Bottom up 
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) return results;
        collect(results, new ArrayList<>(), nums, 0);
        return results;
    }

    private void collect(List<List<Integer>> results,
                         List<Integer> list,
                         int[] nums,
                         int index) {
        if (list.size() == nums.length) {
            results.add(list);
            return;
        }
        for (int i = 0; i <= list.size(); ++i) {
            List<Integer> tmpList = new ArrayList<>(list);
            tmpList.add(i, nums[index]);
            collect(results, tmpList, nums, index + 1);
        }
    }
}

3. 迭代
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        if (nums == null || nums.length == 0) return results;
        results.add(new ArrayList<>());
        for (int num : nums) {
            int size = results.size();
            while (size > 0) {
                List<Integer> r = results.pollFirst();
                for (int i = 0; i <= r.size(); ++i) {
                    List<Integer> t = new ArrayList<>(r);
                    t.add(i, num);
                    results.add(t);
                }
                --size;
            }
        }
        return results;
    }
}