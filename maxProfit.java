public class Solution {
    public int maxProfit(int[] prices) {
		if(prices.length == 0){  
            return 0;  
        }  
        int max = 0;  
        int[] left = new int[prices.length]; 
        int[] right = new int[prices.length];  
          
        process(prices, left, right);  
          
        for(int i=0; i<prices.length; i++){  
            max = Math.max(max, left[i]+right[i]);  
        }  
          
        return max;  
    }  
    
    public static void process(int[] prices, int[] left, int[] right){  
        left[0] = 0;  
        int min = prices[0]; 
        for(int i=1; i<left.length; i++){
            min = Math.min(min, prices[i]); 
            left[i] = Math.max(left[i-1], prices[i]-min);     
        }  
        
        right[right.length-1] = 0;  
        int max = prices[right.length-1];    
        for(int i=right.length-2; i>=0; i--){ 
            max = Math.max(max, prices[i]);
            right[i] = Math.max(right[i+1], max-prices[i]);   
        }  
    }  
}
