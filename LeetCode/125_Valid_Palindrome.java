class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            char lch = s.charAt(l);
            char rch = s.charAt(r);
            if (!Character.isLetterOrDigit(lch)) {
                l++;
            } else if (!Character.isLetterOrDigit(rch)) {
                r--;
            } else {
                if (lch != rch) {
                    return false;
                }
                l++;
                r--;
            }
        }

        return true;
    }
}
