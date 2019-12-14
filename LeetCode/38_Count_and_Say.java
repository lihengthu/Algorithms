class Solution {
    public String countAndSay(int n) {
        String tmp = "1";
        for (int i = 1; i < n; ++i) {
            tmp = convert(tmp);
        }
        return tmp;
    }

    private String convert(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                cnt++;
            } else {
                sb.append(cnt).append(str.charAt(i - 1));
                cnt = 1;
            }
        }
        sb.append(cnt).append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}