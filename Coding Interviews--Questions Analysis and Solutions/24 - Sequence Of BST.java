Analysis:


Solutions:
1. 关键在于静心分析出规律
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    private boolean judge(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int root = sequence[end];
        int index = start;
        while (sequence[index] < root)
            ++index;
        for (int i = index; i < end; ++i)
            if (sequence[i] < root)
                return false;
        return judge(sequence, start, index - 1) && judge(sequence, index, end - 1);
    }
}