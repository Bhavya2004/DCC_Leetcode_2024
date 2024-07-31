class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
    int[][] dp=new int[books.length+1][shelfWidth+1];
    for(int[] a: dp){
        Arrays.fill(a,-1);
    }
        return recur(books,shelfWidth,0,0,shelfWidth,dp);

    }
    public int recur(int[][] books,int sw ,int ind,int mh,int rw,int[][] dp){
        if(ind>=books.length){
            return mh;
        }
        if(dp[ind][rw]!=-1){
            return dp[ind][rw];
        }
        int in= Integer.MAX_VALUE;
        int ex= Integer.MAX_VALUE;
        int ch=books[ind][1];
        int cw=books[ind][0];
        if(rw>=cw){
        in=recur(books,sw,ind+1,Math.max(mh,ch),rw-cw,dp);
        }
        ex=mh+recur(books,sw,ind+1,ch,sw-cw,dp);

        return dp[ind][rw]=Math.min(in,ex);
        
    }
}