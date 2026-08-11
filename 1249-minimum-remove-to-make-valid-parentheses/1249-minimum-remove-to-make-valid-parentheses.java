class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(sb.length());
                sb.append(ch);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }
        
        // Remove unmatched '(' starting from the end
        while (!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        
        return sb.toString();
    }
}