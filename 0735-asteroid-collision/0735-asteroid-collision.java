import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean exploded = false;

            // Collision condition: Top of stack is moving RIGHT (> 0) and current is moving LEFT (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (Math.abs(stack.peek()) < Math.abs(a)) {
                    stack.pop(); // Top asteroid is smaller; destroy it and continue loop
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(a)) {
                    stack.pop(); // Both asteroids are same size; destroy both
                }
                // Current asteroid exploded (either equal or smaller size)
                exploded = true;
                break;
            }

            // If the current asteroid didn't explode, push it to the stack
            if (!exploded) {
                stack.push(a);
            }
        }

        // Convert Stack to int array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}