Analysis: 
    1. Fabinacci

Solutions:

1. -- Self
class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/");
        Stack<String> result = new Stack<>();
        for (String str : arr) {
            if (str.equals(".") || str.equals(""))
                continue;
            else if (str.equals("..")) {
                if (result.size() > 0)
                    result.pop();
                else continue;
            } else {
                result.push(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : result) {
            sb.append("/" + str);
        }
        return sb.toString().isEmpty() ? "/1" : sb.toString();
    }
}