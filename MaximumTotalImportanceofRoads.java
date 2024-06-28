class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        vector<int> deg(n);
        for(auto& e : roads) {
            deg[e[0]]++;
            deg[e[1]]++;
        }
        
        sort(deg.begin(), deg.end());
        long long ans = 0;
        for(int i = 0; i < n; i++) {
            ans += (i + 1ll) * deg[i];
        }
        return ans;
    }
};
