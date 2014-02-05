public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0)
            return 0;
        int[][] height = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0'){
                     height[i][j] = 0;
                 }else {
                     height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
                 }
             }
         }

		int max = 0;
		for (int i = 0; i < matrix.length; i++) {
			max = Math.max(max, largestRectangleArea(height[i]));
		}
		return max;
    }
    
    public int largestRectangleArea(int[] height) {
		if (height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			if (stack.isEmpty() || height[stack.peek()] < height[i]) {
				stack.push(i);
			} else {
				int start = stack.pop();
				int width = stack.isEmpty() ? i : i - stack.peek() - 1;
				sum = Math.max(sum, height[start] * width);
				i--;
			}
		}
		while (!stack.isEmpty()) {
			int start = stack.pop();
			int width = stack.isEmpty() ? height.length : height.length
					- stack.peek() - 1;
			sum = Math.max(sum, height[start] * width);
		}
		return sum;
	}
}
