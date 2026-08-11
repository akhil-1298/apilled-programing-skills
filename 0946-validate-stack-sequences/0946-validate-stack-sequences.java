import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer for popped array

        for (int val : pushed) {
            stack.push(val);
            // Check if top of stack matches current target in popped
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If all popped elements were matched, sequence is valid
        return j == popped.length;
    }
}
            