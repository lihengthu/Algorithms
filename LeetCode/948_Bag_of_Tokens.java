1. Discuss
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
         Arrays.sort(tokens);
         int res = 0, points = 0, i = 0, j = tokens.length - 1;
         while (i <= j){
             if (P >= tokens[i]){
                 P -= tokens[i++];
                 res = Math.max(res, ++points);
             } else if (points > 0){
                 --points;
                 P += tokens[j--];
             } else {
                 break;
             }
         }
         return res;
    }
}

2.Solution - 个人感觉不如Discuss中解法逻辑清晰
class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1;
        int points = 0, ans = 0;
        while (lo <= hi && (P >= tokens[lo] || points > 0)) {
            while (lo <= hi && P >= tokens[lo]) {
                P -= tokens[lo++];
                points++;
            }

            ans = Math.max(ans, points);
            if (lo <= hi && points > 0) {
                P += tokens[hi--];
                points--;
            }
        }

        return ans;
    }
}