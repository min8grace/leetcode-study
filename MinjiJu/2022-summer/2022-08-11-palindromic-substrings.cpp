class Solution {
public:
    int countSubstrings(string s) {
        
        int count = 0;
        
        // dp table
        vector<vector<int>> dp(s.length(), vector<int>(s.length(),0));
        
        // fill 1's diagonally
        for(int i=0; i<s.length(); i++){
            dp[i][i] = 1;
            count++;
        }
        
        // count substrings
        for(int i=1; i<s.length(); i++){
            for(int j=0; j<i; j++){
                if((j+1==i && s[j]==s[i]) || (dp[j+1][i-1]==1 && s[i]==s[j])){
                    dp[j][i] = 1;
                    count++;
                }
            }
        }
        return count;
    }
};
