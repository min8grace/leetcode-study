/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    bool isEqual(TreeNode* root, TreeNode* subRoot){
        if(!root || !subRoot) return root==subRoot;
        if(root->val!=subRoot->val) return false;
        return isEqual(root->left,subRoot->left) && isEqual(root->right,subRoot->right);
    }
    
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        if(!root) return false;
        if(isEqual(root,subRoot)) return true;
        return isSubtree(root->left,subRoot) || isSubtree(root->right,subRoot);
    }
};


/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    bool isEqual(TreeNode* s, TreeNode* t){
        if(!s || !t) return s==t;   // both null
        return (s->val==t->val) && isEqual(s->left,t->left) && isEqual(s->right,t->right);
    }
    
    bool isSubtree(TreeNode* root, TreeNode* subRoot) {
        return isEqual(root,subRoot) || (root->left && isSubtree(root->left,subRoot)) || (root->right && isSubtree(root->right,subRoot));
    }
};