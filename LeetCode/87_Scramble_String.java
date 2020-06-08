import java.util.Arrays;

// 用一个数组dp[n][i][j]表示s1[i..i+n-1]和s2[j..j+n-1]两个子串是否是scramble的
// 初始条件：当长度为1时，如果字符串相等就符合，否则不符合。
// 当长度为n时，将字符串表示的树的根节点放在第2至n-1元素上。某一边的子树为空时无意义的，因为就是自身。也就是长度为n的字符串有n-1种情况，分别是1,k。k的取值范围是1到n-1。这n-1中情况，只要有一种符合，就说明这个长度为n的字符串符合。
// 每一种情况，又有两种方式，s1的前k个和s2的前k个比较，s1后n-k个和s2的后n-k比较。也可以是s1的前k个和s2的后k个比较。两种方式对应的就是这个子树不交换和交换的场景。
// 最后通过 dp[n][0][0]来判断整个字符串是否是攀爬字符串
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();

        char[] sortedS1 = s1.toCharArray();
        Arrays.sort(sortedS1);
        char[] sortedS2 = s2.toCharArray();
        Arrays.sort(sortedS2);
        if (!Arrays.equals(sortedS1, sortedS2)) {
            return false;
        }

        // dp[n][i][j]表示s1[i..i+n-1]和s2[j..j+n-1]两个子串是否是scramble的
        boolean[][][] dp = new boolean[n + 1][n][n];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == 0 || i == 1 && s1.charAt(j) == s2.charAt(k)) {
                        dp[i][j][k] = true;
                    } else {
                        dp[i][j][k] = false;
                    }
                }
            }
        }

        for (int len = 2; len < n + 1; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    // 计算长度为len的s1[i,i+len-1]和s2[j,j+len-1]是否是scramble的
                    // 通过遍历所有子串划分是否存在有一个满足即可
                    // k是s1部分的左子串的长度
                    for (int k = 1; k < len; k++) {
                        if (dp[k][i][j] && dp[len - k][i + k][j + k]
                                || dp[k][i][j + len - k] && dp[len - k][i + k][j]) {
                            dp[len][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        // 最后结果就是s1[0,n]和s2[0,n]是否匹配
        return dp[n][0][0];
    }
}