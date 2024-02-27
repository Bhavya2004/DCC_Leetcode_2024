class Solution {
    public int heightOfTree(TreeNode root){ //max nodes in one line
       if(root == null){
           return 0;
       }

       int leftheight=heightOfTree(root.left);
       int rightheight=heightOfTree(root.right);
       int ans=Math.max(leftheight,rightheight) + 1;

       return ans;
   }
   public int diameterOfBinaryTree(TreeNode root) {
       if(root == null){
           return 0;
       }

       int op1=diameterOfBinaryTree(root.left);
       int op2=diameterOfBinaryTree(root.right);
       int op3=heightOfTree(root.left)+heightOfTree(root.right);
       int ans=Math.max(op1,Math.max(op2,op3));
       return ans;
   }
}
