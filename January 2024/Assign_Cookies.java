class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0;
        int sIndex = 0;
        int contentChildren = 0;

        while (gIndex < g.length && sIndex < s.length) {
            if (s[sIndex] >= g[gIndex]) {
                contentChildren++;
                gIndex++;
                sIndex++;
            } else {
                sIndex++;
            }
        }

        return contentChildren;
    }
}