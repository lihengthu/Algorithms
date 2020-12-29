class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int n = s.length();
        char[] array = s.toCharArray();
        int i = n - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && array[i] == ' ') {
                i--;
            }
            String word = "";
            while (i >= 0 && array[i] != ' ') {
                word = array[i] + word;
                i--;
            }
            if (word != "") {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(word);
            }
        }

        return sb.toString();
    }
}