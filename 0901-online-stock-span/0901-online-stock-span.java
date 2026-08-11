import java.util.ArrayDeque;
import java.util.Deque;

class StockSpanner {
    // Stack stores pairs of [price, span]
    private Deque<int[]> stack;

    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Pop elements while price is greater than or equal to top stack price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push current price and its combined span
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */