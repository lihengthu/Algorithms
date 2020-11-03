class Solution {
    public String shortestPalindrome(String s) {
        if (isPalindrome(s)) {
            return s;
        }
        int end = s.length() - 1;
        for (int i = s.length() - 1; i > 0; i--) {
            if (isPalindrome(s.substring(0, i))) {
                end = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= end; i--) {
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
