class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}

// 2.
class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        Stack<String> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !temp.equals("")) {
                stack.push(temp);
                temp = "";
            } else if (s.charAt(i) != ' ') {
                temp += s.charAt(i);
            }
        }
        if (temp != "") {
            stack.push(temp);
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
            if (stack.size() > 0) {
                result += " ";
            }
        }

        return result;
    }
}
