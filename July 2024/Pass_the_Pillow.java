class Solution {
    public int passThePillow(int n, int time) {
        boolean forward = true;
        int currentPerson = 1;

        for (int i = 1; i <= time; i++) {
            if (forward) {
                if (currentPerson == n) {
                    forward = false;
                    currentPerson--;
                } else {
                    currentPerson++;
                }
            } else {
                if (currentPerson == 1) {
                    forward = true;
                    currentPerson++;
                } else {
                    currentPerson--;
                }
            }
        }

        return currentPerson;
    }
}