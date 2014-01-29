public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        
        if(len1 + len2 != s3.length())
            return false;
        boolean dp[][] = new boolean[len1+1][len2+1];
        
        dp[0][0]=true;
        
        for(int i=1;i<=len1;i++){
            if(s1.substring(0,i).equals(s3.substring(0,i)))
                dp[i][0]=true;
            else
                break;
        }
        for(int i=1;i<=len2;i++){
            if(s2.substring(0,i).equals(s3.substring(0,i)))
                dp[0][i]=true;
            else
                break;
        }
        
        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++){
                if((dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(i+j-1))||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(i+j-1)))
                    dp[i][j]=true;
            }
        return dp[len1][len2];
    }
}
